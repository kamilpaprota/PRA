package pl.edu.amu.pracprog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Zawodnik;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class JacksonSerialization {

    final static Logger logger = Logger.getLogger(JacksonSerialization.class);

    public static void serializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        Zawodnik zawodnik = objectsCreator.getEmp();

        //Serialize to file and string
        mapper.writeValue(new File("result." + fileSuffix), zawodnik);
        String jsonString = mapper.writeValueAsString(zawodnik);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);

        //Deserialize from file
        Zawodnik deserializedZawodnik = mapper.readValue(
                new File("result." + fileSuffix), Zawodnik.class);


        //Serialize back
        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedZawodnik);
        String modifiedJsonString = mapper.writeValueAsString(deserializedZawodnik);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);

        //Serialize generic List
        List<Zawodnik> zawodnicy = objectsCreator.getZawodnicy();
        String zawodnicyListSerialized = mapper.writeValueAsString(zawodnicy);
        logger.info("Printing serialized zawodnicy list " + fileSuffix);
        System.out.println(zawodnicyListSerialized);
    }

    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Deserialized employee object from employees.* file in resources
        InputStream zawodnikIs = JacksonSerialization.class.getClassLoader().
                getResourceAsStream("zawodnik." + fileSuffix);
        Zawodnik deserializedZawodnik = mapper.readValue(zawodnikIs, Zawodnik.class);
        deserializedZawodnik.setGole(new Random().nextInt(100000));
        String modifiedSerialzied = mapper.writeValueAsString(deserializedZawodnik);
        logger.info("Printing modified re-serialized zawodnik to" + fileSuffix);
        System.out.println(modifiedSerialzied);

        // Deserialize employees list
        InputStream zawodnicyIs = JacksonSerialization.class.getClassLoader().getResourceAsStream("zawodnicy." + fileSuffix);

        List<Zawodnik> zawodnicy = mapper.readValue(zawodnicyIs, List.class);

        System.out.println("Number of deserialized zawodnicy: " + zawodnicy.size());
    }

    public static void main(String[] args) throws IOException {


        ObjectMapper jsonMapper = new ObjectMapper();
        serializeDemo(jsonMapper, "json");
        deserializeDemo(jsonMapper, "json");

        ObjectMapper xmlMapper = new XmlMapper();
        serializeDemo(xmlMapper, "xml");
        deserializeDemo(xmlMapper, "xml");

    }
}
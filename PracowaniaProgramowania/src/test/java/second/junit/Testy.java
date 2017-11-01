package second.junit;

import third.quartz.Czas;
import third.quartz.SQL;

import example.HelloWorld;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class Testy {

    AdvanceMath math;
    Czas c;
    SQL d;
    final static Logger logger = Logger.getLogger(AdvanceMath.class);

    HelloWorld hello;

    @Before
    public void setUp(){
        logger.info("Odpalam setUpa");
        math = new AdvanceMath();
        c = new Czas();
        d = new SQL();
    }
    @Test
    public void SQLTest1()
    {
        Boolean p = d.isCorrectquerry("select * from * order by ASC");
        assertTrue(p == true);
    }
    @Test
    public void SQLTest2()
    {
        Boolean p = d.isCorrectquerry("select * order by ASC * from *");
        assertTrue(p == false);
    }
    @Test
    public void CzasTest1()
    {
        Boolean p = c.getBreak(10,07);
        assertTrue(p == false);
    }
    @Test
    public void CzasTest2()
    {
        Boolean p = c.getBreak(15,15);
        assertTrue(p == true);
    }

}

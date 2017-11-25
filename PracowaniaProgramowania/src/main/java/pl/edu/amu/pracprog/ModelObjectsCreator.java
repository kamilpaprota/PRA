package pl.edu.amu.pracprog;

import hibernate.model.Statystyki;
import hibernate.model.Klub;
import hibernate.model.Zawodnik;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {

    Zawodnik emp, emp1, emp2, emp3, emp4, emp5;
    Zawodnik emp6, emp7, emp8, emp9, emp10, emp11;
    Klub address;

    List<Zawodnik> zawodnicy;

    public Zawodnik getEmp() {
        return emp;
    }

    public Zawodnik getEmp1() {
        return emp1;
    }

    public Zawodnik getEmp2() {
        return emp2;
    }

    public Zawodnik getEmp3() {
        return emp3;
    }

    public Zawodnik getEmp4() {
        return emp4;
    }

    public Zawodnik getEmp5() {
        return emp5;
    }

    public Zawodnik getEmp6() {
        return emp6;
    }

    public Klub getAddress() {
        return address;
    }

    public List<Zawodnik> getZawodnicy() {
        return zawodnicy;
    }

    public void init(){
        /*emp = new Zawodnik();
        emp.setFirstName("ELDO");
        emp.setLastName("Polak" + new Random().nextInt());
        emp.setSalary(100);
        emp.setBirth(new DateTime(DateTime.now()));
        emp.setPesel(Math.abs(new Random().nextInt()));

        emp3 = new Zawodnik();
        emp3.setFirstName("ELDO2");
        emp3.setLastName("Polak" + new Random().nextInt());
        emp3.setSalary(100);
        emp3.setBirth(new DateTime(DateTime.now()));
        emp3.setPesel(Math.abs(new Random().nextInt()));

        emp2 = new Zawodnik();
        emp2.setFirstName("ZIOMBO");
        emp2.setLastName("Polak" + new Random().nextInt());
        emp2.setSalary(100);
        emp2.setPesel(Math.abs(new Random().nextInt()));



        //add address
        Klub klub = new Klub();
        address.setCity("poznan");
        address.setStreet("poznanska");
        address.setNr("1");
        address.setPostcode("99090");

        emp.setAddress(address);
        emp3.setAddress(address);
        emp2.setAddress(address);


        emp.getSubworkers().add(emp2);
        emp2.getSubworkers().add(emp);

        employees = new ArrayList<Zawodnik>();
        employees.add(emp);
        employees.add(emp3);
        employees.add(emp2);*/

        //Real
        emp = new Zawodnik();
        emp.setImię("Zinedine");
        emp.setNazwisko("Zidane");
        emp.setPozycja("Trener");

        emp1 = new Zawodnik();
        emp1.setImię("Cristiano");
        emp1.setNazwisko("Ronaldo");
        emp1.setPozycja("Środkowy napastnik");
        emp1.setGole(1);

        emp2 = new Zawodnik();
        emp2.setImię("Karim");
        emp2.setNazwisko("Benzema");
        emp2.setPozycja("Środkowy napastnik");
        emp2.setGole(1);

        emp3 = new Zawodnik();
        emp3.setImię("Gareth");
        emp3.setNazwisko("Bale");
        emp3.setPozycja("Prawy napastnik");
        emp3.setGole(2);

        emp4 = new Zawodnik();
        emp4.setImię("Marco");
        emp4.setNazwisko("Asensio");
        emp4.setPozycja("Lewy napastnik");
        emp4.setGole(4);

        emp5 = new Zawodnik();
        emp5.setImię("Lucas");
        emp5.setNazwisko("Vazquez");
        emp5.setPozycja("Prawy napastnik");
        emp5.setGole(1);

        emp.getZawodnicy().add(emp1);
        emp.getZawodnicy().add(emp2);
        emp.getZawodnicy().add(emp3);
        emp.getZawodnicy().add(emp4);
        emp.getZawodnicy().add(emp5);

        //Barca
        emp6 = new Zawodnik();
        emp6.setImię("Ernesto");
        emp6.setNazwisko("Valverde");
        emp6.setPozycja("Trener");

        emp7 = new Zawodnik();
        emp7.setImię("Lionel");
        emp7.setNazwisko("Messi");
        emp7.setPozycja("Prawy napastnik");
        emp7.setGole(12);

        emp8 = new Zawodnik();
        emp8.setImię("Luis");
        emp8.setNazwisko("Suarez");
        emp8.setPozycja("Środkowy napastnik");
        emp8.setGole(5);

        emp9 = new Zawodnik();
        emp9.setImię("Arda");
        emp9.setNazwisko("Turan");
        emp9.setPozycja("Lewy napastnik");
        emp9.setGole(0);

        emp10 = new Zawodnik();
        emp10.setImię("Paco");
        emp10.setNazwisko("Alcacer");
        emp10.setPozycja("Środkowy napastnik");
        emp10.setGole(2);

        emp11 = new Zawodnik();
        emp11.setImię("Gerard");
        emp11.setNazwisko("Deulofeu");
        emp11.setPozycja("Prawy napastnik");
        emp11.setGole(1);

        emp6.getZawodnicy().add(emp7);
        emp6.getZawodnicy().add(emp8);
        emp6.getZawodnicy().add(emp9);
        emp6.getZawodnicy().add(emp10);
        emp6.getZawodnicy().add(emp11);

        /*emp1.getPlayers().add(emp);
        emp2.getPlayers().add(emp);
        emp3.getPlayers().add(emp);
        emp4.getPlayers().add(emp);
        emp5.getPlayers().add(emp);*/


        Klub klub = new Klub();
        klub.setNazwa("Real Madryt");
        Klub klub1 = new Klub();
        klub1.setNazwa("FC Barcelona");


        Statystyki statystykiRonaldo = new Statystyki();
        statystykiRonaldo.setWzrost(185);
        statystykiRonaldo.setWaga(80);
        statystykiRonaldo.setWiek(32);

        Statystyki statystykiBenzema = new Statystyki();
        statystykiBenzema.setWzrost(187);
        statystykiBenzema.setWaga(79);
        statystykiBenzema.setWiek(30);

        Statystyki statystykiBale = new Statystyki();
        statystykiBale.setWzrost(183);
        statystykiBale.setWaga(74);
        statystykiBale.setWiek(28);

        Statystyki statystykiAsensio = new Statystyki();
        statystykiAsensio.setWzrost(180);
        statystykiAsensio.setWaga(75);
        statystykiAsensio.setWiek(21);

        Statystyki statystykiLucas = new Statystyki();
        statystykiLucas.setWzrost(173);
        statystykiLucas.setWaga(70);
        statystykiLucas.setWiek(26);


        Statystyki statystykiMessi = new Statystyki();
        statystykiMessi.setWzrost(170);
        statystykiMessi.setWaga(72);
        statystykiMessi.setWiek(30);

        Statystyki statystykiSuarez = new Statystyki();
        statystykiSuarez.setWzrost(182);
        statystykiSuarez.setWaga(86);
        statystykiSuarez.setWiek(30);

        Statystyki statystykiTuran = new Statystyki();
        statystykiTuran.setWzrost(175);
        statystykiTuran.setWaga(76);
        statystykiTuran.setWiek(30);

        Statystyki statystykiPaco = new Statystyki();
        statystykiPaco.setWzrost(175);
        statystykiPaco.setWaga(71);
        statystykiPaco.setWiek(24);

        Statystyki statystykiDeu = new Statystyki();
        statystykiDeu.setWzrost(177);
        statystykiDeu.setWaga(73);
        statystykiDeu.setWiek(23);
        //address.setStreet("poznanska");
        //address.setNr("1");
        //address.setPostcode("99090");

        emp1.setStatystyki(statystykiRonaldo);
        emp2.setStatystyki(statystykiBenzema);
        emp3.setStatystyki(statystykiBale);
        emp4.setStatystyki(statystykiAsensio);
        emp5.setStatystyki(statystykiLucas);
        emp7.setStatystyki(statystykiMessi);
        emp8.setStatystyki(statystykiSuarez);
        emp9.setStatystyki(statystykiTuran);
        emp10.setStatystyki(statystykiPaco);
        emp11.setStatystyki(statystykiDeu);

        emp.setKlub(klub);
        emp1.setKlub(klub);
        emp2.setKlub(klub);
        emp3.setKlub(klub);
        emp4.setKlub(klub);
        emp5.setKlub(klub);
        emp6.setKlub(klub1);
        emp7.setKlub(klub1);
        emp8.setKlub(klub1);
        emp9.setKlub(klub1);
        emp10.setKlub(klub1);
        emp11.setKlub(klub1);



        //emp2.setAddress(address);
      //  emp.getSubworkers().add(emp2);
        //emp2.getSubworkers().add(emp);


        zawodnicy = new ArrayList<Zawodnik>();
        zawodnicy.add(emp);
        zawodnicy.add(emp1);
        zawodnicy.add(emp2);
        zawodnicy.add(emp3);
        zawodnicy.add(emp4);
        zawodnicy.add(emp5);
        zawodnicy.add(emp6);
        zawodnicy.add(emp7);
        zawodnicy.add(emp8);
        zawodnicy.add(emp9);
        zawodnicy.add(emp10);
        zawodnicy.add(emp11);


    }

    public ModelObjectsCreator(){
        init();
    }


}
package hibernate;

import hibernate.model.Zawodnik;
import hibernate.queries.Queries;
import pl.edu.amu.pracprog.ModelObjectsCreator;

import javax.persistence.*;
import java.util.List;

class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
            List<Zawodnik> zawodnicy = objectsCreator.getZawodnicy();

            for(int i = 0; i < zawodnicy.size(); i++)
            {
                entityManager.persist(zawodnicy.get(i));
            }
            Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
            List<Zawodnik> resultquery = query.getResultList();


            System.out.println("\n\n\n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("                 ZAPYTANIA SQL                 ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Najlepszy strzelec: ");
            chooseNajlepszyStrzelec(entityManager);
            System.out.println("\n");
            System.out.println("Grubaski ( >=80kg ): ");
            chooseGrubaski(entityManager);
            System.out.println("\n");
            System.out.println("Stronnicowane 8 osób od drugiej osoby: ");
            chooseOsiemosob(entityManager);
            System.out.println("\n");
            System.out.println("Ile wzrostu ma najniższy zawodnik: ");
            chooseMaluszek(entityManager);
            System.out.println("\n");
            System.out.println("Ile goli średnio strzelili piłkarze FC Barcelona: ");
            chooseGoleBarcelony(entityManager);
            //changeFirstGuyToNowak(entityManager);

            //entityManager.getTransaction().commit();

            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    // read a page of empleyees and change first one to Nowak
    static void chooseNajlepszyStrzelec(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
        List<Zawodnik> zawodnicy = new Queries(entityManager).najlepszyStrzelec();
        System.out.println(zawodnicy.get(0));

    }
    static void chooseGrubaski(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
        List<Zawodnik> zawodnicy = new Queries(entityManager).Grubaski();

        for(int i = 0; i < zawodnicy.size(); i++)
        {
            System.out.println(zawodnicy.get(i));
        }
    }

    static void chooseOsiemosob(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
        List<Zawodnik> zawodnicy = new Queries(entityManager).osiemosob();

        for(int i = 0; i < 8; i++)
        {
            System.out.println(zawodnicy.get(i+1));
        }
    }

    static void chooseMaluszek(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
        List<Zawodnik> zawodnicy = new Queries(entityManager).Maluszek();
        System.out.println(zawodnicy.get(0));

    }

    static void chooseGoleBarcelony(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Zawodnik k");
        List<Zawodnik> zawodnicy = new Queries(entityManager).GoleBarcelony();
        System.out.println(zawodnicy.get(0));

    }

}
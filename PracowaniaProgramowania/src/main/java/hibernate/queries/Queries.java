package hibernate.queries;

import hibernate.model.Zawodnik;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Zawodnik> getZawodnikByName(String nazwisko)
    {

        TypedQuery<Zawodnik> query = entityManager.createQuery("SELECT c FROM Zawodnik c WHERE c.nazwisko LIKE :nazwisko", Zawodnik.class);

        return query.setParameter("nazwisko", "elo").getResultList();
    }

    public List<Zawodnik> getAllZawodnikByPage(int pagenr) {
        //calculate total number
        Query queryTotal = entityManager.createQuery
                ("Select count(f) from Zawodnik f");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Zawodnik e");
        //set pageSize
        int pageSize = 10;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Zawodnik> najlepszyStrzelec() {
        //calculate total number
        Query query = entityManager.createQuery("Select nazwisko from Zawodnik f where gole = (select max(gole) from Zawodnik f)");
        return query.getResultList();
    }

    public List<Zawodnik> Grubaski() {
        //calculate total number
        Query query = entityManager.createQuery("SELECT nazwisko FROM Zawodnik f WHERE waga >=80 ");
        return query.getResultList();
    }

    public List<Zawodnik> osiemosob() {
        //calculate total number
        Query query = entityManager.createQuery("SELECT nazwisko FROM Zawodnik ");
        return query.getResultList();
    }

    public List<Zawodnik> Maluszek() {
        //calculate total number
        Query query = entityManager.createQuery("Select wzrost from Statystyki where wzrost = (select min(wzrost) from Statystyki)");
        return query.getResultList();
    }



    public List<Zawodnik> GoleBarcelony() {
        //calculate total number
        Query query = entityManager.createQuery("SELECT avg(gole) FROM Zawodnik WHERE klub= 'FC Barcelona' AND nazwisko <> 'Valverde' ");
        return query.getResultList();
    }

}



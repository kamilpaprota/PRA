package hibernate.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="refId", scope=Zawodnik.class)
@Entity
@Table(name = "ZAWODNIK", uniqueConstraints = {
        //@UniqueConstraint(columnNames = {"first_name","last_name"})})
        @UniqueConstraint(columnNames = {"imię", "nazwisko"})})
public class Zawodnik {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "imię", nullable = false)
    private String imię;

    @Column(name = "nazwisko", nullable = false)
    private String nazwisko;

    @Column(name = "pozycja")
    private String pozycja;


    //@JsonIgnore
    @Column(name = "gole")
    private int gole;

   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="klub", referencedColumnName = "nazwa")
    Klub klub;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "wzrost", referencedColumnName = "wzrost"),
            @JoinColumn(name = "waga", referencedColumnName = "waga"),
            @JoinColumn(name = "wiek", referencedColumnName = "wiek")
            })
    Statystyki statystyki;

    @ManyToMany(mappedBy = "zawodnicy", cascade = CascadeType.ALL)
    private List<Zawodnik> managers = new ArrayList<Zawodnik>();


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Zawodnik>  zawodnicy = new ArrayList<>();




    public Zawodnik() {}

    public List<Zawodnik> getManagers() {
        return managers;
    }


    public List<Zawodnik> getZawodnicy() {
        return zawodnicy;
    }

    public void setZawodnicy(List<Zawodnik> zawodnicy) {
        this.zawodnicy = zawodnicy;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }



    public String getImię() {
        return imię;
    }
    public void setImię( String imię ) {
        this.imię = imię;
    }


    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko( String nazwisko ) {
        this.nazwisko = nazwisko;
    }


    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja( String pozycja ) {
        this.pozycja = pozycja;
    }


    public int getGole() {
        return gole;
    }

    public void setGole( int gole ) {
        this.gole = gole;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setStatystyki(Statystyki statystyki) {
        this.statystyki = statystyki;
    }

    public Statystyki getStatystyki() {
        return statystyki;
    }



}
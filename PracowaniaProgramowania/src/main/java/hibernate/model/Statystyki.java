package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "STATYSTYKI")
public class Statystyki {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "id")
    private int id;


    @Column(nullable = false)
    Integer wzrost;

    @Column(nullable = false)
    Integer waga;

    @Column(nullable = false)
    Integer wiek;


    public Integer getWzrost() {
        return wzrost;
    }

    public void setWzrost(Integer wzrost) {
        this.wzrost = wzrost;
    }

    public Integer getWaga() {
        return waga;
    }

    public void setWaga(Integer waga) {
        this.waga = waga;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}

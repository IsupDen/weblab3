package ru.isupden.weblab3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hits")
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "coords_id")
    private Coord coord;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "times_id")
    private Time time;
    private Boolean result;
    private long timeZone;

    public Hit() {
        coord = new Coord();
        time = new Time();
    }

    public Hit(Hit oldHit) {
        coord = new Coord(oldHit.coord.getX(), oldHit.coord.getY(), oldHit.coord.getR());
        timeZone = oldHit.getTimeZone();
        time = new Time();
    }

    @Override
    public String toString() {
        return "Hit{" +
                "\nid=" + id +
                "\n, coord=" + coord +
                "\n, time=" + time +
                "\n, result=" + result +
                "\n, timeZone=" + timeZone +
                "\n}";
    }
}

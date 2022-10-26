package ru.isupden.weblab3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "coords")
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Double x = 0d;
    private Double y = 0d;
    private Double r = 1d;

    public Coord(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                "}\n";
    }
}

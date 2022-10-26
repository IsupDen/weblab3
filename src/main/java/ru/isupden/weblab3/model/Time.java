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
@Table(name = "times")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String currentTime;
    private int executionTime;

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", currentTime='" + currentTime + '\'' +
                ", executionTime=" + executionTime +
                "}\n";
    }
}

package ua.iovsa.citiesgame.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities", schema = "citiesgame")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}

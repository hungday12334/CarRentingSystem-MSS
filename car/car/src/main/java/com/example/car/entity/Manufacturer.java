package com.example.car.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;

    @Column(nullable = false, length = 100)
    private String manufacturerName;

    @Column(length = 500)
    private String description;

    @Column(length = 100)
    private String manufacturerCountry;
}
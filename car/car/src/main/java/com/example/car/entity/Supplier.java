package com.example.car.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column(nullable = false, length = 100)
    private String supplierName;

    @Column(length = 500)
    private String supplierDescription;

    @Column(length = 255)
    private String supplierAddress;
}
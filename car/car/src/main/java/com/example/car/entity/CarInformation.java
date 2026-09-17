package com.example.car.entity;

import com.example.car.entity.enums.CarStatus;
import com.example.car.entity.enums.FuelType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "car_information")
public class CarInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(nullable = false, length = 100)
    private String carName;

    @Column(length = 500)
    private String carDescription;

    private Integer numberOfDoors;

    private Integer seatingCapacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FuelType fuelType;

    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CarStatus carStatus;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal carRentingPricePerDay;
}
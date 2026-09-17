package com.example.renting.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "renting_detail")
public class RentingDetail {

    @EmbeddedId
    private RentingDetailId id;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;
}
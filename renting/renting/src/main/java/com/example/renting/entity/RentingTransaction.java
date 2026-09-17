package com.example.renting.entity;

import com.example.renting.entity.enums.RentingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "renting_transaction")
public class RentingTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentingTransactionId;

    private LocalDate rentingDate;

    @Column(precision = 12, scale = 2)
    private BigDecimal totalPrice;

    // Không relationship với Customer vì Customer thuộc service khác
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RentingStatus rentingStatus;
}
package com.example.customer.entity;

import com.example.customer.entity.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "telephone", unique = true, length = 20)
    private String telephone;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false, length = 20)
    private CustomerStatus customerStatus;

    @Column(name = "customer_birthday")
    private LocalDate customerBirthDay;

    @Column(name = "password", nullable = false)
    private String password;
}
package com.example.renting.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class RentingDetailId implements Serializable {

    private Long rentingTransactionId;

    private Long carId;
}
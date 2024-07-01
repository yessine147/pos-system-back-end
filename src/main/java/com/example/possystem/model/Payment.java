package com.example.possystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String payment_method;
    private String receiptNumber;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;

}

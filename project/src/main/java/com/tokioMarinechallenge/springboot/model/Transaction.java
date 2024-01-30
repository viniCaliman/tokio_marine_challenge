package com.tokioMarinechallenge.springboot.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "originAccount", nullable = false)
    private String originAccount;
    
    @Column(name = "destinationAccount", nullable = false)
    private String destinationAccount;
    
    @Column(name = "tranferValue", nullable = false)
    private float tranferValue;

    @Column(name = "appointmentDate", nullable = false)
    private Date appointmentDate;

    @Column(name = "tranferDate", nullable = false)
    private Date tranferDate;
    
    @Column(name = "tax", nullable = true)
    private float tax;
    
}

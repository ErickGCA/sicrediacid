package com.acid.sicredi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeTitular;

    private BigDecimal saldo;

}

package com.acid.sicredi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acid.sicredi.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

    }


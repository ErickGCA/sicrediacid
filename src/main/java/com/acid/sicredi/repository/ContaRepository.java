package com.acid.sicredi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acid.sicredi.model.Conta;

public class ContaRepository {

    @Repository
    public interface ContaRepository extends JpaRepository<Conta, Long>{

    }
}

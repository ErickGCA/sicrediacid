package com.acid.sicredi.service;

import com.acid.sicredi.model.Conta;
import com.acid.sicredi.repository.ContaRepository;

import com.acid.sicredi.repository.ContaRepository;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

public class TransferenciaService {

    private final ContaRepository contaRepository;

    public TransferenciaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;

    }

    @Transactional // A anotação mais importante para o seu projeto ACID
    public void transferir(Long idContaOrigem, Long idContaDestino, BigDecimal valor) {
        // A lógica que já discutimos: busca as contas, valida o saldo e efetua a transferência
        Conta contaOrigem = contaRepository.findById(idContaOrigem)
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada!"));
        Conta contaDestino = contaRepository.findById(idContaDestino)
                .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada!"));

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente!");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
    }
}

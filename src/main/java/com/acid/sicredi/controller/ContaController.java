package com.acid.sicredi.controller;


import com.acid.sicredi.dto.TransferenciaRequestDTO;
import com.acid.sicredi.model.Conta;
import com.acid.sicredi.repository.ContaRepository;
import com.acid.sicredi.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaRepository contaRepository;
    private final TransferenciaService transferenciaService;

    public ContaController(TransferenciaService transferenciaService, ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
        this.transferenciaService = transferenciaService;

    }

    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(@RequestBody TransferenciaRequestDTO dto) {
        transferenciaService.transferir(dto.idContaOrigem(), dto.idContaDestino(), dto.valor());
        return ResponseEntity.ok("Transferencia realizada com sucesso");
    }

    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
        conta.setId(null);
        Conta contaSalva = contaRepository.save(conta);
        return ResponseEntity.ok(contaSalva);
    }
    //Get em contas com id http:/localhost:8080/contas/id
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContaPorId(@PathVariable Long id) {
        return contaRepository.findById(id)
                .map(conta -> ResponseEntity.ok(conta))
                .orElse(ResponseEntity.notFound().build());
    }
    //Get em todas as contas
    @GetMapping
    public ResponseEntity<List<Conta>> buscarTodasAsContas() {
        List<Conta> contas = contaRepository.findAll();
        return ResponseEntity.ok(contas);
    }
}

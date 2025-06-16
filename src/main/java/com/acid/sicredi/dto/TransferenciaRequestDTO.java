package com.acid.sicredi.dto;

import java.math.BigDecimal;

public record TransferenciaRequestDTO (Long idContaOrigem, Long idContaDestino, BigDecimal valor){

}

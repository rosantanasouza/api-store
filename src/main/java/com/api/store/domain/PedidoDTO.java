package com.api.store.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private String cliente;
    private Integer qtdProdutos;
    private BigDecimal valorTotal;
    private String statusPedido;
}

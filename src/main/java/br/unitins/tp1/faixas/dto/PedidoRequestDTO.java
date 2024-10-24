package br.unitins.tp1.faixas.dto;

import java.util.List;

public record PedidoRequestDTO (
    Double valorTotal, 
    List<ItemPedidoRequestDTO> listaItemPedido
) {

}

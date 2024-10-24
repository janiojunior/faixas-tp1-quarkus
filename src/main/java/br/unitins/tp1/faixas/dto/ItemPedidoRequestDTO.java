package br.unitins.tp1.faixas.dto;

public record ItemPedidoRequestDTO(
    Long idProduto, 
    Integer quantidade,
    Double preco) {

}

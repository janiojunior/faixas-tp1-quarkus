package br.unitins.tp1.faixas.dto;

import br.unitins.tp1.faixas.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Long idProduto, 
    String nome, 
    Integer quantidade,
    Double valor) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO (
            itemPedido.getLote().getFaixa().getId(), 
            itemPedido.getLote().getFaixa().getNome(), 
            itemPedido.getQuantidade(),
            itemPedido.getPreco());
    }
    
}

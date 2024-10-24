package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.PedidoRequestDTO;
import br.unitins.tp1.faixas.model.Pedido;


public interface PedidoService {

    Pedido findById(Long id);

    List<Pedido> findByUsername(String username);

    Pedido create(PedidoRequestDTO dto);

    // implementar os patch's

    void delete(Long id); 
    
}

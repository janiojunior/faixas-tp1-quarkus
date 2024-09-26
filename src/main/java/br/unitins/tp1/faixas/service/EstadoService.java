package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.EstadoDTORequest;
import br.unitins.tp1.faixas.model.Estado;


public interface EstadoService {

    Estado findById(Long id);

    List<Estado> findByNome(String nome);

    List<Estado> findAll();

    Estado create(EstadoDTORequest dto);

    Estado update(Long id, EstadoDTORequest dto);

    void delete(Long id); 
    
}

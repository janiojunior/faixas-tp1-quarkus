package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.model.Municipio;


public interface MunicipioService {

    Municipio findById(Long id);

    List<Municipio> findByNome(String nome);

    List<Municipio> findAll();

    Municipio create(Municipio municipio);

    Municipio update(Municipio municipio);

    void delete(Long id); 
    
}

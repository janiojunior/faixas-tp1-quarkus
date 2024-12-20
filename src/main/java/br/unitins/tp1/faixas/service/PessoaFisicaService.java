package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.PessoaFisicaRequestDTO;
import br.unitins.tp1.faixas.model.PessoaFisica;


public interface PessoaFisicaService {

    PessoaFisica findById(Long id);

    List<PessoaFisica> findByNome(String nome);

    PessoaFisica findByCpf(String cpf);

    List<PessoaFisica> findAll();

    PessoaFisica create(PessoaFisicaRequestDTO dto);

    PessoaFisica update(Long id, PessoaFisicaRequestDTO dto);

    PessoaFisica updateNomeImagem(Long id, String nomeImagem);

    void delete(Long id); 
    
}

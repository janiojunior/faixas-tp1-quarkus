package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.EstadoRequestDTO;
import br.unitins.tp1.faixas.model.Estado;
import br.unitins.tp1.faixas.repository.EstadoRepository;
import br.unitins.tp1.faixas.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    public EstadoRepository estadoRepository;

    @Override
    public Estado findById(Long id) {
        return estadoRepository.findById(id);
    }

    @Override
    public List<Estado> findByNome(String nome) {
        return estadoRepository.findByNome(nome);
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll().list();
    }

    @Override
    @Transactional
    public Estado create(@Valid EstadoRequestDTO dto) {
        // verificando se a sigla ja existe
        validarSigla(dto.sigla());

        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return estado;

    }

    private void validarSigla(String sigla) {
        Estado estado = estadoRepository.findBySigla(sigla);
        if (estado != null) 
            throw new ValidationException("sigla", "Esta sigla já foi utilizada por outro estado.");  
    }

    @Override
    @Transactional
    public Estado update(Long id, EstadoRequestDTO dto) {
        Estado estado = estadoRepository.findById(id);

        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        return estado;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

}

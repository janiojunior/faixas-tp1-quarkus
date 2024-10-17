package br.unitins.tp1.faixas.repository;

import java.util.List;

import br.unitins.tp1.faixas.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {
    
    public List<PessoaFisica> findByNome(String nome) {
        return find("SELECT p FROM PessoaFisica p WHERE p.nome LIKE ?1", "%" + nome + "%").list();
    }

    public PessoaFisica findByCpf(String cpf) {
        return find("SELECT p FROM PessoaFisica p WHERE p.cpf = ?1",  cpf ).firstResult();
    }
    
}

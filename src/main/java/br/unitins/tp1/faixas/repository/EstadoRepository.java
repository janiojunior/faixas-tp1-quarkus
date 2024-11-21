package br.unitins.tp1.faixas.repository;

import java.util.List;

import br.unitins.tp1.faixas.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
    public List<Estado> findByNome(String nome) {
        return find("SELECT e FROM Estado e WHERE e.nome LIKE ?1", "%" + nome + "%").list();
    }

    public Estado findBySigla(String sigla) {
        return find("SELECT e FROM Estado e WHERE e.sigla = ?1", sigla).firstResult();
    }
    
}

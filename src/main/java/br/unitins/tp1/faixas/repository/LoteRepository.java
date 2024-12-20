package br.unitins.tp1.faixas.repository;

import br.unitins.tp1.faixas.model.Lote;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteRepository implements PanacheRepository<Lote> {
    
    /**
     * @return retorna a faixa com o lote mais antigo e com quantidade maior que zero
     */
    public Lote findByIdFaixa(Long idFaixa) {
        StringBuffer jpql = new StringBuffer();
        jpql.append("SELECT ");
        jpql.append("  l ");
        jpql.append("FROM ");
        jpql.append("  Lote l ");
        jpql.append("WHERE ");
        jpql.append("  l.faixa.id = ?1 ");
        jpql.append("  AND l.estoque > 0 ");
        jpql.append("ORDER BY l.data ");

        return find(jpql.toString(), idFaixa).firstResult();
    }
  
    public Lote findByCodigo(String codigo) {
        StringBuffer jpql = new StringBuffer();
        jpql.append("SELECT ");
        jpql.append("  l ");
        jpql.append("FROM ");
        jpql.append("  Lote l ");
        jpql.append("WHERE ");
        jpql.append("  l.codigo = ?1 ");

        return find(jpql.toString(), codigo).firstResult();
    }
    
}

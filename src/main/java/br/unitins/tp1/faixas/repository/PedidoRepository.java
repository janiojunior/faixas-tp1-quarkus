package br.unitins.tp1.faixas.repository;

import java.util.List;

import br.unitins.tp1.faixas.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    
    public List<Pedido> findByIdUsuario(Long  idUsuario) {
        return find("SELECT p FROM Pedido p WHERE p.usuario.id = ?1", idUsuario).list();
    }
    
}

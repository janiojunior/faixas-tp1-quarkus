package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.PedidoRequestDTO;
import br.unitins.tp1.faixas.model.Pedido;
import br.unitins.tp1.faixas.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public EstadoService estadoService;

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> findByUsername(String username) {
        // buscar pelo usuario com username
        // Usuario usuario = usuarioRepository.findByUsername(username);
        // return pedidoRepository.findByIdUsuario(usuario.getId());
        return null;
    }

    @Override
    @Transactional
    public Pedido create(PedidoRequestDTO dto) {
        // buscando o estado a partir de um id do pedido
        // Pedido pedido = new Pedido();
        // pedido.setEstado(estadoService.findById(dto.idEstado()));
        // pedido.setNome(dto.nome());

        // //salvando o pedido
        // pedidoRepository.persist(pedido);
        
        // return pedido;
        return null;
    }

}

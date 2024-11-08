package br.unitins.tp1.faixas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.faixas.dto.ItemPedidoRequestDTO;
import br.unitins.tp1.faixas.dto.PedidoRequestDTO;
import br.unitins.tp1.faixas.model.ItemPedido;
import br.unitins.tp1.faixas.model.Lote;
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
    public UsuarioService usuarioService;

    @Inject
    public LoteService loteService;

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
    public Pedido create(PedidoRequestDTO dto, String username) {
        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setUsuario(usuarioService.findByUsername(username));
        // eh importante validar se o total enviado via dto eh o mesmo gerado pelos produtos
        pedido.setValorTotal(dto.valorTotal());

        pedido.setListaItemPedido(new ArrayList<ItemPedido>());

        for (ItemPedidoRequestDTO itemDTO : dto.listaItemPedido()) {
            ItemPedido item = new ItemPedido();
            Lote lote = loteService.findByIdFaixa(itemDTO.idProduto());
            item.setLote(lote);
            // eh importante validar o preco
            item.setPreco(itemDTO.preco());
            // eh importante validar se tem estoque
            item.setQuantidade(itemDTO.quantidade());

            pedido.getListaItemPedido().add(item);
        }

        pedidoRepository.persist(pedido);
        
        return pedido;
    }

}

package com.api.store.service;

import com.api.store.domain.PedidoDTO;
import com.api.store.entity.Pedido;
import com.api.store.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PedidoService {


    private final PedidoRepository pedidoRepository;

    //Listar Pedidos
    public List<Pedido> pedidos() {
        return pedidoRepository.findAll();
    }

    //Cadastrar Pedido
    public void novoPedido(PedidoDTO novoPedido) {
        Pedido pedidoNovo = new Pedido();
        pedidoNovo.setCliente(novoPedido.getCliente());
        pedidoNovo.setQtdProdutos(novoPedido.getQtdProdutos());
        pedidoNovo.setValorTotal(novoPedido.getValorTotal());
        pedidoNovo.setStatusPedido("Pedido Realizado.");

        pedidoRepository.save(pedidoNovo);
    }

    //Alterar Pedido
    public void alterarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    //Deletar Pedido
    public void deletarPedido(Long idpedido) {
        Pedido pedido = pedidoRepository.getById(idpedido);
        pedidoRepository.delete(pedido);
    }


}

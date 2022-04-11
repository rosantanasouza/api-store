package com.api.store.controller;

import com.api.store.domain.PedidoDTO;
import com.api.store.entity.Pedido;
import com.api.store.service.PedidoService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {


    private final PedidoService pedidoService;


    @GetMapping("")
    public String homePage() {
        return "Seja Bem-Vindo(a) à Página Principal.";
    }

    //Listar Pedidos
    @GetMapping("/listar-pedidos")
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos;
        listaPedidos = pedidoService.pedidos();

        return listaPedidos;
    }

    //Cadastrar Pedido
    @PostMapping("/novopedido")
    public String pedidoNovo(@RequestBody PedidoDTO pedidoNovo) {
        pedidoService.novoPedido(pedidoNovo);

        return "Pedido Criado Com Sucesso.";
    }

    //Alterar Pedido
    @PutMapping("/alterar-pedido")
    public String alterarPedido(@RequestBody Pedido pedido) {
        pedidoService.alterarPedido(pedido);

        return "Pedido Alterado Com Sucesso.";
    }

    //Deletar Pedido
    @DeleteMapping("/excluir-pedido/{idpedido}")
    public String excluirPedido (@PathVariable Long idpedido){
        pedidoService.deletarPedido(idpedido);

        return "Pedido Exluido Com Sucesso.";
    }

}

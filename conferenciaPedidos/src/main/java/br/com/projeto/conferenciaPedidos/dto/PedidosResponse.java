package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;

import java.util.Set;

public record PedidosResponse(Long id, int numero, Set<ItensPedido> itens, SituacaoPedido situacao) {
    public static PedidosResponse de(Pedidos p){
        return new PedidosResponse(p.getId(), p.getNumero(), p.getItens(), p.getSituacao());
    }
}

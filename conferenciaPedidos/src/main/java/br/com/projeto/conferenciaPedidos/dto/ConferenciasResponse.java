package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.Conferencias;
import br.com.projeto.conferenciaPedidos.entity.Leituras;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import br.com.projeto.conferenciaPedidos.enums.StatusConferencia;

import java.util.List;

public record ConferenciasResponse(Long id, Pedidos pedido, List<Leituras> itens, StatusConferencia status) {
    public static ConferenciasResponse de(Conferencias c){
        return new ConferenciasResponse(c.getId(), c.getPedido(), c.getItens(), c.getStatus());
    }
}

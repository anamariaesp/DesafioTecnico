package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;

public record ItensPedidoResponse(Long id, Pedidos pedido, String SKU, int quantidade) {
    public static ItensPedidoResponse de(ItensPedido i){
        return new ItensPedidoResponse(i.getId(), i.getPedido(), i.getSKU(), i.getQuantidade());
    }
}

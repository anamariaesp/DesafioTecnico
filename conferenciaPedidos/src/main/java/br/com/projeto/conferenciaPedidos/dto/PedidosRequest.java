package br.com.projeto.conferenciaPedidos.dto;


import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record PedidosRequest(
        @NotBlank(message = "Número do pedido é obrigatório")
        int numero,
        @NotBlank(message = "O pedido deve ter pelo menos um item")
        Set<ItensPedido> itens,
        SituacaoPedido situacao
) {
}
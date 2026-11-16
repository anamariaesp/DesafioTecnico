package br.com.projeto.conferenciaPedidos.dto;


import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PedidosRequest(
        @NotBlank(message = "Número do pedido é obrigatório")
        int numero,
        @Valid
        List<@NotBlank(message = "Pedido precisa ter pelo menos um item") ItensPedido> itens,
        SituacaoPedido situacao
) {
}
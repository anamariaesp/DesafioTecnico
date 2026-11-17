package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.Leituras;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import br.com.projeto.conferenciaPedidos.enums.StatusConferencia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ConferenciasRequest(
        @NotNull(message = "Pedido é obrigatório")
        Pedidos pedido,
        @Valid
        List<@NotNull Leituras> itens,
        @NotNull(message = "Pedido é obrigatório")
        StatusConferencia status
) {
}

package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItensPedidoRequest(
        @NotNull(message = "Pedido é obrigatório")
        Pedidos pedido,
        @NotBlank(message = "SKU é obrigatório")
        String SKU,
        @NotNull(message = "Quantidade é obrigatória")
        @Positive(message = "Quantidade precisa ser maior que 0")
        int quantidade
) {
}

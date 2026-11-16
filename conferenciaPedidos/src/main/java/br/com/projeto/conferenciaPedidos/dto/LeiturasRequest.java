package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.Conferencias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LeiturasRequest(
        @NotNull(message = "Conferencia é obrigatória")
        Conferencias conferencia,
        @NotBlank(message = "SKU é obrigatório")
        String sku
) {
}

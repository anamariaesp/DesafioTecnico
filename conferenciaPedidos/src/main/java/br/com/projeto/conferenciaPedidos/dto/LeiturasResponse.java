package br.com.projeto.conferenciaPedidos.dto;

import br.com.projeto.conferenciaPedidos.entity.Conferencias;
import br.com.projeto.conferenciaPedidos.entity.Leituras;

public record LeiturasResponse (Long id, Conferencias conferencia, String sku) {
    public static LeiturasResponse de(Leituras l){
        return new LeiturasResponse(l.getId(), l.getConferencia(), l.getSku());
    }
}
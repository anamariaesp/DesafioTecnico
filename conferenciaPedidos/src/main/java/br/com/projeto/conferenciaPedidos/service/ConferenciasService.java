package br.com.projeto.conferenciaPedidos.service;

import br.com.projeto.conferenciaPedidos.dto.ConferenciasRequest;
import br.com.projeto.conferenciaPedidos.dto.ConferenciasResponse;
import br.com.projeto.conferenciaPedidos.entity.Conferencias;
import br.com.projeto.conferenciaPedidos.entity.Leituras;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import br.com.projeto.conferenciaPedidos.exception.RecursoNaoEncontradoException;
import br.com.projeto.conferenciaPedidos.repository.ConferenciasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConferenciasService {
    private final ConferenciasRepository repository;

    public ConferenciasService(ConferenciasRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ConferenciasResponse criar(ConferenciasRequest dto) {
        Conferencias c = new Conferencias(dto.pedido(),dto.status());
        for (Leituras l : dto.itens()) {
            c.addLeitura(l);
        }
        Conferencias salvo = repository.save(c);
        return ConferenciasResponse.de(salvo);
    }

    @Transactional(readOnly = true)
    public List<ConferenciasResponse> listar() {
        return repository.findAll().stream().map(ConferenciasResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public ConferenciasResponse buscar(Long id) {
        return ConferenciasResponse.de(buscarEntity(id));
    }

    @Transactional
    public ConferenciasResponse atualizar(Long id, ConferenciasRequest dto){
        Conferencias itens = buscarEntity(id);
        itens.setPedido(dto.pedido());
        itens.setItens(dto.itens());
        itens.setStatus(dto.status());
        return ConferenciasResponse.de(itens);
    }

    @Transactional
    public void excluir(Long id) {
        repository.delete(buscarEntity(id));
    }

    private Conferencias buscarEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Conferencias " + id + " não encontrado"));
    }
}

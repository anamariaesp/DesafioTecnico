package br.com.projeto.conferenciaPedidos.service;

import br.com.projeto.conferenciaPedidos.dto.PedidosRequest;
import br.com.projeto.conferenciaPedidos.dto.PedidosResponse;
import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import br.com.projeto.conferenciaPedidos.exception.RecursoNaoEncontradoException;
import br.com.projeto.conferenciaPedidos.repository.PedidosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidosService {
    private final PedidosRepository repository;
    
    public PedidosService(PedidosRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PedidosResponse criar(PedidosRequest dto) { 
        Pedidos salvo = repository.save(new Pedidos(dto.numero(), dto.itens(), dto.situacao()));
        return PedidosResponse.de(salvo);
    }

    @Transactional(readOnly = true)
    public List<PedidosResponse> listar() {
        return repository.findAll().stream().map(PedidosResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public PedidosResponse buscar(Long id) {
        return PedidosResponse.de(buscarEntity(id));
    }

    @Transactional
    public PedidosResponse atualizar(Long id, PedidosRequest dto){
        Pedidos pedido = buscarEntity(id);
        pedido.setNumero(dto.numero());
        pedido.setItens(dto.itens());
        pedido.setSituacao(dto.situacao());
        return PedidosResponse.de(pedido);
    }

    @Transactional
    public void excluir(Long id) {
        repository.delete(buscarEntity(id));
    }

    private Pedidos buscarEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Pedidos " + id + " não encontrado"));
    }
}

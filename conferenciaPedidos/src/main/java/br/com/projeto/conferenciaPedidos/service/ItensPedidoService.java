package br.com.projeto.conferenciaPedidos.service;

import br.com.projeto.conferenciaPedidos.dto.ItensPedidoRequest;
import br.com.projeto.conferenciaPedidos.dto.ItensPedidoResponse;
import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import br.com.projeto.conferenciaPedidos.exception.RecursoNaoEncontradoException;
import br.com.projeto.conferenciaPedidos.repository.ItensPedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItensPedidoService {
    private final ItensPedidoRepository repository;

    public ItensPedidoService(ItensPedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ItensPedidoResponse criar(ItensPedidoRequest dto) {
        ItensPedido salvo = repository.save(new ItensPedido(dto.pedido(), dto.SKU(), dto.quantidade()));
        return ItensPedidoResponse.de(salvo);
    }

    @Transactional(readOnly = true)
    public List<ItensPedidoResponse> listar() {
        return repository.findAll().stream().map(ItensPedidoResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public ItensPedidoResponse buscar(Long id) {
        return ItensPedidoResponse.de(buscarEntity(id));
    }

    @Transactional
    public ItensPedidoResponse atualizar(Long id, ItensPedidoRequest dto){
        ItensPedido itens = buscarEntity(id);
        itens.setPedido(dto.pedido());
        itens.setSKU(dto.SKU());
        itens.setQuantidade(dto.quantidade());
        return ItensPedidoResponse.de(itens);
    }

    @Transactional
    public void excluir(Long id) {
        repository.delete(buscarEntity(id));
    }

    private ItensPedido buscarEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "ItensPedido " + id + " não encontrado"));
    }
}

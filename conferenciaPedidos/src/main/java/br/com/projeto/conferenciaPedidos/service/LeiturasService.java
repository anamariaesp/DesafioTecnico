package br.com.projeto.conferenciaPedidos.service;

import br.com.projeto.conferenciaPedidos.dto.LeiturasRequest;
import br.com.projeto.conferenciaPedidos.dto.LeiturasResponse;
import br.com.projeto.conferenciaPedidos.entity.Leituras;
import br.com.projeto.conferenciaPedidos.exception.RecursoNaoEncontradoException;
import br.com.projeto.conferenciaPedidos.repository.LeiturasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class LeiturasService {
    private final LeiturasRepository repository;

    public LeiturasService(LeiturasRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public LeiturasResponse criar(LeiturasRequest dto) {
        Leituras salvo = repository.save(new Leituras(dto.conferencia(), dto.sku().trim().toUpperCase(Locale.ROOT)));
        return LeiturasResponse.de(salvo);
    }

    @Transactional(readOnly = true)
    public List<LeiturasResponse> listar() {
        return repository.findAll().stream().map(LeiturasResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public LeiturasResponse buscar(Long id) {
        return LeiturasResponse.de(buscarEntity(id));
    }

    @Transactional
    public LeiturasResponse atualizar(Long id, LeiturasRequest dto){
        Leituras itens = buscarEntity(id);
        itens.setConferencia(dto.conferencia());
        itens.setSku(dto.sku().trim().toUpperCase(Locale.ROOT));
        return LeiturasResponse.de(itens);
    }

    @Transactional
    public void excluir(Long id) {
        repository.delete(buscarEntity(id));
    }

    private Leituras buscarEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Leituras " + id + " não encontrado"));
    }
}

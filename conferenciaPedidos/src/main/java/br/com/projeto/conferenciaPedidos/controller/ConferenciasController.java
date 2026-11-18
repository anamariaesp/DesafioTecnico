package br.com.projeto.conferenciaPedidos.controller;

import br.com.projeto.conferenciaPedidos.dto.ConferenciasRequest;
import br.com.projeto.conferenciaPedidos.dto.ConferenciasResponse;
import br.com.projeto.conferenciaPedidos.service.ConferenciasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conferencias")
public class ConferenciasController {
    private final ConferenciasService service;

    public ConferenciasController(ConferenciasService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConferenciasResponse> criar(
            @Valid @RequestBody ConferenciasRequest dto) {
        ConferenciasResponse criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/conferencias/" + criado.id())).body(criado);
    }

    @GetMapping
    public List<ConferenciasResponse> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ConferenciasResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public ConferenciasResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ConferenciasRequest dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
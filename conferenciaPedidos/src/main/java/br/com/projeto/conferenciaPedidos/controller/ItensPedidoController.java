package br.com.projeto.conferenciaPedidos.controller;

import br.com.projeto.conferenciaPedidos.dto.ItensPedidoRequest;
import br.com.projeto.conferenciaPedidos.dto.ItensPedidoResponse;
import br.com.projeto.conferenciaPedidos.service.ItensPedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itenspedido")
public class ItensPedidoController {
    private final ItensPedidoService service;

    public ItensPedidoController(ItensPedidoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ItensPedidoResponse> criar(
            @Valid @RequestBody ItensPedidoRequest dto) {
        ItensPedidoResponse criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/itenspedido/" + criado.id())).body(criado);
    }

    @GetMapping
    public List<ItensPedidoResponse> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ItensPedidoResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public ItensPedidoResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ItensPedidoRequest dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
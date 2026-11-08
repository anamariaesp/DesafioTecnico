package br.com.projeto.conferenciaPedidos.controller;

import br.com.projeto.conferenciaPedidos.dto.PedidosRequest;
import br.com.projeto.conferenciaPedidos.dto.PedidosResponse;
import br.com.projeto.conferenciaPedidos.service.PedidosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    private final PedidosService service;

    public PedidosController(PedidosService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidosResponse> criar(
            @Valid @RequestBody PedidosRequest dto) {
        PedidosResponse criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/pedidos/" + criado.id())).body(criado);
    }

    @GetMapping
    public List<PedidosResponse> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public PedidosResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public PedidosResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PedidosRequest dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
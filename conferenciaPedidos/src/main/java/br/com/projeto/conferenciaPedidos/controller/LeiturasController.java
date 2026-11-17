package br.com.projeto.conferenciaPedidos.controller;

import br.com.projeto.conferenciaPedidos.dto.LeiturasRequest;
import br.com.projeto.conferenciaPedidos.dto.LeiturasResponse;
import br.com.projeto.conferenciaPedidos.service.LeiturasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Leituras")
public class LeiturasController {
    private final LeiturasService service;

    public LeiturasController(LeiturasService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeiturasResponse> criar(
            @Valid @RequestBody LeiturasRequest dto) {
        LeiturasResponse criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/Leituras/" + criado.id())).body(criado);
    }

    @GetMapping
    public List<LeiturasResponse> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public LeiturasResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public LeiturasResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody LeiturasRequest dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
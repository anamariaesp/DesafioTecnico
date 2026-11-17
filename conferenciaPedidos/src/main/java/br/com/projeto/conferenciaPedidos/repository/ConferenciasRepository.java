package br.com.projeto.conferenciaPedidos.repository;

import br.com.projeto.conferenciaPedidos.entity.Conferencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenciasRepository extends JpaRepository<Conferencias, Long> {
}

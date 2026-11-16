package br.com.projeto.conferenciaPedidos.repository;

import br.com.projeto.conferenciaPedidos.entity.Leituras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeiturasRepository extends JpaRepository<Leituras, Long> {
}

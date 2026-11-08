package br.com.projeto.conferenciaPedidos.repository;

import br.com.projeto.conferenciaPedidos.entity.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
}

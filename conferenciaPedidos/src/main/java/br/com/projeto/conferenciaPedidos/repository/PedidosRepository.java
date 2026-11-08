package br.com.projeto.conferenciaPedidos.repository;

import br.com.projeto.conferenciaPedidos.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}

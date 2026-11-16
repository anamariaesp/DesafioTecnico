package br.com.projeto.conferenciaPedidos.entity;

import br.com.projeto.conferenciaPedidos.enums.StatusConferencia;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "conferencia")
public class Conferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;
    @OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Leituras> itens;
    private StatusConferencia status;

}

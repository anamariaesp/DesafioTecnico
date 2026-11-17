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

    public Conferencias() {
    }

    public Conferencias(Pedidos pedido, List<Leituras> itens, StatusConferencia status) {
        this.pedido = pedido;
        this.itens = itens;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public List<Leituras> getItens() {
        return itens;
    }

    public void setItens(List<Leituras> itens) {
        this.itens = itens;
    }

    public StatusConferencia getStatus() {
        return status;
    }

    public void setStatus(StatusConferencia status) {
        this.status = status;
    }
}

package br.com.projeto.conferenciaPedidos.entity;

import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;
    @Column(nullable = false)
    private String SKU;
    @Column(nullable = false)
    private int quantidade;

    public ItensPedido() {
    }

    public ItensPedido(Pedidos pedido, String SKU, int quantidade) {
        this.pedido = pedido;
        this.SKU = SKU;
        this.quantidade = quantidade;
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

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

package br.com.projeto.conferenciaPedidos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;
    @Column(nullable = false)
    private String sku;
    @Column(nullable = false)
    private int quantidade;

    public ItensPedido() {
    }

    public ItensPedido(Pedidos pedido, String sku, int quantidade) {
        this.pedido = pedido;
        this.sku = sku;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItensPedido )) return false;
        return id != null && id.equals(((ItensPedido) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

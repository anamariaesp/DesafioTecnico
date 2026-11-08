package br.com.projeto.conferenciaPedidos.entity;

import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private int numero;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItensPedido> itens;
    private SituacaoPedido situacao;

    public Pedidos() {}

    public Pedidos(int numero, Set<ItensPedido> itens, SituacaoPedido situacao) {
        this.numero = numero;
        this.itens = itens;
        this.situacao = situacao;
    }

    public long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItensPedido> itens) {
        this.itens = itens;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
}

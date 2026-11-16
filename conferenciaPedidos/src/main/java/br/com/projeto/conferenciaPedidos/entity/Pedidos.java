package br.com.projeto.conferenciaPedidos.entity;

import br.com.projeto.conferenciaPedidos.enums.SituacaoPedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private int numero;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensPedido> itens;
    private SituacaoPedido situacao;

    public Pedidos() {}

    public Pedidos(int numero, List<ItensPedido> itens, SituacaoPedido situacao) {
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

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
}

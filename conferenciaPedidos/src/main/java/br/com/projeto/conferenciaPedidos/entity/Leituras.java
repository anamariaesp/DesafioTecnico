package br.com.projeto.conferenciaPedidos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leitura")
public class Leituras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_conferencia", nullable = false)
    private Conferencias conferencia;
    @Column(nullable = false)
    private String sku;

    public Leituras() {
    }

    public Leituras(long id, Conferencias conferencia, String sku) {
        this.id = id;
        this.conferencia = conferencia;
        this.sku = sku;
    }

    public long getId() {
        return id;
    }

    public Conferencias getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencias conferencia) {
        this.conferencia = conferencia;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}

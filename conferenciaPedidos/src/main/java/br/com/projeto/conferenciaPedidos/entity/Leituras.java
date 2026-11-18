package br.com.projeto.conferenciaPedidos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leitura")
public class Leituras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_conferencia", nullable = false)
    private Conferencias conferencia;
    @Column(nullable = false)
    private String sku;

    public Leituras() {
    }

    public Leituras(Conferencias conferencia, String sku) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leituras )) return false;
        return id != null && id.equals(((Leituras) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

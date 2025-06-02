package dev.batist.MoEstilo.infra.persistence;

import dev.batist.MoEstilo.core.entities.enums.Cor;
import dev.batist.MoEstilo.core.entities.enums.Genero;
import dev.batist.MoEstilo.core.entities.enums.Tamanho;
import jakarta.persistence.*;
import lombok.Builder;

import javax.lang.model.element.Name;
import java.math.BigDecimal;

@Entity
@Table(name = "roupas")
@Builder
public class RoupasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    @Column(nullable = false)
    private BigDecimal valor;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private Integer qte;
    @Enumerated(EnumType.STRING)
    private Cor cor;

    public RoupasEntity() {
    }

    public RoupasEntity(Long id, String nome, String descricao, Tamanho tamanho, BigDecimal valor, String marca, Genero genero, Integer qte, Cor cor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
        this.marca = marca;
        this.genero = genero;
        this.qte = qte;
        this.cor = cor;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}

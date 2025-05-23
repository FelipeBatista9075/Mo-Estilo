package dev.batist.MoEstilo.core.entities;

import dev.batist.MoEstilo.core.entities.enums.Cor;
import dev.batist.MoEstilo.core.entities.enums.Genero;
import dev.batist.MoEstilo.core.entities.enums.Tamanho;

import java.math.BigDecimal;

public class Roupas {
    private Long id;
    private String nome;
    private String descricao;
    private Tamanho tamanho;
    private BigDecimal valor;
    private String marca;
    private Genero genero;
    private Cor cor;

    public Roupas() {
    }

    public Roupas(Long id, String nome, String descricao, Tamanho tamanho, BigDecimal valor, String marca, Genero genero, Cor cor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
        this.marca = marca;
        this.genero = genero;
        this.cor = cor;
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

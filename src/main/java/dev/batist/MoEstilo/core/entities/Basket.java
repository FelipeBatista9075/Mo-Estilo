package dev.batist.MoEstilo.core.entities;


import dev.batist.MoEstilo.core.entities.enums.Status;
import dev.batist.MoEstilo.infra.percistence.ProductsEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Basket {
    private UUID id;
    private Long client;
    private BigDecimal totalPrice;
    private List<Products> products;
    private Status status;

    public Basket() {
    }

    public Basket(UUID id, Long client, BigDecimal totalPrice, List<Products> products, Status status) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.products = products;
        this.status = status;
    }

    public Basket(Long client, List<Products> products, BigDecimal bigDecimal) {
        this.client = client;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStattus(Status status) {
        this.status = status;
    }
}

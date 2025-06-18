package dev.batist.MoEstilo.core.entities;


import dev.batist.MoEstilo.core.entities.enums.Status;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Basket {
    private UUID id;
    private Long client;
    private BigDecimal totalPrice;
    private List<Products> products;
    private Status status;
    private Integer totalQuantity;

    public <R> Basket(Long client, R collect, BigDecimal bigDecimal, Integer integer) {
    }


    public void recalculate() {
        this.totalPrice = products.stream()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getQty() != null ? p.getQty() : 0)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.totalQuantity = products.stream()
                .mapToInt(p -> p.getQty() != null ? p.getQty() : 0)
                .sum();
    }

    public Basket() {
    }

    public Basket(UUID id, Long client, BigDecimal totalPrice, List<Products> products, Status status, Integer totalQuantity) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.products = products;
        this.status = status;
        this.totalQuantity = totalQuantity;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
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

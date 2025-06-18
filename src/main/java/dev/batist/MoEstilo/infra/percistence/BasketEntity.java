package dev.batist.MoEstilo.infra.percistence;


import dev.batist.MoEstilo.core.entities.enums.Status;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "basket")
public class BasketEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable = false)
    private Long client;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @ManyToMany
    private List<ProductsEntity> products;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "total_quantity")
    private Integer totalQuantity;

    public void calculateTotalPrice(){
        this.totalPrice = products.stream()
                .map(itens -> itens.getPrice().multiply(BigDecimal.valueOf(itens.getQty())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void calculateTotalQuantity(){
        this.totalQuantity = products.stream()
                .mapToInt(p -> p.getQty() != null ? p.getQty() : 0)
                .sum();
    }
    public void recalculate() {
        calculateTotalPrice();
        calculateTotalQuantity();
    }

    public BasketEntity() {
    }

    public BasketEntity(UUID id, Long client, BigDecimal totalPrice, List<ProductsEntity> products, Status status, Integer totalQuantity) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.products = products;
        this.status = status;
        this.totalQuantity = totalQuantity;
    }

    public BasketEntity(UUID id, Long client, BigDecimal totalPrice, List<ProductsEntity> products, Status status) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.products = products;
        this.status = status;
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

    public List<ProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsEntity> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStattus(Status status) {
        this.status = status;
    }
}

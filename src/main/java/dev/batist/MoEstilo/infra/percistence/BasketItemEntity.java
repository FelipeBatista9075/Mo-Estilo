package dev.batist.MoEstilo.infra.percistence;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "basket_items")
public class BasketItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BasketEntity basket;

    @ManyToOne
    private ProductsEntity product;

    private Integer qty;

    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(qty));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasketEntity getBasket() {
        return basket;
    }

    public void setBasket(BasketEntity basket) {
        this.basket = basket;
    }

    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}

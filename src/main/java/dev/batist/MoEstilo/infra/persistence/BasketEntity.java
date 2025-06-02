package dev.batist.MoEstilo.infra.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.entities.enums.PayMethod;
import dev.batist.MoEstilo.core.entities.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    private UUID id;
    private Long client;
    private BigDecimal subtotal;
    private List<Roupas> itens;
    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PayMethod payMathod;

    public void calculateTotalPrice(){
        this.subtotal = itens.stream()
                .map(itens -> itens.getValor().multiply(BigDecimal.valueOf(itens.getQte())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BasketEntity() {
    }

    public BasketEntity(UUID id, Long client, BigDecimal subtotal, List<Roupas> itens, Status status, PayMethod payMathod) {
        this.id = id;
        this.client = client;
        this.subtotal = subtotal;
        this.itens = itens;
        this.status = status;
        this.payMathod = payMathod;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public List<Roupas> getItens() {
        return itens;
    }

    public void setItens(List<Roupas> itens) {
        this.itens = itens;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PayMethod getPayMathod() {
        return payMathod;
    }

    public void setPayMathod(PayMethod payMathod) {
        this.payMathod = payMathod;
    }
}

package dev.batist.MoEstilo.core.entities;

import dev.batist.MoEstilo.core.entities.enums.PayMethod;
import dev.batist.MoEstilo.core.entities.enums.Status;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Basket {
    private UUID id;
    private Long client;
    private BigDecimal subtotal;
    private List<Roupas> itens;
    private Status status;
    private PayMethod payMathod;

    public Basket() {
    }

    public Basket(UUID id, Long client, BigDecimal subtotal, List<Roupas> itens, Status status, PayMethod payMethod) {
        this.id = id;
        this.client = client;
        this.subtotal = subtotal;
        this.itens = itens;
        this.status = status;
        this.payMathod = payMethod;
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

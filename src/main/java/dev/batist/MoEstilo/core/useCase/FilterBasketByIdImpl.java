package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.gateway.BasketGateway;

import java.util.UUID;

public class FilterBasketByIdImpl implements FilterBasketByIdUseCase{

    private final BasketGateway basketGateway;

    public FilterBasketByIdImpl(BasketGateway basketGateway) {
        this.basketGateway = basketGateway;
    }

    public Basket execute(Long client){
        return basketGateway.filter(client);
    }
}

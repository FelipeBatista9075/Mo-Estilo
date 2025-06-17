package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.gateway.BasketGateway;

import java.util.UUID;

public class UpdateBasketImpl implements UpdateBasketUsecase{

    public final BasketGateway basketGateway;

    public UpdateBasketImpl(BasketGateway basketGateway) {
        this.basketGateway = basketGateway;
    }

    public Basket execute(Long client, Basket basket){
        return basketGateway.updateBasket(client, basket);
    }
}

package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.gateway.BasketGateway;

import java.util.UUID;

public class DeleteBasketImpl implements DeleteBasketUseCase{
    private final BasketGateway basketGateway;

    public DeleteBasketImpl(BasketGateway basketGateway) {
        this.basketGateway = basketGateway;
    }

    public void execute(UUID id){
        basketGateway.deleteBasket(id);
    }
}

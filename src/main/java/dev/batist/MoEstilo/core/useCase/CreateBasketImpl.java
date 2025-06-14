package dev.batist.MoEstilo.core.useCase;


import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.gateway.BasketGateway;

public class CreateBasketImpl implements CreateBasketUseCase{

    private final BasketGateway basketGateway;

    public CreateBasketImpl(BasketGateway basketGateway) {
        this.basketGateway = basketGateway;
    }

    @Override
    public Basket execute(Basket basket) {
        return basketGateway.createBasket(basket);
    }
}

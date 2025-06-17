package dev.batist.MoEstilo.core.gateway;

import dev.batist.MoEstilo.core.entities.Basket;

import java.util.UUID;

public interface BasketGateway {
    public Basket createBasket(Basket basket);
    public void deleteBasket(UUID id);
    public Basket updateBasket(Long client, Basket basket);
    public Basket filter(Long id);
}

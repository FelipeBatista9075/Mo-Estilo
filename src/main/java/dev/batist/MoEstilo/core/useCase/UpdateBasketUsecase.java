package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Basket;

import java.util.UUID;

public interface UpdateBasketUsecase {

    public Basket execute(Long client, Basket basket);
}

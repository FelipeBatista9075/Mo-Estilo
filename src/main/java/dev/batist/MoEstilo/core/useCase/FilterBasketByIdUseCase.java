package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Basket;

import java.util.UUID;

public interface FilterBasketByIdUseCase {

    public Basket execute(Long client);
}

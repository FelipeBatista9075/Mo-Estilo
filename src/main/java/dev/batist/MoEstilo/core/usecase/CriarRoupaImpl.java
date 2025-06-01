package dev.batist.MoEstilo.core.usecase;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.gateway.RoupasGateway;

public class CriarRoupaImpl implements CriarRoupaUseCase{

    private final RoupasGateway roupasGateway;

    public CriarRoupaImpl(RoupasGateway roupasGateway) {
        this.roupasGateway = roupasGateway;
    }

    @Override
    public Roupas execute(Roupas roupas) {
        return roupasGateway.criarRoupas(roupas);
    }
}

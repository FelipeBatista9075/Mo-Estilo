package dev.batist.MoEstilo.core.usecase;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.gateway.RoupasGateway;

public class DeletarRoupaImpl implements DeletarRoupaUseCase{

    private final RoupasGateway roupasGateway;

    public DeletarRoupaImpl(RoupasGateway roupasGateway) {
        this.roupasGateway = roupasGateway;
    }

    @Override
    public void execute(Long id) {
        roupasGateway.deletar(id);
    }
}

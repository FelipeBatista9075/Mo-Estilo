package dev.batist.MoEstilo.core.usecase;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.gateway.RoupasGateway;

import java.util.List;

public class BuscarRoupaImpl implements BuscarRoupaUseCase{

    private final RoupasGateway roupasGateway;

    public BuscarRoupaImpl(RoupasGateway roupasGateway) {
        this.roupasGateway = roupasGateway;
    }

    @Override
    public List<Roupas> execute() {
        return roupasGateway.listarRoupas();
    }
}

package dev.batist.MoEstilo.core.gateway;

import dev.batist.MoEstilo.core.entities.Roupas;

import java.util.List;

public interface RoupasGateway {

    Roupas criarRoupas(Roupas roupas);
    List<Roupas> listarRoupas();
    void deletar(Long id);
}

package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;

public interface FilterByIdUseCase {

    public Products execute(Long id);
}

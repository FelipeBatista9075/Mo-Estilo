package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;

public interface UpdateProductUseCase {

    public Products execute(Long id, Products products);
}

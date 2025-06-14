package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;

public class UpdateProductImpl implements UpdateProductUseCase{

    private final ProductsGateway productsGateway;

    public UpdateProductImpl(ProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public Products execute(Long id, Products products) {
        return productsGateway.update(id, products);
    }
}

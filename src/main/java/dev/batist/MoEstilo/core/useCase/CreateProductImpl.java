package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;

public class CreateProductImpl implements CreateProductUseCase{

    private final ProductsGateway productsGateway;

    public CreateProductImpl(ProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public Products execute(Products products) {
        return productsGateway.createProduct(products);
    }
}

package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.gateway.ProductsGateway;

public class DeleteProductImpl implements DeleteProductUseCase{
    private final ProductsGateway productsGateway;

    public DeleteProductImpl(ProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public void execute(Long id) {
        productsGateway.delete(id);
    }
}

package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;

public class FilterByIdImpl implements FilterByIdUseCase{

    private final ProductsGateway productsGateway;

    public FilterByIdImpl(ProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public Products execute(Long id) {
        return productsGateway.byId(id);
    }
}

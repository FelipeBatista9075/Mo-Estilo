package dev.batist.MoEstilo.core.useCase;

import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;

import java.util.List;

public class ListProductsImpl implements ListProductsUseCase{

    private final ProductsGateway productsGateway;

    public ListProductsImpl(ProductsGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    @Override
    public List<Products> execute() {
        return productsGateway.list();
    }
}

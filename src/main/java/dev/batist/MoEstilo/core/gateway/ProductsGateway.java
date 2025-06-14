package dev.batist.MoEstilo.core.gateway;


import dev.batist.MoEstilo.core.entities.Products;

import java.util.List;

public interface ProductsGateway {
    public Products createProduct(Products product);
    public void delete(Long id);
    public List<Products> list();
    public Products byId(Long id);
    public Products update(Long id, Products products);
}

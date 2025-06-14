package dev.batist.MoEstilo.infra.gateway;


import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;
import dev.batist.MoEstilo.infra.mapper.ProducEntityMapper;
import dev.batist.MoEstilo.infra.percistence.ProductsEntity;
import dev.batist.MoEstilo.infra.repository.ProductsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductsRepositoryGateway implements ProductsGateway {

    private final ProductsRepository productsRepository;
    private final ProducEntityMapper mapper;

    public ProductsRepositoryGateway(ProductsRepository productsRepository, ProducEntityMapper mapper) {
        this.productsRepository = productsRepository;
        this.mapper = mapper;
    }

    @Override
    public Products createProduct(Products product) {
        ProductsEntity entity = mapper.toDomain(product);
        productsRepository.save(entity);
        return mapper.toEntity(entity);
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public List<Products> list() {
        List<ProductsEntity> list = productsRepository.findAll();
        return list.stream().map(mapper::toEntity).collect(Collectors.toList());
    }

    @Override
    public Products byId(Long id) {
        ProductsEntity entity = productsRepository.findById(id).orElse(null);
        Products domain = mapper.toEntity(entity);
        return domain;
    }

    @Override
    public Products update(Long id, Products updateProducts) {
        Optional<ProductsEntity> optProduct = productsRepository.findById(id);
        if (optProduct.isPresent()) {
            ProductsEntity products = optProduct.get();
            if (updateProducts.getName() != null) {
                products.setName(updateProducts.getName());
            }
            if (updateProducts.getDescription() != null) {
                products.setDescription(updateProducts.getDescription());
            }
            if (updateProducts.getPrice() != null) {
                products.setPrice(updateProducts.getPrice());
            }
            if (updateProducts.getQty() != null) {
                products.setQty(updateProducts.getQty());
            }
            productsRepository.save(products);
            return mapper.toEntity(products);
        }
        return null;
    }
}

package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.infra.percistence.ProductsEntity;
import org.springframework.stereotype.Component;

@Component
public class ProducEntityMapper {

    public Products toEntity(ProductsEntity products){
        return new Products(
                products.getId(),
                products.getName(),
                products.getDescription(),
                products.getPrice(),
                products.getQty()
        );
    }

    public ProductsEntity toDomain(Products products){
        return ProductsEntity.builder()
                .id(products.getId())
                .name(products.getName())
                .description(products.getDescription())
                .price(products.getPrice())
                .qty(products.getQty())
                .build();
    }
}

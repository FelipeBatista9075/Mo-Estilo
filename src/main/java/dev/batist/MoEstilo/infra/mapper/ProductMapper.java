package dev.batist.MoEstilo.infra.mapper;


import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.infra.dto.ProductsDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductsDto toDto(Products products){
        return ProductsDto.builder()
                .id(products.getId())
                .name(products.getName())
                .description(products.getDescription())
                .price(products.getPrice())
                .qty(products.getQty())
                .build();
    }

    public Products toDomain(ProductsDto productsDto){
        return new Products(
                productsDto.id(),
                productsDto.name(),
                productsDto.description(),
                productsDto.price(),
                productsDto.qty()
        );
    }
}

package dev.batist.MoEstilo.infra.mapper;


import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.infra.percistence.BasketEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BasketEntityMapper {

    private final ProducEntityMapper productMapper;

    public BasketEntityMapper(ProducEntityMapper productMapper) {
        this.productMapper = productMapper;
    }


    public BasketEntity toEntity(Basket basket){
        return BasketEntity.builder()
                .id(basket.getId())
                .client(basket.getClient())
                .totalPrice(basket.getTotalPrice())
                .products(basket.getProducts().stream()
                        .map(productMapper::toDomain)
                        .collect(Collectors.toList()))
                .status(basket.getStatus())
                .build();
    }

    public Basket toDomain(BasketEntity entity) {
        return new Basket(
                entity.getId(),
                entity.getClient(),
                entity.getTotalPrice(),
                entity.getProducts().stream()
                        .map(p -> new Products(
                                p.getId(),
                                p.getName(),
                                p.getDescription(),
                                p.getPrice(),
                                p.getQty()
                        ))
                        .collect(Collectors.toList()),
                entity.getStatus()
        );
    }
}
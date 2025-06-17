package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.infra.dto.BasketDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BasketMapper {
    private final ProducEntityMapper productsM;

    public BasketMapper(ProducEntityMapper productsM) {
        this.productsM = productsM;
    }

    public BasketDto toDto(Basket basket) {
        return BasketDto.builder()
                .client(basket.getClient())
                .products(basket.getProducts().stream()
                        .map(productsM::toDomain).collect(Collectors.toList()))
                .totalPrice(basket.getTotalPrice())
                .build();
    }
    public Basket toDomain(BasketDto dto) {
        return new Basket(
                dto.client(),
                dto.products().stream()
                        .map(productsM::toEntity)
                        .collect(Collectors.toList()),
                dto.totalPrice()
        );
    }
}

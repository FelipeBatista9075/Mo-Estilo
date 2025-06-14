package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.infra.dto.BasketDto;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {

    public BasketDto toDto(Basket basket){
        return BasketDto.builder()
                .id(basket.getId())
                .client(basket.getClient())
                .totalPrice(basket.getTotalPrice())
                .products(basket.getProducts())
                .status(basket.getStatus())
                .build();
    }

    public Basket toDomain(BasketDto dto){
        return new Basket(
                dto.id(),
                dto.client(),
                dto.totalPrice(),
                dto.products(),
                dto.status()
        );
    }
}

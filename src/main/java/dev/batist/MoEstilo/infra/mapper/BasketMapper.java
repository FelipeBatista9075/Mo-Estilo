package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.infra.dtos.BasketDto;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {

    public Basket toDomain(BasketDto dto){
        return new Basket(
                dto.id(),
                dto.client(),
                dto.subtotal(),
                dto.itens(),
                dto.status(),
                dto.payMathod()
        );
    }

    public BasketDto toDto(Basket basket){
        return BasketDto.builder()
                .id(basket.getId())
                .client(basket.getClient())
                .subtotal(basket.getSubtotal())
                .itens(basket.getItens())
                .status(basket.getStatus())
                .payMathod(basket.getPayMathod())
                .build();
    }
}

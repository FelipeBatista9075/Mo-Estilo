package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.infra.persistence.BasketEntity;
import org.springframework.stereotype.Component;

@Component
public class BasketEntityMapper {

    public BasketEntity toEntity(Basket basket){
        return BasketEntity.builder()
                .id(basket.getId())
                .client(basket.getClient())
                .subtotal(basket.getSubtotal())
                .itens(basket.getItens())
                .status(basket.getStatus())
                .payMathod(basket.getPayMathod())
                .build();
    }

    public Basket toDomain(BasketEntity entity){
        return new Basket(
                entity.getId(),
                entity.getClient(),
                entity.getSubtotal(),
                entity.getItens(),
                entity.getStatus(),
                entity.getPayMathod());
    }
}

package dev.batist.MoEstilo.infra.dto;

import dev.batist.MoEstilo.infra.percistence.ProductsEntity;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record BasketDto(
         Long client,
         List<ProductsEntity> products,
         BigDecimal totalPrice
) {
}

package dev.batist.MoEstilo.infra.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductsDto(
         Long id,
         String name,
         String description,
         BigDecimal price,
         Integer qty
) {
}

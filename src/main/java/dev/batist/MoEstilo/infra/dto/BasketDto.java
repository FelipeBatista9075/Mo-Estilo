package dev.batist.MoEstilo.infra.dto;


import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.entities.enums.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record BasketDto(
         UUID id,
         Long client,
         BigDecimal totalPrice,
         List<Products> products,
         Status status
) {
}

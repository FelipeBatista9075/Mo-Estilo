package dev.batist.MoEstilo.infra.dtos;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.entities.enums.PayMethod;
import dev.batist.MoEstilo.core.entities.enums.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record BasketDto(UUID id,
                        Long client,
                        BigDecimal subtotal,
                        List<Roupas> itens,
                        Status status,
                        PayMethod payMathod) {
}

package dev.batist.MoEstilo.infra.dtos;

import dev.batist.MoEstilo.core.entities.enums.Cor;
import dev.batist.MoEstilo.core.entities.enums.Genero;
import dev.batist.MoEstilo.core.entities.enums.Tamanho;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record RoupasDto(Long id,
                        String nome,
                        String descricao,
                        Tamanho tamanho,
                        BigDecimal valor,
                        String marca,
                        Genero genero,
                        Cor cor
) {
}

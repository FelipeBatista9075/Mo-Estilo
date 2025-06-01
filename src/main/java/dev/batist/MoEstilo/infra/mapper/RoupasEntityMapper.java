package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.infra.persistence.RoupasEntity;
import org.springframework.stereotype.Component;

@Component
public class RoupasEntityMapper {

    public RoupasEntity toEntity(Roupas roupas){
        return RoupasEntity.builder()
                .id(roupas.getId())
                .nome(roupas.getNome())
                .descricao(roupas.getDescricao())
                .tamanho(roupas.getTamanho())
                .valor(roupas.getValor())
                .marca(roupas.getMarca())
                .genero(roupas.getGenero())
                .cor(roupas.getCor())
                .build();
    }

    public Roupas toDomain(RoupasEntity entity){
        return new Roupas(entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getTamanho(),
                entity.getValor(),
                entity.getMarca(),
                entity.getGenero(),
                entity.getCor());
    }
}

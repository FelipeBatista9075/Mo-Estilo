package dev.batist.MoEstilo.infra.mapper;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.infra.dtos.RoupasDto;
import org.springframework.stereotype.Component;

@Component
public class RoupasMapper {

    public Roupas toDomain(RoupasDto dto){
        return new Roupas(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.tamanho(),
                dto.valor(),
                dto.marca(),
                dto.genero(),
                dto.cor());
    }

    public RoupasDto toDto(Roupas roupas){
        return RoupasDto.builder()
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
}

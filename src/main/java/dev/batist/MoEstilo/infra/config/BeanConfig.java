package dev.batist.MoEstilo.infra.config;

import dev.batist.MoEstilo.core.gateway.RoupasGateway;
import dev.batist.MoEstilo.core.usecase.*;
import dev.batist.MoEstilo.infra.mapper.RoupasEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    private final RoupasEntityMapper roupasEntityMapper;

    public BeanConfig(RoupasEntityMapper roupasEntityMapper) {
        this.roupasEntityMapper = roupasEntityMapper;
    }

    @Bean
    public CriarRoupaUseCase criarRoupaUseCase(RoupasGateway roupasGateway){
        return new CriarRoupaImpl(roupasGateway);
    }

    @Bean
    public BuscarRoupaUseCase buscarRoupaUseCase(RoupasGateway roupasGateway){
        return new BuscarRoupaImpl(roupasGateway);
    }

    @Bean
    public DeletarRoupaUseCase deletarRoupaUseCase(RoupasGateway roupasGateway){
        return new DeletarRoupaImpl(roupasGateway);
    }
}

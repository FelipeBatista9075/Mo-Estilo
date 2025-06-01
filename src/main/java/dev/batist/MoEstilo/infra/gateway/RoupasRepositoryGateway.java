package dev.batist.MoEstilo.infra.gateway;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.gateway.RoupasGateway;
import dev.batist.MoEstilo.infra.mapper.RoupasEntityMapper;
import dev.batist.MoEstilo.infra.persistence.RoupasEntity;
import dev.batist.MoEstilo.infra.repository.RoupasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoupasRepositoryGateway implements RoupasGateway {

    private final RoupasRepository repository;
    private final RoupasEntityMapper mapper;

    public RoupasRepositoryGateway(RoupasRepository repository, RoupasEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Roupas criarRoupas(Roupas roupas) {
        RoupasEntity entity = mapper.toEntity(roupas);
        RoupasEntity novaRoupa = repository.save(entity);
        return mapper.toDomain(novaRoupa);
    }

    @Override
    public List<Roupas> listarRoupas() {
        List<RoupasEntity> listar = repository.findAll();
        return listar.stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

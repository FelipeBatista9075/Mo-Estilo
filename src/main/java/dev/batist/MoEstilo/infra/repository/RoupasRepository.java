package dev.batist.MoEstilo.infra.repository;

import dev.batist.MoEstilo.infra.persistence.RoupasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoupasRepository extends JpaRepository<RoupasEntity, Long> {
}

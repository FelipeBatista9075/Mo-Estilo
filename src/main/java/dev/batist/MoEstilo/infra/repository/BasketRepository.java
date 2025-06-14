package dev.batist.MoEstilo.infra.repository;


import dev.batist.MoEstilo.core.entities.enums.Status;
import dev.batist.MoEstilo.infra.percistence.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

    Optional<BasketEntity> findByClientAndStatus(Long client, Status status);
}

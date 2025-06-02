package dev.batist.MoEstilo.infra.repository;

import dev.batist.MoEstilo.infra.persistence.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BasketRepository extends JpaRepository<BasketEntity, UUID> {
}

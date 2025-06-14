package dev.batist.MoEstilo.infra.repository;

import dev.batist.MoEstilo.infra.percistence.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}

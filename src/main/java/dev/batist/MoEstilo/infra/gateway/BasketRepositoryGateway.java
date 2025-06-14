package dev.batist.MoEstilo.infra.gateway;


import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.entities.enums.Status;
import dev.batist.MoEstilo.core.gateway.BasketGateway;
import dev.batist.MoEstilo.infra.mapper.BasketEntityMapper;
import dev.batist.MoEstilo.infra.percistence.BasketEntity;
import dev.batist.MoEstilo.infra.percistence.ProductsEntity;
import dev.batist.MoEstilo.infra.repository.BasketRepository;
import dev.batist.MoEstilo.infra.repository.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketRepositoryGateway implements BasketGateway {

    private List<ProductsEntity> getProducts(BasketEntity basket){
        List<ProductsEntity> products = new ArrayList<>();
        basket.getProducts().forEach(p -> {
            productsRepository.findById(p.getId()).ifPresent(item -> {
                products.add(ProductsEntity.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .price(item.getPrice())
                        .qty(item.getQty())
                        .build());
            });
        });
        return products;
    }

    private final ProductsRepository productsRepository;
    private final BasketRepository basketRepository;
    private final BasketEntityMapper mapper;

    public BasketRepositoryGateway(ProductsRepository productsRepository, BasketRepository basketRepository, BasketEntityMapper mapper) {
        this.productsRepository = productsRepository;
        this.basketRepository = basketRepository;
        this.mapper = mapper;

    }

    @Override
    public Basket createBasket(Basket basket) {
        basketRepository.findByClientAndStatus(basket.getClient(), Status.OPEN)
                .ifPresent(b -> {
                    throw new EntityNotFoundException();
                });
        List<ProductsEntity> products = getProducts(mapper.toEntity(basket));
        BasketEntity basketEntity = BasketEntity.builder()
                .client(basket.getClient())
                .status(Status.OPEN)
                .products(products)
                .build();

        basketEntity.calculateTotalPrice();
        BasketEntity seved = basketRepository.save(basketEntity);
        return mapper.toDomain(seved);
    }
}

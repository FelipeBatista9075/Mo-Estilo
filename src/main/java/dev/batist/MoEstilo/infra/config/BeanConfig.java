package dev.batist.MoEstilo.infra.config;


import dev.batist.MoEstilo.core.gateway.BasketGateway;
import dev.batist.MoEstilo.core.gateway.ProductsGateway;
import dev.batist.MoEstilo.core.useCase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductsGateway productsGateway){
        return new CreateProductImpl(productsGateway);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductsGateway productsGateway){
        return new DeleteProductImpl(productsGateway);
    }

    @Bean
    public FilterByIdUseCase filterByIdUseCase(ProductsGateway productsGateway){
        return new FilterByIdImpl(productsGateway);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(ProductsGateway productsGateway){
        return new ListProductsImpl(productsGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductsGateway productsGateway){
        return new UpdateProductImpl(productsGateway);
    }


    @Bean
    public CreateBasketUseCase createBasketUseCase(BasketGateway basketGateway){
        return new CreateBasketImpl(basketGateway);
    }
}

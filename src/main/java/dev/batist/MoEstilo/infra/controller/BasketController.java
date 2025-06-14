package dev.batist.MoEstilo.infra.controller;


import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.useCase.CreateBasketUseCase;
import dev.batist.MoEstilo.infra.dto.BasketDto;
import dev.batist.MoEstilo.infra.mapper.BasketMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moestilo/basket/")
public class BasketController {

    private final CreateBasketUseCase createBasketUseCase;
    private final BasketMapper basketMapper;

    public BasketController(CreateBasketUseCase createBasketUseCase, BasketMapper basketMapper) {
        this.createBasketUseCase = createBasketUseCase;
        this.basketMapper = basketMapper;
    }

    @PostMapping()
    public ResponseEntity<BasketDto> create(@RequestBody Basket basket){
        Basket execute = createBasketUseCase.execute(basket);
        BasketDto dto = basketMapper.toDto(basket);
        return ResponseEntity.ok(dto);
    }
}

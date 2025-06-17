package dev.batist.MoEstilo.infra.controller;


import dev.batist.MoEstilo.core.entities.Basket;
import dev.batist.MoEstilo.core.useCase.*;
import dev.batist.MoEstilo.infra.dto.BasketDto;
import dev.batist.MoEstilo.infra.mapper.BasketMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/moestilo/basket/")
public class BasketController {

    private final CreateBasketUseCase createBasketUseCase;
    private final DeleteBasketUseCase deleteBasketUseCase;
    private final FilterBasketByIdUseCase filterBasketByIdUseCase;
    private final UpdateBasketUsecase updateBasketUsecase;
    private final BasketMapper basketMapper;

    public BasketController(CreateBasketUseCase createBasketUseCase, DeleteBasketUseCase deleteBasketUseCase, FilterBasketByIdUseCase filterBasketByIdUseCase, UpdateBasketUsecase updateBasketUsecase, BasketMapper basketMapper) {
        this.createBasketUseCase = createBasketUseCase;
        this.deleteBasketUseCase = deleteBasketUseCase;
        this.filterBasketByIdUseCase = filterBasketByIdUseCase;
        this.updateBasketUsecase = updateBasketUsecase;
        this.basketMapper = basketMapper;
    }

    @PostMapping()
    public ResponseEntity<BasketDto> create(@RequestBody Basket basket){
        Basket execute = createBasketUseCase.execute(basket);
        BasketDto dto = basketMapper.toDto(basket);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        deleteBasketUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{client}")
    public ResponseEntity<BasketDto> filter(@PathVariable Long client){
        Basket execute = filterBasketByIdUseCase.execute(client);
        BasketDto dto = basketMapper.toDto(execute);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("{client}")
    public ResponseEntity<BasketDto> update(@PathVariable Long client, @RequestBody BasketDto dto){
        Basket execute = updateBasketUsecase.execute(client, basketMapper.toDomain(dto));
        BasketDto dto1 = basketMapper.toDto(execute);
        return ResponseEntity.status(HttpStatus.OK).body(dto1);
    }
}

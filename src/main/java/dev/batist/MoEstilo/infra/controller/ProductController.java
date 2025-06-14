package dev.batist.MoEstilo.infra.controller;


import dev.batist.MoEstilo.core.entities.Products;
import dev.batist.MoEstilo.core.useCase.*;
import dev.batist.MoEstilo.infra.dto.ProductsDto;
import dev.batist.MoEstilo.infra.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moestilo/")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final FilterByIdUseCase filterByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase, FilterByIdUseCase filterByIdUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase, ProductMapper productMapper) {
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.filterByIdUseCase = filterByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.productMapper = productMapper;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductsDto products){
        createProductUseCase.execute(productMapper.toDomain(products));
        Map<String, Object> msg = new HashMap<>();
        msg.put("Created:", products);
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

    @GetMapping()
    public ResponseEntity<List<ProductsDto>> list(){
        List<Products> list = listProductsUseCase.execute();
        List<ProductsDto> dto =list.stream().map(productMapper::toDto).toList();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductsDto> filter(@PathVariable Long id){
        Products execute = filterByIdUseCase.execute(id);
        ProductsDto dto = productMapper.toDto(execute);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ProductsDto> update(@PathVariable Long id, @RequestBody ProductsDto products){
        Products execute = updateProductUseCase.execute(id, productMapper.toDomain(products));
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toDto(execute));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        deleteProductUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

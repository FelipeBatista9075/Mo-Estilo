package dev.batist.MoEstilo.infra.controller;

import dev.batist.MoEstilo.core.entities.Roupas;
import dev.batist.MoEstilo.core.usecase.BuscarRoupaUseCase;
import dev.batist.MoEstilo.core.usecase.CriarRoupaUseCase;
import dev.batist.MoEstilo.core.usecase.DeletarRoupaUseCase;
import dev.batist.MoEstilo.infra.dtos.RoupasDto;
import dev.batist.MoEstilo.infra.mapper.RoupasMapper;
import dev.batist.MoEstilo.infra.persistence.RoupasEntity;
import dev.batist.MoEstilo.infra.repository.RoupasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moestilo/")
public class RoupasController {

    private final CriarRoupaUseCase criarRoupaUseCase;
    private final DeletarRoupaUseCase deletarRoupaUseCase;
    private final BuscarRoupaUseCase buscarRoupaUseCase;
    private final RoupasMapper roupasMapper;

    public RoupasController(CriarRoupaUseCase criarRoupaUseCase, DeletarRoupaUseCase deletarRoupaUseCase, BuscarRoupaUseCase buscarRoupaUseCase, RoupasMapper roupasMapper) {
        this.criarRoupaUseCase = criarRoupaUseCase;
        this.deletarRoupaUseCase = deletarRoupaUseCase;
        this.buscarRoupaUseCase = buscarRoupaUseCase;
        this.roupasMapper = roupasMapper;
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criar(@RequestBody RoupasDto dto){
        criarRoupaUseCase.execute(roupasMapper.toDomain(dto));
        Map<String, Object> msg = new HashMap<>();
        msg.put("Message:", "Created");
        msg.put("Description", roupasMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

    @GetMapping()
    public ResponseEntity<List<RoupasDto>> listar(){
        List<Roupas> listDomain = buscarRoupaUseCase.execute();
        List<RoupasDto> listEntity = listDomain.stream().map(roupasMapper::toDto).toList();
        return ResponseEntity.ok().body(listEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deletarRoupaUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

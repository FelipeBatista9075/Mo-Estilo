package dev.batist.MoEstilo.infra.controller;

import dev.batist.MoEstilo.infra.dtos.RoupasDto;
import dev.batist.MoEstilo.infra.persistence.RoupasEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moestilo/")
public class RoupasController {

    @PostMapping("postar")
    public ResponseEntity<Map<String, Object>> criar(@RequestBody RoupasDto dto){
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<RoupasEntity> listar(){
        return ResponseEntity.ok().build();
    }

}

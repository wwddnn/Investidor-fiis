package com.nicodemus.fiis.controllers;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.services.FiiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fiis")
public class FiiController {

    @Autowired
    private FiiService fiiService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FiiDTO> findById(@PathVariable Long id) {
        FiiDTO dto = fiiService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<FiiDTO>> findAll(Pageable pageable) {
        Page<FiiDTO> dto = fiiService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FiiDTO> insert(@Valid @RequestBody FiiDTO dto) {
        dto = fiiService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FiiDTO> update(@PathVariable Long id, @Valid @RequestBody FiiDTO dto) {
        FiiDTO result = fiiService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fiiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //query methods. procura o invetidor pelo nome
    @GetMapping(value = "/nomes")
    public ResponseEntity<List<FiiDTO>> findFiiByNameContaining(@RequestParam(name = "nome", defaultValue = "") String nome) {
        List<FiiDTO> result1 = fiiService.findFiiByName(nome);
        return ResponseEntity.ok(result1);
    }

}















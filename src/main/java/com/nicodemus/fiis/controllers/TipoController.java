package com.nicodemus.fiis.controllers;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.DTO.TipoDTO;
import com.nicodemus.fiis.services.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/tipos")
public class TipoController {

    @Autowired
    private TipoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoDTO> findById(@PathVariable Long id) {
        TipoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TipoDTO>> findAll(Pageable pageable) {
        Page<TipoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TipoDTO> insert(@Valid @RequestBody TipoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoDTO> update(@PathVariable Long id, @Valid @RequestBody TipoDTO dto) {
        TipoDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}















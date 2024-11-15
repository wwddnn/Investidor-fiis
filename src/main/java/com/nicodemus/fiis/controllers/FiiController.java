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

@RestController
@RequestMapping(value = "/fiis")
public class FiiController {

    @Autowired
    private FiiService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FiiDTO> findById(@PathVariable Long id) {
        FiiDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<FiiDTO>> findAll(Pageable pageable) {
        Page<FiiDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FiiDTO> insert(@Valid @RequestBody FiiDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FiiDTO> update(@PathVariable Long id, @Valid @RequestBody FiiDTO dto) {
        FiiDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}















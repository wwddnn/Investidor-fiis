package com.nicodemus.fiis.controllers;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.services.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/investidores")
public class InvestidorController {

    //Dependency
    @Autowired
    private InvestidorService service;

    //GET method
    @GetMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> findById(@PathVariable Long id) {
        InvestidorDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    //GET method
    @GetMapping
    public ResponseEntity<Page<InvestidorDTO>> findAll(Pageable pageable) {
        Page<InvestidorDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    //POST method
    @PostMapping
    public ResponseEntity<InvestidorDTO> insert(@RequestBody InvestidorDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //PUT method
    @PutMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> update(@PathVariable Long id, @RequestBody InvestidorDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    //DELETE method
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}















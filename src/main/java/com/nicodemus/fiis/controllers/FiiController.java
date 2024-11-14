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

    //Dependency
    @Autowired
    private FiiService service;

    //GET method FINDBYID
    @GetMapping(value = "/{id}")
    public ResponseEntity<FiiDTO> findById(@PathVariable Long id) {
        FiiDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    //GET method FINDALL
    @GetMapping
    public ResponseEntity<Page<FiiDTO>> findAll(Pageable pageable) {
        Page<FiiDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    //POST method INSERT
    @PostMapping
    public ResponseEntity<FiiDTO> insert(@Valid @RequestBody FiiDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}















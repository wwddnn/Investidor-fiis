package com.nicodemus.fiis.controllers;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.services.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/investidores")
public class InvestidorController {

    @Autowired
    private InvestidorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> findById(@PathVariable Long id) {
        try {
            Optional<InvestidorDTO> investidor = service.findById(id);

            if (investidor.isPresent()) {
                return ResponseEntity.ok(investidor.get());
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<InvestidorDTO>> findAll(Pageable pageable) {
        Page<InvestidorDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InvestidorDTO> insert(@RequestBody InvestidorDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> update(@PathVariable Long id, @RequestBody InvestidorDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}















package com.nicodemus.fiis.controllers;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.services.InvestidorService;
import jakarta.validation.Valid;
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

    @Autowired
    private InvestidorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> findById(@PathVariable Long id) {
        InvestidorDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<InvestidorDTO>> findAll(Pageable pageable) {
        Page<InvestidorDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InvestidorDTO> insert(@Valid @RequestBody InvestidorDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //POST method INSERT**novo
    @PostMapping("/fii/{fiiId}/investidor/{investidorId}")
    public ResponseEntity<Investidor> addFiiToInvestidor(@PathVariable Long fiiId, @PathVariable Long investidorId) {
        Investidor investidor = service.addFiiToInvestidor(fiiId, investidorId);
        return ResponseEntity.ok(investidor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> update(@PathVariable Long id,@Valid @RequestBody InvestidorDTO dto) {
        InvestidorDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}















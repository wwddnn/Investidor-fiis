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
import java.util.List;

@RestController
@RequestMapping(value = "/investidores")
public class InvestidorController {

    @Autowired
    private InvestidorService investidorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> findById(@PathVariable Long id) {
        InvestidorDTO dto = investidorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<InvestidorDTO>> findAll(Pageable pageable) {
        Page<InvestidorDTO> dto = investidorService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InvestidorDTO> insert(@RequestBody InvestidorDTO dto) {
        dto = investidorService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //POST method INSERT**novo
    @PostMapping("/fii/{fiiId}/investidor/{investidorId}")
    public ResponseEntity<InvestidorDTO> addFiiToInvestidor(@PathVariable Long fiiId, @PathVariable Long investidorId) {
        InvestidorDTO investidor = investidorService.addFiiToInvestidor(fiiId, investidorId);
        return ResponseEntity.ok(investidor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InvestidorDTO> update(@PathVariable Long id, @RequestBody InvestidorDTO dto) {
        InvestidorDTO result = investidorService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        investidorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //query methods. procura o invetidor pelo nome
    @GetMapping(value = "/nomes")
    public ResponseEntity<List<InvestidorDTO>> findInvestidoresByName(@RequestParam(name = "nome", defaultValue = "") String nome) {
        List<InvestidorDTO> result1 = investidorService.findInvestidoresByName(nome);
        return ResponseEntity.ok(result1);
    }

}















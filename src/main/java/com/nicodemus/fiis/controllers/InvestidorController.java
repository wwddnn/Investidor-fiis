package com.nicodemus.fiis.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.services.InvestidorService;

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
}

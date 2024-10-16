package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository repository;

    @Transactional(readOnly = true)
    public InvestidorDTO findById(Long id) {
        Optional<Investidor> result =  repository.findById(id);
        Investidor investidor = result.get();
        InvestidorDTO dto = new InvestidorDTO();
        dto.setId(investidor.getId());
        dto.setNome(investidor.getNome());
        dto.setEmail(investidor.getEmail());
        dto.setTelefone(investidor.getTelefone());
        dto.setCorretora(investidor.getCorretora());

        return dto;
    }

}

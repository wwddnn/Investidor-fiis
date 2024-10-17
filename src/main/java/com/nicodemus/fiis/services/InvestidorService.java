package com.nicodemus.fiis.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.InvestidorRepository;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository repository;

    @Transactional(readOnly = true)
    public Optional<InvestidorDTO> findById(Long id) {
        Optional<Investidor> result = repository.findById(id);

        if (result.isPresent()) {
            Investidor investidor = result.get();
            InvestidorDTO dto = new InvestidorDTO();
            dto.setId(investidor.getId());
            dto.setNome(investidor.getNome());
            dto.setEmail(investidor.getEmail());
            dto.setTelefone(investidor.getTelefone());
            dto.setCorretora(investidor.getCorretora());

            return Optional.ofNullable(dto);
        }
        return null;
    }

}

package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.repositories.FiiRepository;
import com.nicodemus.fiis.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FiiService {

    @Autowired
    private FiiRepository repository;

    @Transactional(readOnly = true)
    public FiiDTO findById(Long id) {
        Fii fii = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        FiiDTO dto = new FiiDTO(fii);
        return dto;
    }

    //new**
    @Transactional(readOnly = true)
    public Fii getFii(Long id) {
        Fii fii = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return fii;
    }

    @Transactional(readOnly = true)
    public Page<FiiDTO> findAll(Pageable pageable) {
        Page<Fii> entity = repository.findAll(pageable);
        return entity.map(x -> new FiiDTO(x));
    }

    @Transactional
    public FiiDTO insert(FiiDTO dto) {
        Fii entity = new Fii();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity = repository.save(entity);
        return new FiiDTO(entity);
    }

}






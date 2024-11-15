package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.FiiRepository;
import com.nicodemus.fiis.services.exceptions.DatabaseException;
import com.nicodemus.fiis.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        Fii fii = repository.findById(id).get();
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

    @Transactional
    public FiiDTO update(Long id, FiiDTO dto) {
        try {
            Fii entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setDescricao(dto.getDescricao());
            return new FiiDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}






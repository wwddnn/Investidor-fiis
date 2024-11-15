package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.TipoDTO;
import com.nicodemus.fiis.entities.Tipo;
import com.nicodemus.fiis.repositories.TipoRepository;
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
public class TipoService {

    @Autowired
    private TipoRepository repository;

    @Transactional(readOnly = true)
    public TipoDTO findById(Long id) {
        Tipo tipo = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        TipoDTO dto = new TipoDTO(tipo);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<TipoDTO> findAll(Pageable pageable) {
        Page<Tipo> entity = repository.findAll(pageable);
        return entity.map(x -> new TipoDTO(x));
    }

    @Transactional
    public TipoDTO insert(TipoDTO dto) {
        Tipo entity = new Tipo();
        entity.setTipo(dto.getTipo());
        entity = repository.save(entity);
        return new TipoDTO(entity);
    }

    @Transactional
    public TipoDTO update(Long id, TipoDTO dto) {
        try {
            Tipo entity = repository.getReferenceById(id);
            entity.setTipo(dto.getTipo());
            return new TipoDTO(entity);
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






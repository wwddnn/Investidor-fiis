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

import java.util.List;

@Service
public class FiiService {

    @Autowired
    private FiiRepository fiiRepository;

    @Transactional(readOnly = true)
    public FiiDTO findById(Long id) {
        Fii fii = fiiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        FiiDTO dto = new FiiDTO(fii);
        return dto;
    }

    //new**
//    @Transactional(readOnly = true)
//    public Fii getFii(Long id) {
//        Fii fii = fiiRepository.findById(id).get();
//        return fii;
//    }

    @Transactional(readOnly = true)
    public Page<FiiDTO> findAll(Pageable pageable) {
        Page<Fii> entity = fiiRepository.findAll(pageable);
        return entity.map(x -> new FiiDTO(x));
    }

    @Transactional
    public FiiDTO insert(FiiDTO dto) {
        Fii entity = new Fii();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity = fiiRepository.save(entity);
        return new FiiDTO(entity);
    }

    @Transactional
    public FiiDTO update(Long id, FiiDTO dto) {
        try {
            Fii entity = fiiRepository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setDescricao(dto.getDescricao());
            return new FiiDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!fiiRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            fiiRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Transactional(readOnly = true)
    public List<FiiDTO> findFiiByName(String nome) {
        List<FiiDTO> result = fiiRepository.findFiiByName(nome);
        return result;
    }
}






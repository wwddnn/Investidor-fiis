package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.FiiRepository;
import com.nicodemus.fiis.repositories.InvestidorRepository;
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
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;
    @Autowired
    private FiiRepository fiiRepository;

    @Transactional(readOnly = true)
    public InvestidorDTO findById(Long id) {
        Investidor investidor = investidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        InvestidorDTO dto = new InvestidorDTO();
        dto.setId(investidor.getId());
        dto.setNome(investidor.getNome());
        dto.setEmail(investidor.getEmail());
        dto.setTelefone(investidor.getTelefone());
        dto.setCorretora(investidor.getCorretora());
        return new InvestidorDTO(investidor);
    }

    //new**
    @Transactional(readOnly = true)
    public Investidor addFiiToInvestidor(Long fiiId, Long investidorId) {
        Investidor investidor = investidorRepository.findById(investidorId).get();
        Fii fii = fiiRepository.findById(fiiId).get();
        investidor.getFiis().add(fii);
        investidorRepository.save(investidor);
        return investidor;
    }

    @Transactional(readOnly = true)
    public Page<InvestidorDTO> findAll(Pageable pageable) {
        Page<Investidor> entity = investidorRepository.findAll(pageable);
        return entity.map(x -> new InvestidorDTO(x));
    }

    @Transactional
    public InvestidorDTO insert(InvestidorDTO dto) {
        Investidor entity = new Investidor();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCorretora(dto.getCorretora());
        entity = investidorRepository.save(entity);
        return new InvestidorDTO(entity);
    }

    @Transactional
    public InvestidorDTO update(Long id, InvestidorDTO dto) {
        try {
            Investidor entity = investidorRepository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());
            entity.setTelefone(dto.getTelefone());
            entity.setCorretora(dto.getCorretora());
            entity = investidorRepository.save(entity);
            return new InvestidorDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!investidorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            investidorRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}






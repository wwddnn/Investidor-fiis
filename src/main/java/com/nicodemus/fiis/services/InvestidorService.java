package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.InvestidorCorretoraDTO;
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

import java.util.List;

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
    @Transactional
    public InvestidorDTO addFiiToInvestidor(Long fiiId, Long investidorId) {
        Investidor investidor = investidorRepository.getReferenceById(investidorId);
        Fii fii = fiiRepository.getReferenceById(fiiId);
        investidor.getFiis().add(fii);
        investidorRepository.save(investidor);
        return new InvestidorDTO(investidor);
    }

    @Transactional(readOnly = true)
    public Page<InvestidorDTO> findAll(Pageable pageable) {
        Page<Investidor> list = investidorRepository.findAll(pageable);
        Page<InvestidorDTO> dto = list.map(x -> new InvestidorDTO(x));
        return dto;
    }

    @Transactional
    public InvestidorDTO insert(InvestidorDTO dto) { //metodo para inserir um investidor novo
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

    //query methods. retorna o investidor de acordo com seu nome
    @Transactional(readOnly = true)
    public List<InvestidorDTO> findInvestidoresByName(String nome) {
        List<InvestidorDTO> result = investidorRepository.findInvestidoresByName(nome);
        return result;
    }

    //**new retorna a quantidade de corretoras que aparecem
    @Transactional(readOnly = true)
    public List<InvestidorCorretoraDTO> search1() {
        List<InvestidorCorretoraDTO> result = investidorRepository.search1();
        return result;
    }


}






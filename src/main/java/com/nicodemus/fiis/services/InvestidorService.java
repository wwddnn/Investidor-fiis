package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository repository;

    //this method find the Investor by id number.
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

    //this method find all Investors.
    @Transactional(readOnly = true)
    public Page<InvestidorDTO> findAll(Pageable pageable) {
        Page<Investidor> entity = repository.findAll(pageable);

        return entity.map(x -> new InvestidorDTO(x));
    }

    //this method insert a new Investor.
    @Transactional
    public InvestidorDTO insert(InvestidorDTO dto) {

        Investidor entity = new Investidor();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCorretora(dto.getCorretora());

        entity = repository.save(entity);

        return new InvestidorDTO(entity);
    }

    //this method update Investors in an idempotent way.
    @Transactional
    public InvestidorDTO update(Long id, InvestidorDTO dto) {

        Investidor entity = repository.getReferenceById(id);

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCorretora(dto.getCorretora());

        entity = repository.save(entity);

        return new InvestidorDTO(entity);
    }

    //this method delete Investors.
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}






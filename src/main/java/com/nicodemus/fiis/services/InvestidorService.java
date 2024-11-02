package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.repositories.InvestidorRepository;
import com.nicodemus.fiis.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvestidorService {

    //Dependency
    @Autowired
    private InvestidorRepository repository;

    //FIND BY ID method: this method searches for the investors by their id number.
    @Transactional(readOnly = true)
    public InvestidorDTO findById(Long id) {

        Investidor investidor = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

            InvestidorDTO dto = new InvestidorDTO();
            dto.setId(investidor.getId());
            dto.setNome(investidor.getNome());
            dto.setEmail(investidor.getEmail());
            dto.setTelefone(investidor.getTelefone());
            dto.setCorretora(investidor.getCorretora());

            return new InvestidorDTO(investidor);
    }


    //FIND ALL method: this method find for all Investors.
    @Transactional(readOnly = true)
    public Page<InvestidorDTO> findAll(Pageable pageable) {
        Page<Investidor> entity = repository.findAll(pageable);

        return entity.map(x -> new InvestidorDTO(x));
    }

    //INSERT method: this method register a new Investor on database.
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

    //UPDATE method: this method update Investors idempotently.
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

    //DELETE method: this method delete Investors from database.
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}






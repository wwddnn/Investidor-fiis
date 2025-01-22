package com.nicodemus.fiis.services;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.DTO.FiisimpleDTO;
import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.entities.Tipo;
import com.nicodemus.fiis.repositories.FiiRepository;
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

import java.util.List;

@Service
public class FiiService {

    @Autowired
    private FiiRepository fiiRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Transactional(readOnly = true)
    public FiiDTO findById(Long id) {
        Fii entity = fiiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        FiiDTO dto = new FiiDTO(entity);
        return dto;
    }

    //new**
//    @Transactional(readOnly = true)
//    public Fii getFii(Long id) {
//        Fii fii = fiiRepository.findById(id).get();
//        return fii;
//    }

    @Transactional(readOnly = true)
    public Page<FiisimpleDTO> findAll(Pageable pageable) {
        Page<Fii> entity = fiiRepository.findAll(pageable);
        return entity.map(x -> new FiisimpleDTO(x));
    }

    @Transactional
    public FiiDTO insert(FiiDTO dto) { //esse metodo insere um novo fii no banco de dados, e tambem seu tipo aninhado
        Fii entity = new Fii();
        entity.setNome(dto.getNome()); //nao inserimos o id, pq é inserido automaticamente no post
        entity.setDescricao(dto.getDescricao());

        Tipo tipo = tipoRepository.getReferenceById(dto.getTipoDto().getId()); //busco no banco o tipo que ja existe com base no id que vem do dto
        //Tipo tipo = new Tipo(); //crio uma entidade tipo no banco de dados //esta aninhada ao Fii
        //tipo.setId(dto.getTipoDto().getId());

        entity.setTipo(tipo); //vou setar na minha entidade, o tipo que esta aninhado

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






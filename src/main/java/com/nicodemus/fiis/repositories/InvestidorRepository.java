package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.DTO.InvestidorCorretoraDTO;
import com.nicodemus.fiis.DTO.InvestidorDTO;
import com.nicodemus.fiis.entities.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Long> {

    //procura o investidor pelo nome, digitando a primeira letra do nome.
    @Query("SELECT obj "
                + "FROM Investidor obj "
                + "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT(:nome, '%')) ")
    List<InvestidorDTO> findInvestidoresByName(String nome);


    @Query("SELECT new com.nicodemus.fiis.DTO.InvestidorCorretoraDTO(obj.corretora, COUNT(obj.corretora)) "
            + "FROM Investidor obj "
            + "GROUP BY corretora "
            + "ORDER BY COUNT(obj.corretora) desc")
    List<InvestidorCorretoraDTO> search1();

    
}

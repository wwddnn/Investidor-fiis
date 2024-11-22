package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.DTO.FiiDTO;
import com.nicodemus.fiis.entities.Fii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiiRepository extends JpaRepository<Fii, Long> {

    @Query("SELECT obj "
            + "FROM Fii obj "
            + "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT(:nome, '%')) ")
    List<FiiDTO> findFiiByName(String nome);

}

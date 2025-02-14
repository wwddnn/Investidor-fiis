package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.DTO.TipoDTO;
import com.nicodemus.fiis.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {

    //procura o tipo do fii pelo seu nome, digitando a primeira letra.
    @Query("SELECT obj "
                + "FROM Tipo obj "
                + "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT(:nome, '%')) ")
    List<TipoDTO> findTipoByName(String nome);

}

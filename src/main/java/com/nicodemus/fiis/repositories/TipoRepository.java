package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {

}

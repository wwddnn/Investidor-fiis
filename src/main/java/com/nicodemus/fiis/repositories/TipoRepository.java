package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Investidor;
import com.nicodemus.fiis.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

}

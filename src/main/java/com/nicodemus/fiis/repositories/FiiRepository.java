package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.entities.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiiRepository extends JpaRepository<Fii, Long> {

}

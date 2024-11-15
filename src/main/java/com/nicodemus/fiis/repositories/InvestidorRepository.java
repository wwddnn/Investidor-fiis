package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestidorRepository extends JpaRepository<Investidor, Long> {

    @Query("SELECT obj FROM Investidor obj JOIN FETCH  obj.fiis")
    List<Investidor> findInvestidoresWithFiis();
}

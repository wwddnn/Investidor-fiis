package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Long> {

}

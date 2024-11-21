package com.nicodemus.fiis.repositories;

import com.nicodemus.fiis.entities.Fii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiiRepository extends JpaRepository<Fii, Long> {

}

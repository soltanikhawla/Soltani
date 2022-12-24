package com.magma.testspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.Anomalie;
@Repository
public interface AnomalieRepository extends JpaRepository<Anomalie, Long> {

}

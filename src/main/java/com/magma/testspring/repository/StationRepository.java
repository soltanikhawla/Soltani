package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.Station;
@Repository
public interface StationRepository extends JpaRepository<Station, Long>{

}

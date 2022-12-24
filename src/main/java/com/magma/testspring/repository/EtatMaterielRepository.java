package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.EtatMateriel;
@Repository
public interface EtatMaterielRepository extends JpaRepository<EtatMateriel, Long> {

}

package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.EtatDepeche;

@Repository
public interface EtatDepecheRepository extends JpaRepository<EtatDepeche, Long>{
	EtatDepeche findByLibelle(String libelle);

}

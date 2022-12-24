package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.TypeDepeche;
@Repository
public interface TypeDepecheRepository extends JpaRepository<TypeDepeche, Long>{

}

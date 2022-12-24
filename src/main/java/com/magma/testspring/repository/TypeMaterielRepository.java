package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.TypeMateriel;
@Repository
public interface TypeMaterielRepository extends JpaRepository<TypeMateriel, Long> {

}

package com.magma.testspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.Materiel;
@Repository
public interface MaterialRepository extends JpaRepository<Materiel, Long>  {

}

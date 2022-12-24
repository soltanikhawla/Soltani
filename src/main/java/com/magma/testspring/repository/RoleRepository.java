package com.magma.testspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByLibelle(String libelle);
	

}

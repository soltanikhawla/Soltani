package com.magma.testspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByLogin(String login);
	public Optional<Utilisateur> findUserByLogin(String login);
	Boolean existsByLogin(String login);
	
	List <Utilisateur> findByfirstName(String firstName);

	
	@Query(
			  value = "SELECT * FROM t_utilisateur tu, t_role ro WHERE  tu.id_role=ro.id AND ro.libelle='technicien' ;", 
			  nativeQuery = true)
	List<Utilisateur> getAllUsersTechnicien();
	


}

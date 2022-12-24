package com.magma.testspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.magma.testspring.model.DepDepeches;
@Repository
public interface DepDepechesRepository extends JpaRepository<DepDepeches, Long> {
	DepDepeches findDepecheById(Long id);
	
	@Query(
			  value = "SELECT * FROM t_dep_depeches WHERE id_utilisateur IS NOT NULL ;", 
			  nativeQuery = true)
	List<DepDepeches> findAllDepeche();
	
	
	@Query(
			  value = "SELECT * FROM t_dep_depeches WHERE id_utilisateur IS NOT NULL ;", 
			  nativeQuery = true)
	List<DepDepeches> findDepecheByDate();
	
	@Query(
			  value = "SELECT * FROM t_dep_depeches WHERE id_utilisateur IS NULL ;", 
			  nativeQuery = true)
	List<DepDepeches> findAllDepecheSimple();
	
	@Query(
			  value = "SELECT COUNT(*) FROM t_dep_depeches WHERE id_etat_depeche = 1;", 
			  nativeQuery = true)
	long nombreDepecheTodo();
	
	@Query(
			  value = "SELECT COUNT(*) FROM t_dep_depeches WHERE id_etat_depeche = 2;", 
			  nativeQuery = true)
	long nombreDepecheOnGoing();
	
	@Query(
			  value = "SELECT COUNT(*) FROM t_dep_depeches WHERE id_etat_depeche = 3;", 
			  nativeQuery = true)
	long nombreDepecheDone();

	
}

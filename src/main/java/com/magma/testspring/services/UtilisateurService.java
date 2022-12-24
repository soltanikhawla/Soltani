package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Role;
import com.magma.testspring.model.Utilisateur;
import com.magma.testspring.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	private final UtilisateurRepository utilisateurRepository;

	@Autowired
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		
		this.utilisateurRepository = utilisateurRepository;
	}
	
	
	// Current user 
	@Transactional
	public Utilisateur getCurrentUser() {
		SecurityContext principal = SecurityContextHolder.getContext();
		Authentication authentication = principal.getAuthentication();
		Utilisateur login = null ;
		if (authentication != null)
            if (authentication.getPrincipal() instanceof Utilisateur)
            	login = ((Utilisateur) authentication.getPrincipal());
            else if (authentication.getPrincipal() instanceof String)
            	login = (Utilisateur) authentication.getPrincipal();
		return login;
	}
	
	// Find All Users  
	@Transactional
	public List<Utilisateur> findAllUsers() {
        return utilisateurRepository.findAll();
    }
	
	// Find All Users Technicien
	@Transactional
	public List<Utilisateur> findAllUsersTechnicien() {
        return utilisateurRepository.getAllUsersTechnicien();
    }
	
	//find users by firstName
	@Transactional
	public List<Utilisateur> findbyfirstName(String firstName) {
        return utilisateurRepository.findByfirstName(firstName);
    }
	
	
	//Get User By Id 
	@Transactional
	public Utilisateur getUserById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }
	
	
	
	//Delete User By id 
	@Transactional
	public void deleteUser(Long id) {
		Utilisateur user = utilisateurRepository.getOne(id);
        user.getDepDepeches().forEach(dep -> dep.setUtilisateur(null));
        utilisateurRepository.delete(user);
    }


	
	

}

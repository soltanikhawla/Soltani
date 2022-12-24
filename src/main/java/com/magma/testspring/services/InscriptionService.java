package com.magma.testspring.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Role;
import com.magma.testspring.model.Utilisateur;
import com.magma.testspring.repository.RoleRepository;
import com.magma.testspring.repository.UtilisateurRepository;

@Service
public class InscriptionService {
	
	final private UtilisateurRepository utilisateurRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	
	
	public InscriptionService(UtilisateurRepository utilisateurRepository, BCryptPasswordEncoder passwordEncoder,
			RoleRepository roleRepository) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
	}

	@Transactional
	public Optional<Utilisateur> findUserByLogin(String login){
		return utilisateurRepository.findUserByLogin(login);
	}
	
	public boolean userExists(String login) {
		return findUserByLogin(login).isPresent();
	}
	
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}


	public Utilisateur inscription(Utilisateur utilisateur) { 
		//password encryption
		String password = passwordEncoder.encode(utilisateur.getPassword());
		utilisateur.setPassword(password);
		Role role = roleRepository.findByLibelle("Admin");
		utilisateur.setRole(role);
		return utilisateurRepository.save(utilisateur);
	}



}

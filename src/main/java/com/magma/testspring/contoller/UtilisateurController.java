package com.magma.testspring.contoller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Role;
import com.magma.testspring.model.Utilisateur;
import com.magma.testspring.repository.RoleRepository;
import com.magma.testspring.repository.UtilisateurRepository;
import com.magma.testspring.services.InscriptionService;
import com.magma.testspring.services.UtilisateurService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UtilisateurController {
	
	private final InscriptionService inscriptionService;
	private final UtilisateurRepository utilisateurRepository;
	private final UtilisateurService utilisateurService;
	private final RoleRepository roleRepository;
	
	
	public UtilisateurController(InscriptionService inscriptionService, UtilisateurRepository utilisateurRepository,
			UtilisateurService utilisateurService, RoleRepository roleRepository) {
		super();
		this.inscriptionService = inscriptionService;
		this.utilisateurRepository = utilisateurRepository;
		this.utilisateurService = utilisateurService;
		this.roleRepository = roleRepository;
	}


	@GetMapping("/currentUser")
	@ResponseBody
	public Optional<Utilisateur> currentUserName(Principal principal) {
		String login = principal.getName();
		return inscriptionService.findUserByLogin(login) ;
	}

	//Find All Users 
	@GetMapping("/allUsers")
	public List<Utilisateur> findAllUsers(){
		return utilisateurService.findAllUsers();
	}
	
	//find users technicien
	@GetMapping("/allUsersTechnicien")
	public List<Utilisateur> findAllUsersTechnicien(){
		return utilisateurService.findAllUsersTechnicien();
	}
	
	
	//find user by User Id
	@GetMapping("/findUser/{userId}")
	public Utilisateur findUserById(@PathVariable Long userId){
		return utilisateurService.getUserById(userId);
	}


	// Delete User  
	@GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		utilisateurService.deleteUser(id);
        return ResponseEntity.ok().body(id);
    }



}

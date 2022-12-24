package com.magma.testspring.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Anomalie;
import com.magma.testspring.model.AuthenticationResponse;
import com.magma.testspring.model.DepDepeches;
import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.model.Materiel;
import com.magma.testspring.model.NombreDepecheParStatus;
import com.magma.testspring.model.Services;
import com.magma.testspring.model.Station;
import com.magma.testspring.model.TypeDepeche;
import com.magma.testspring.model.Utilisateur;
import com.magma.testspring.repository.AnomalieRepository;
import com.magma.testspring.repository.DepDepechesRepository;
import com.magma.testspring.repository.EtatDepecheRepository;
import com.magma.testspring.repository.MaterialRepository;
import com.magma.testspring.repository.ServicesRepository;
import com.magma.testspring.repository.StationRepository;
import com.magma.testspring.repository.TypeDepecheRepository;
import com.magma.testspring.repository.UtilisateurRepository;
import com.magma.testspring.services.DepDepechesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/DepDepeches")
public class DepDepechesController {
	
	private final DepDepechesRepository depDepechesRepository;
	private final UtilisateurRepository utilisateurRepository;
	private final StationRepository stationRepository;
	private final MaterialRepository materialRepository;
	private final AnomalieRepository anomalieRepository;
	private final ServicesRepository servicesRepository;
	private final TypeDepecheRepository typeDepecheRepository;
	private final DepDepechesService depDepechesService;
	private final EtatDepecheRepository etatDepecheRepository;

	
	@Autowired
	public DepDepechesController(DepDepechesRepository depDepechesRepository, UtilisateurRepository utilisateurRepository,
			StationRepository stationRepository, MaterialRepository materialRepository,
			AnomalieRepository anomalieRepository, ServicesRepository servicesRepository,
			TypeDepecheRepository typeDepecheRepository, DepDepechesService depDepechesService, EtatDepecheRepository etatDepecheRepository) {
		this.depDepechesRepository = depDepechesRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.stationRepository = stationRepository;
		this.materialRepository = materialRepository;
		this.anomalieRepository = anomalieRepository;
		this.servicesRepository = servicesRepository;
		this.typeDepecheRepository = typeDepecheRepository;
		this.depDepechesService = depDepechesService;
		this.etatDepecheRepository = etatDepecheRepository;
	}



	//Add depeches 
    @PostMapping("/addDepDepeches/{destinataireId}/{stationId}/{equipementId}/{anomalieId}/{serviceId}/{typeDepecheId}/{statusId}")
    public ResponseEntity<?> addDepDepeches(@RequestBody DepDepeches depDepeches, @PathVariable(value = "destinataireId") Long destinataireId,
    		@PathVariable(value = "stationId") Long stationId, @PathVariable(value = "equipementId") Long equipementId,
    		@PathVariable(value = "anomalieId") Long anomalieId, @PathVariable(value = "serviceId") Long serviceId,
    		@PathVariable(value = "typeDepecheId") Long typeDepecheId, @PathVariable(value = "statusId") Long statusId) { 
    	Utilisateur utilisateur = utilisateurRepository.getOne(destinataireId);
    	Station station = stationRepository.getOne(stationId);
    	Materiel materiel = materialRepository.getOne(equipementId);
    	Anomalie anomalie = anomalieRepository.getOne(anomalieId);
    	Services services = servicesRepository.getOne(serviceId);
    	TypeDepeche typeDepeche = typeDepecheRepository.getOne(typeDepecheId);
    	EtatDepeche etatDepeche = etatDepecheRepository.getOne(statusId);
    	depDepeches.setUtilisateur(utilisateur);
    	depDepeches.setStation(station);
    	depDepeches.setMateriel(materiel);
    	depDepeches.setAnomalie(anomalie);
    	depDepeches.setServices(services);
    	depDepeches.setTypeDepeche(typeDepeche);
    	depDepeches.setEtatDepeche(etatDepeche);
    	depDepechesRepository.save(depDepeches);
    	

        return ResponseEntity.ok().body( depDepeches);
    }
    
    //get depeche par Id
  	@GetMapping("/depecheDetaille/{depecheId}")
  	public DepDepeches findDepecheById(@PathVariable Long depecheId){
  		return depDepechesRepository.findDepecheById(depecheId);
  	}  
    
  //Add depeches 
    @PostMapping("/addDepDepechesSimple/{stationId}/{equipementId}/{anomalieId}")
    public ResponseEntity<?> addDepDepechesSimple(@RequestBody DepDepeches depDepeches, 
    		@PathVariable(value = "stationId") Long stationId, @PathVariable(value = "equipementId") Long equipementId,
    		@PathVariable(value = "anomalieId") Long anomalieId) { 

    	Station station = stationRepository.getOne(stationId);
    	Materiel materiel = materialRepository.getOne(equipementId);
    	Anomalie anomalie = anomalieRepository.getOne(anomalieId);
    	EtatDepeche etatDepeche = etatDepecheRepository.findByLibelle("A faire");
    	depDepeches.setEtatDepeche(etatDepeche);
    	depDepeches.setStation(station);
    	depDepeches.setMateriel(materiel);
    	depDepeches.setAnomalie(anomalie);
    	depDepechesRepository.save(depDepeches);
        return ResponseEntity.ok().body( depDepeches);
    }
    
    // All depeches
  	@GetMapping("/allDepeche")
  	public List<DepDepeches> findAllDepeche(){
  		return depDepechesRepository.findAllDepeche();
  	}
  	
 // All depeches
   	@GetMapping("/allDepecheSimple")
   	public List<DepDepeches> findAllDepecheSimple(){
   		return depDepechesRepository.findAllDepecheSimple();
   	}

	// Delete depeche  
	@GetMapping("/delete/{depecheId}")
    public ResponseEntity<?> deleteDepeche(@PathVariable Long depecheId) {
		depDepechesService.deleteDepeche(depecheId);
        return ResponseEntity.ok().body(depecheId);
    }
	
	// get all status
	@GetMapping("/allEtatDepeche")
  	public List<EtatDepeche> findAllEtatDepeche(){
  		return etatDepecheRepository.findAll();
  	}
	
	// change etat depeche
	@GetMapping("/updateEtatDepeche/{etatDepecheId}/{depecheId}")
  	public ResponseEntity<?> updateEtatDepeche(@PathVariable Long etatDepecheId, @PathVariable Long depecheId){
		EtatDepeche etatDepeche = etatDepecheRepository.getOne(etatDepecheId);
		DepDepeches depDepeches = depDepechesRepository.getOne(depecheId);
		depDepechesService.updateEtatDepeche(etatDepeche, depDepeches);
  		return ResponseEntity.ok().body(depecheId);
  	}
	
	//update dépéches
	@PutMapping("/updateDepeches/{destinataireId}/{stationId}/{equipementId}/{anomalieId}/{serviceId}/{typeDepecheId}/{statusId}/{id}")
	public ResponseEntity<DepDepeches>updateDepeches(@RequestBody DepDepeches depDepeches, @PathVariable(value = "destinataireId") Long destinataireId,
    		@PathVariable(value = "stationId") Long stationId, @PathVariable(value = "equipementId") Long equipementId,
    		@PathVariable(value = "anomalieId") Long anomalieId, @PathVariable(value = "serviceId") Long serviceId,
    		@PathVariable(value = "typeDepecheId") Long typeDepecheId, @PathVariable(value = "statusId") Long statusId, 
    		@PathVariable Long id){
		
		Utilisateur utilisateur = utilisateurRepository.getOne(destinataireId);
    	Station station = stationRepository.getOne(stationId);
    	Materiel materiel = materialRepository.getOne(equipementId);
    	Anomalie anomalie = anomalieRepository.getOne(anomalieId);
    	Services services = servicesRepository.getOne(serviceId);
    	TypeDepeche typeDepeche = typeDepecheRepository.getOne(typeDepecheId);
    	EtatDepeche etatDepeche = etatDepecheRepository.getOne(statusId);
    	
		//DepDepeches depDepeche =depDepechesRepository.getOne(id);
		Optional<DepDepeches> depDepeche = depDepechesRepository.findById(id);
		if (!depDepeche.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
		depDepeches.setId(depDepeche.get().getId());
		depDepeches.setAnomalie(anomalie);
		depDepeches.setUtilisateur(utilisateur);
		depDepeches.setStation(station); 
		depDepeches.setMateriel(materiel);
		depDepeches.setServices(services);
		depDepeches.setEtatDepeche(etatDepeche);
		depDepeches.setTypeDepeche(typeDepeche);
		
		DepDepeches updateDepeches= depDepechesRepository.save(depDepeches);
		return ResponseEntity.ok(updateDepeches);
	}
	
	// get nombre depeche To Do
	@GetMapping("/nombreDepecheToDo")
  	public ResponseEntity<?> findnombreDepecheToDo(){
		final long nbr = depDepechesService.nombreDepecheToDo();
		return ResponseEntity.ok(new NombreDepecheParStatus(nbr));
  	}
	
	// get nombre depeche OnGoing
	@GetMapping("/nombreDepecheOnGoing")
  	public ResponseEntity<?> findnombreDepecheOnGoing(){
		final long nbr = depDepechesService.nombreDepecheOnGoing();
  		return ResponseEntity.ok(new NombreDepecheParStatus(nbr));
  	}
		
	// get nombre depeche Done
	@GetMapping("/nombreDepecheDone")
  	public ResponseEntity<?> findnombreDepecheDone(){
		final long nbr = depDepechesService.nombreDepecheDone();
  		return ResponseEntity.ok(new NombreDepecheParStatus(nbr));
  	}
	 
}

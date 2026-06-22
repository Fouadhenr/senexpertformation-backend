package sn.senexpertformation.utilisateurs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.utilisateurs.dto.InstitutionDTO;
import sn.senexpertformation.utilisateurs.dto.RoleDTO;
import sn.senexpertformation.utilisateurs.dto.UtilisateurDTO;
import sn.senexpertformation.utilisateurs.entity.Administrateur;
import sn.senexpertformation.utilisateurs.entity.AgentInstitution;
import sn.senexpertformation.utilisateurs.entity.Institution;
import sn.senexpertformation.utilisateurs.entity.Particulier;
import sn.senexpertformation.utilisateurs.entity.Role;
import sn.senexpertformation.utilisateurs.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;
	private final PasswordEncoder passwordEncoder;

	public UtilisateurController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.passwordEncoder = passwordEncoder;
	}

	// --- Endpoints pour Institution ---
	@PostMapping("/institutions")
	public ResponseEntity<Institution> creerInstitution(@RequestBody InstitutionDTO dto) {
		Institution institution = new Institution();
		institution.setRaisonSociale(dto.getRaisonSociale());
		institution.setTypeInstitution(dto.getTypeInstitution());
		institution.setAdresse(dto.getAdresse());
		institution.setSecteurActivite(dto.getSecteurActivite());
		institution.setStatutValidation("EN_ATTENTE");

		Institution saved = utilisateurService.creerInstitution(institution);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// --- Endpoints pour Role ---
	@PostMapping("/roles")
	public ResponseEntity<Role> creerRole(@RequestBody RoleDTO dto) {
		Role role = new Role();
		role.setNom(dto.getNom());

		Role saved = utilisateurService.creerRole(role);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// --- Endpoints pour Administrateur ---
	@PostMapping("/administrateurs")
	public ResponseEntity<Administrateur> creerAdministrateur(@RequestBody UtilisateurDTO dto) {
		Administrateur admin = new Administrateur();
		admin.setNom(dto.getNom());
		admin.setPrenom(dto.getPrenom());
		admin.setEmail(dto.getEmail());
		admin.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
		admin.setTelephone(dto.getTelephone());
		admin.setStatutCompte("VALIDE");

		if (dto.getInstitutionId() != null) {
			Institution institution = new Institution();
			institution.setId(dto.getInstitutionId());
			admin.setInstitution(institution);
		}

		Administrateur saved = utilisateurService.creerAdministrateur(admin);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// --- Endpoints pour AgentInstitution ---
	@PostMapping("/agents")
	public ResponseEntity<AgentInstitution> creerAgent(@RequestBody UtilisateurDTO dto) {
		AgentInstitution agent = new AgentInstitution();
		agent.setNom(dto.getNom());
		agent.setPrenom(dto.getPrenom());
		agent.setEmail(dto.getEmail());
		agent.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
		agent.setTelephone(dto.getTelephone());
		agent.setStatutCompte("EN_ATTENTE");

		if (dto.getInstitutionId() != null) {
			Institution institution = new Institution();
			institution.setId(dto.getInstitutionId());
			agent.setInstitution(institution);
		}

		AgentInstitution saved = utilisateurService.creerAgentInstitution(agent);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// --- Endpoints pour Particulier ---
	@PostMapping("/particuliers")
	public ResponseEntity<Particulier> creerParticulier(@RequestBody UtilisateurDTO dto) {
		Particulier particulier = new Particulier();
		particulier.setNom(dto.getNom());
		particulier.setPrenom(dto.getPrenom());
		particulier.setEmail(dto.getEmail());
		particulier.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
		particulier.setTelephone(dto.getTelephone());
		particulier.setStatutCompte("EN_ATTENTE");

		Particulier saved = utilisateurService.creerParticulier(particulier);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}
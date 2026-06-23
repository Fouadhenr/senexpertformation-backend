package sn.senexpertformation.utilisateurs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import sn.senexpertformation.utilisateurs.entity.Utilisateur;
import sn.senexpertformation.utilisateurs.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	// Plus de PasswordEncoder ici — c'est le service qui encode
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	// ===================== INSTITUTION =====================

	@PostMapping("/institutions")
	public ResponseEntity<Institution> creerInstitution(@RequestBody InstitutionDTO dto) {
		Institution institution = new Institution();
		institution.setRaisonSociale(dto.getRaisonSociale());
		institution.setTypeInstitution(dto.getTypeInstitution());
		institution.setAdresse(dto.getAdresse());
		institution.setSecteurActivite(dto.getSecteurActivite());
		// statut EN_ATTENTE est mis par le service — pas besoin de le mettre ici

		Institution saved = utilisateurService.creerInstitution(institution);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@PutMapping("/institutions/{id}/valider")
	public ResponseEntity<Institution> validerInstitution(@PathVariable Long id) {
		Institution institution = utilisateurService.validerInstitution(id);
		return ResponseEntity.ok(institution);
	}

	@PutMapping("/institutions/{id}/rejeter")
	public ResponseEntity<Institution> rejeterInstitution(@PathVariable Long id) {
		Institution institution = utilisateurService.rejeterInstitution(id);
		return ResponseEntity.ok(institution);
	}

	// ===================== ROLE =====================

	@PostMapping("/roles")
	public ResponseEntity<Role> creerRole(@RequestBody RoleDTO dto) {
		Role role = new Role();
		role.setNom(dto.getNom());
		Role saved = utilisateurService.creerRole(role);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// ===================== ADMINISTRATEUR =====================

	@PostMapping("/administrateurs")
	public ResponseEntity<String> creerAdministrateur(@RequestBody UtilisateurDTO dto) {
		Administrateur admin = new Administrateur();
		admin.setNom(dto.getNom());
		admin.setPrenom(dto.getPrenom());
		admin.setEmail(dto.getEmail());
		admin.setMotDePasse(dto.getMotDePasse()); // brut — le service encode
		admin.setTelephone(dto.getTelephone());
		// statutCompte VALIDE mis par le service

		utilisateurService.creerAdministrateur(admin);
		// On retourne un message simple, pas l'entité avec le mot de passe
		return new ResponseEntity<>("Administrateur créé avec succès", HttpStatus.CREATED);
	}

	// ===================== AGENT INSTITUTION =====================

	@PostMapping("/agents")
	public ResponseEntity<String> creerAgent(@RequestBody UtilisateurDTO dto) {
		AgentInstitution agent = new AgentInstitution();
		agent.setNom(dto.getNom());
		agent.setPrenom(dto.getPrenom());
		agent.setEmail(dto.getEmail());
		agent.setMotDePasse(dto.getMotDePasse()); // brut — le service encode
		agent.setTelephone(dto.getTelephone());
		// statutCompte EN_ATTENTE mis par le service

		// Lier à l'institution si fournie
		if (dto.getInstitutionId() != null) {
			Institution institution = new Institution();
			institution.setId(dto.getInstitutionId());
			agent.setInstitution(institution);
		}

		utilisateurService.creerAgentInstitution(agent);
		return new ResponseEntity<>("Agent créé avec succès, en attente de validation", HttpStatus.CREATED);
	}

	// ===================== PARTICULIER =====================

	@PostMapping("/particuliers")
	public ResponseEntity<String> creerParticulier(@RequestBody UtilisateurDTO dto) {
		Particulier particulier = new Particulier();
		particulier.setNom(dto.getNom());
		particulier.setPrenom(dto.getPrenom());
		particulier.setEmail(dto.getEmail());
		particulier.setMotDePasse(dto.getMotDePasse()); // brut — le service encode
		particulier.setTelephone(dto.getTelephone());
		// statutCompte EN_ATTENTE mis par le service

		utilisateurService.creerParticulier(particulier);
		return new ResponseEntity<>("Particulier créé avec succès, en attente de validation", HttpStatus.CREATED);
	}

	// ===================== VALIDATION DES COMPTES =====================

	@PutMapping("/{id}/valider")
	public ResponseEntity<String> validerCompte(@PathVariable Long id) {
		utilisateurService.validerCompte(id);
		return ResponseEntity.ok("Compte validé avec succès");
	}

	@PutMapping("/{id}/rejeter")
	public ResponseEntity<String> rejeterCompte(@PathVariable Long id) {
		utilisateurService.rejeterCompte(id);
		return ResponseEntity.ok("Compte rejeté");
	}

	// ===================== CONSULTATION =====================

	@GetMapping
	public ResponseEntity<List<Utilisateur>> getTousLesUtilisateurs() {
		return ResponseEntity.ok(utilisateurService.getTousLesUtilisateurs());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long id) {
		return ResponseEntity.ok(utilisateurService.getUtilisateurById(id));
	}
}
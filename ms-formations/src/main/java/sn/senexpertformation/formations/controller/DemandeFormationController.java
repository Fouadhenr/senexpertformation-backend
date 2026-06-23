package sn.senexpertformation.formations.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.formations.dto.DemandeFormationDTO;
import sn.senexpertformation.formations.entity.DemandeFormation;
import sn.senexpertformation.formations.service.FormationService;

@RestController
@RequestMapping("/api/demandes")
public class DemandeFormationController {

	private final FormationService formationService;

	public DemandeFormationController(FormationService formationService) {
		this.formationService = formationService;
	}

	@PostMapping
	public ResponseEntity<DemandeFormation> creerDemande(@RequestBody DemandeFormationDTO dto) {
		return new ResponseEntity<>(formationService.creerDemande(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/valider")
	public ResponseEntity<DemandeFormation> validerDemande(@PathVariable Long id,
			@RequestParam Long agentValidationId) {
		return ResponseEntity.ok(formationService.validerDemande(id, agentValidationId));
	}

	@PutMapping("/{id}/rejeter")
	public ResponseEntity<DemandeFormation> rejeterDemande(@PathVariable Long id,
			@RequestParam Long agentValidationId) {
		return ResponseEntity.ok(formationService.rejeterDemande(id, agentValidationId));
	}

	@GetMapping("/en-attente")
	public ResponseEntity<List<DemandeFormation>> getDemandesEnAttente() {
		return ResponseEntity.ok(formationService.getDemandesEnAttente());
	}

	@GetMapping("/utilisateur/{utilisateurId}")
	public ResponseEntity<List<DemandeFormation>> getDemandesParUtilisateur(@PathVariable Long utilisateurId) {
		return ResponseEntity.ok(formationService.getDemandesParUtilisateur(utilisateurId));
	}
}
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
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.formations.dto.OffreFormationDTO;
import sn.senexpertformation.formations.entity.Domaine;
import sn.senexpertformation.formations.entity.OffreFormation;
import sn.senexpertformation.formations.service.FormationService;

@RestController
@RequestMapping("/api/offres")
public class OffreFormationController {

	private final FormationService formationService;

	public OffreFormationController(FormationService formationService) {
		this.formationService = formationService;
	}

	@PostMapping
	public ResponseEntity<OffreFormation> creerOffre(@RequestBody OffreFormationDTO dto) {
		OffreFormation offre = new OffreFormation();
		offre.setTitre(dto.getTitre());
		offre.setDescription(dto.getDescription());
		offre.setDateDebut(dto.getDateDebut());
		offre.setDateFin(dto.getDateFin());
		offre.setModalite(dto.getModalite());
		offre.setNbPlaces(dto.getNbPlaces());

		// Lier au domaine
		if (dto.getDomaineId() != null) {
			Domaine domaine = new Domaine();
			domaine.setId(dto.getDomaineId());
			offre.setDomaine(domaine);
		}

		return new ResponseEntity<>(formationService.creerOffre(offre), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<OffreFormation>> getToutesLesOffres() {
		return ResponseEntity.ok(formationService.getToutesLesOffres());
	}

	@GetMapping("/ouvertes")
	public ResponseEntity<List<OffreFormation>> getOffresOuvertes() {
		return ResponseEntity.ok(formationService.getOffresOuvertes());
	}

	@PutMapping("/{id}/fermer")
	public ResponseEntity<OffreFormation> fermerOffre(@PathVariable Long id) {
		return ResponseEntity.ok(formationService.fermerOffre(id));
	}
}
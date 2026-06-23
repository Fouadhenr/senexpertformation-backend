package sn.senexpertformation.formations.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.formations.dto.DomaineDTO;
import sn.senexpertformation.formations.entity.Domaine;
import sn.senexpertformation.formations.service.FormationService;

@RestController
@RequestMapping("/api/domaines")
public class DomaineController {

	private final FormationService formationService;

	public DomaineController(FormationService formationService) {
		this.formationService = formationService;
	}

	@PostMapping
	public ResponseEntity<Domaine> creerDomaine(@RequestBody DomaineDTO dto) {
		Domaine domaine = new Domaine();
		domaine.setLibelle(dto.getLibelle());
		domaine.setDescription(dto.getDescription());
		return new ResponseEntity<>(formationService.creerDomaine(domaine), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Domaine>> getTousLesDomaines() {
		return ResponseEntity.ok(formationService.getTousLesDomaines());
	}
}
package sn.senexpertformation.formations.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sn.senexpertformation.formations.dto.InstitutionDTO;
import sn.senexpertformation.formations.dto.UtilisateurDTO;

@FeignClient(name = "ms-utilisateurs", url = "http://localhost:8081")
public interface UtilisateurClient {

	@GetMapping("/api/utilisateurs/administrateurs/{id}")
	UtilisateurDTO getAdministrateur(@PathVariable("id") Long id);

	@GetMapping("/api/utilisateurs/agents/{id}")
	UtilisateurDTO getAgent(@PathVariable("id") Long id);

	@GetMapping("/api/utilisateurs/particuliers/{id}")
	UtilisateurDTO getParticulier(@PathVariable("id") Long id);

	@GetMapping("/api/utilisateurs/institutions/{id}")
	InstitutionDTO getInstitution(@PathVariable("id") Long id);
}
package sn.senexpertformation.utilisateurs.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sn.senexpertformation.utilisateurs.entity.Administrateur;
import sn.senexpertformation.utilisateurs.entity.AgentInstitution;
import sn.senexpertformation.utilisateurs.entity.Institution;
import sn.senexpertformation.utilisateurs.entity.Particulier;
import sn.senexpertformation.utilisateurs.entity.Role;
import sn.senexpertformation.utilisateurs.entity.Utilisateur;
import sn.senexpertformation.utilisateurs.repository.AdministrateurRepository;
import sn.senexpertformation.utilisateurs.repository.AgentInstitutionRepository;
import sn.senexpertformation.utilisateurs.repository.InstitutionRepository;
import sn.senexpertformation.utilisateurs.repository.ParticulierRepository;
import sn.senexpertformation.utilisateurs.repository.RoleRepository;
import sn.senexpertformation.utilisateurs.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final AdministrateurRepository administrateurRepository;
	private final AgentInstitutionRepository agentInstitutionRepository;
	private final ParticulierRepository particulierRepository;
	private final InstitutionRepository institutionRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	// Méthode utilitaire privée — trouve un rôle par son nom
	private Role getRoleByNom(String nomRole) {
		return roleRepository.findByNom(nomRole).orElseThrow(() -> new RuntimeException(
				"Rôle '" + nomRole + "' non trouvé. Créez-le d'abord via POST /api/utilisateurs/roles"));
	}

	public UtilisateurService(UtilisateurRepository utilisateurRepository,
			AdministrateurRepository administrateurRepository, AgentInstitutionRepository agentInstitutionRepository,
			ParticulierRepository particulierRepository, InstitutionRepository institutionRepository,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.utilisateurRepository = utilisateurRepository;
		this.administrateurRepository = administrateurRepository;
		this.agentInstitutionRepository = agentInstitutionRepository;
		this.particulierRepository = particulierRepository;
		this.institutionRepository = institutionRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// ===================== PARTICULIER =====================

	public Particulier creerParticulier(Particulier particulier) {
		if (utilisateurRepository.findByEmail(particulier.getEmail()).isPresent()) {
			throw new RuntimeException("Un utilisateur avec cet email existe déjà");
		}
		particulier.setMotDePasse(passwordEncoder.encode(particulier.getMotDePasse()));
		particulier.setStatutCompte("EN_ATTENTE");

		// Attribuer automatiquement le rôle PARTICULIER
		Role role = getRoleByNom("PARTICULIER");
		particulier.setRoles(List.of(role));

		return particulierRepository.save(particulier);
	}

	// ===================== AGENT INSTITUTION =====================

	public AgentInstitution creerAgentInstitution(AgentInstitution agent) {
		if (utilisateurRepository.findByEmail(agent.getEmail()).isPresent()) {
			throw new RuntimeException("Un utilisateur avec cet email existe déjà");
		}
		agent.setMotDePasse(passwordEncoder.encode(agent.getMotDePasse()));
		agent.setStatutCompte("EN_ATTENTE");

		// Attribuer automatiquement le rôle AGENT
		Role role = getRoleByNom("AGENT");
		agent.setRoles(List.of(role));

		return agentInstitutionRepository.save(agent);
	}
	// ===================== ADMINISTRATEUR =====================

	public Administrateur creerAdministrateur(Administrateur administrateur) {
		if (utilisateurRepository.findByEmail(administrateur.getEmail()).isPresent()) {
			throw new RuntimeException("Un utilisateur avec cet email existe déjà");
		}
		administrateur.setMotDePasse(passwordEncoder.encode(administrateur.getMotDePasse()));
		administrateur.setStatutCompte("VALIDE");

		// Attribuer automatiquement le rôle ADMINISTRATEUR
		Role role = getRoleByNom("ADMINISTRATEUR");
		administrateur.setRoles(List.of(role));

		return administrateurRepository.save(administrateur);
	}

	// ===================== VALIDATION DES COMPTES =====================

	public Utilisateur validerCompte(Long utilisateurId) {
		// Chercher l'utilisateur peu importe son type
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
		utilisateur.setStatutCompte("VALIDE");
		return utilisateurRepository.save(utilisateur);
	}

	public Utilisateur rejeterCompte(Long utilisateurId) {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
		utilisateur.setStatutCompte("REJETE");
		return utilisateurRepository.save(utilisateur);
	}

	// ===================== INSTITUTION =====================

	public Institution creerInstitution(Institution institution) {
		institution.setStatutValidation("EN_ATTENTE");
		return institutionRepository.save(institution);
	}

	public Institution validerInstitution(Long institutionId) {
		Institution institution = institutionRepository.findById(institutionId)
				.orElseThrow(() -> new RuntimeException("Institution non trouvée"));
		institution.setStatutValidation("VALIDE");
		return institutionRepository.save(institution);
	}

	public Institution rejeterInstitution(Long institutionId) {
		Institution institution = institutionRepository.findById(institutionId)
				.orElseThrow(() -> new RuntimeException("Institution non trouvée"));
		institution.setStatutValidation("REJETE");
		return institutionRepository.save(institution);
	}

	// ===================== CONSULTATION =====================

	public List<Utilisateur> getTousLesUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	public Utilisateur getUtilisateurById(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
	}

	// ===================== ROLE =====================

	public Role creerRole(Role role) {
		return roleRepository.save(role);
	}
}
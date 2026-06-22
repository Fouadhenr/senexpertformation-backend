package sn.senexpertformation.utilisateurs.service;

import org.springframework.stereotype.Service;

import sn.senexpertformation.utilisateurs.entity.Administrateur;
import sn.senexpertformation.utilisateurs.entity.AgentInstitution;
import sn.senexpertformation.utilisateurs.entity.Institution;
import sn.senexpertformation.utilisateurs.entity.Particulier;
import sn.senexpertformation.utilisateurs.entity.Role;
import sn.senexpertformation.utilisateurs.repository.AdministrateurRepository;
import sn.senexpertformation.utilisateurs.repository.AgentInstitutionRepository;
import sn.senexpertformation.utilisateurs.repository.InstitutionRepository;
import sn.senexpertformation.utilisateurs.repository.ParticulierRepository;
import sn.senexpertformation.utilisateurs.repository.RoleRepository;

@Service
public class UtilisateurService {

	private final AdministrateurRepository administrateurRepository;
	private final AgentInstitutionRepository agentInstitutionRepository;
	private final ParticulierRepository particulierRepository;
	private final InstitutionRepository institutionRepository;
	private final RoleRepository roleRepository;

	public UtilisateurService(AdministrateurRepository administrateurRepository,
			AgentInstitutionRepository agentInstitutionRepository, ParticulierRepository particulierRepository,
			InstitutionRepository institutionRepository, RoleRepository roleRepository) {
		this.administrateurRepository = administrateurRepository;
		this.agentInstitutionRepository = agentInstitutionRepository;
		this.particulierRepository = particulierRepository;
		this.institutionRepository = institutionRepository;
		this.roleRepository = roleRepository;
	}

	// --- Administrateur ---
	public Administrateur creerAdministrateur(Administrateur administrateur) {
		return administrateurRepository.save(administrateur);
	}

	// --- AgentInstitution ---
	public AgentInstitution creerAgentInstitution(AgentInstitution agent) {
		return agentInstitutionRepository.save(agent);
	}

	// --- Particulier ---
	public Particulier creerParticulier(Particulier particulier) {
		return particulierRepository.save(particulier);
	}

	// --- Institution ---
	public Institution creerInstitution(Institution institution) {
		return institutionRepository.save(institution);
	}

	// --- Role ---
	public Role creerRole(Role role) {
		return roleRepository.save(role);
	}
}

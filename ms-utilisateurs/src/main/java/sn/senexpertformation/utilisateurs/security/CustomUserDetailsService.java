package sn.senexpertformation.utilisateurs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sn.senexpertformation.utilisateurs.entity.Administrateur;
import sn.senexpertformation.utilisateurs.entity.AgentInstitution;
import sn.senexpertformation.utilisateurs.entity.Particulier;
import sn.senexpertformation.utilisateurs.repository.AdministrateurRepository;
import sn.senexpertformation.utilisateurs.repository.AgentInstitutionRepository;
import sn.senexpertformation.utilisateurs.repository.ParticulierRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final AdministrateurRepository administrateurRepository;
	private final AgentInstitutionRepository agentInstitutionRepository;
	private final ParticulierRepository particulierRepository;

	public CustomUserDetailsService(AdministrateurRepository administrateurRepository,
			AgentInstitutionRepository agentInstitutionRepository, ParticulierRepository particulierRepository) {
		this.administrateurRepository = administrateurRepository;
		this.agentInstitutionRepository = agentInstitutionRepository;
		this.particulierRepository = particulierRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Chercher dans Administrateur
		Administrateur admin = administrateurRepository.findByEmail(email).orElse(null);
		if (admin != null) {
			return admin;
		}

		// Chercher dans AgentInstitution
		AgentInstitution agent = agentInstitutionRepository.findByEmail(email).orElse(null);
		if (agent != null) {
			return agent;
		}

		// Chercher dans Particulier
		Particulier particulier = particulierRepository.findByEmail(email).orElse(null);
		if (particulier != null) {
			return particulier;
		}

		throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email: " + email);
	}
}
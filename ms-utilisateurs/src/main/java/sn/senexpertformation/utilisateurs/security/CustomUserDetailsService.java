package sn.senexpertformation.utilisateurs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sn.senexpertformation.utilisateurs.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UtilisateurRepository utilisateurRepository;

	public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return utilisateurRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));
	}
}
package sn.senexpertformation.utilisateurs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.utilisateurs.security.JwtRequest;
import sn.senexpertformation.utilisateurs.security.JwtResponse;
import sn.senexpertformation.utilisateurs.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	// Plus besoin de CustomUserDetailsService ici
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getMotDePasse()));
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String token = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));

		} catch (DisabledException e) {
			// Compte EN_ATTENTE ou REJETE
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("Compte non activé. Attendez la validation par un administrateur.");

		} catch (BadCredentialsException e) {
			// Email ou mot de passe incorrect
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
		}
	}
}
package sn.senexpertformation.utilisateurs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.senexpertformation.utilisateurs.security.CustomUserDetailsService;
import sn.senexpertformation.utilisateurs.security.JwtRequest;
import sn.senexpertformation.utilisateurs.security.JwtResponse;
import sn.senexpertformation.utilisateurs.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final CustomUserDetailsService customUserDetailsService;

	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
			CustomUserDetailsService customUserDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.customUserDetailsService = customUserDetailsService;
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
		// Authentifier l'utilisateur
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getMotDePasse()));

		// Charger les détails de l'utilisateur
		final UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getEmail());

		// Générer le token JWT
		final String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
}
package sn.senexpertformation.utilisateurs.security;

public class JwtResponse {
	private String token;

	// Constructeur par défaut (nécessaire pour Spring)
	public JwtResponse() {
	}

	// Constructeur avec paramètre
	public JwtResponse(String token) {
		this.token = token;
	}

	// Getter
	public String getToken() {
		return token;
	}

	// Setter
	public void setToken(String token) {
		this.token = token;
	}
}
package sn.senexpertformation.utilisateurs.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Utilisateur implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String telephone;
	private String statutCompte;

	@ManyToOne
	@JoinColumn(name = "institution_id")
	private Institution institution;

	@ManyToMany
	@JoinTable(name = "utilisateurs_roles", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	// Getters
	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getStatutCompte() {
		return statutCompte;
	}

	public Institution getInstitution() {
		return institution;
	}

	public List<Role> getRoles() {
		return roles;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setStatutCompte(String statutCompte) {
		this.statutCompte = statutCompte;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// --- Implémentation de UserDetails ---

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getNom()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return motDePasse;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "VALIDE".equals(statutCompte);
	}
}
package sn.senexpertformation.utilisateurs.dto;

import java.util.List;

public class UtilisateurDTO {
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String telephone;
	private String statutCompte;
	private Long institutionId;
	private List<Long> roleIds;

	// Getters
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

	public Long getInstitutionId() {
		return institutionId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	// Setters
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

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
}
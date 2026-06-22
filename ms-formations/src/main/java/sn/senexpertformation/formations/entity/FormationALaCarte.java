package sn.senexpertformation.formations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formations_a_la_carte")
public class FormationALaCarte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String besoinSpecifique;
	private String domaineSouhaite;
	private Long demandeId;

	// Getters
	public Long getId() {
		return id;
	}

	public String getBesoinSpecifique() {
		return besoinSpecifique;
	}

	public String getDomaineSouhaite() {
		return domaineSouhaite;
	}

	public Long getDemandeId() {
		return demandeId;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setBesoinSpecifique(String besoinSpecifique) {
		this.besoinSpecifique = besoinSpecifique;
	}

	public void setDomaineSouhaite(String domaineSouhaite) {
		this.domaineSouhaite = domaineSouhaite;
	}

	public void setDemandeId(Long demandeId) {
		this.demandeId = demandeId;
	}
}
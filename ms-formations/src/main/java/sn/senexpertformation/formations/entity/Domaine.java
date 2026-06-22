package sn.senexpertformation.formations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "domaines")
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String libelle;
	private String description;

	// Getters
	public Long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
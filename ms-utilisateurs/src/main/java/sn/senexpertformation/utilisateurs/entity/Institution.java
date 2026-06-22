package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "institutions")
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String raisonSociale;
	private String typeInstitution;
	private String adresse;
	private String secteurActivite;
	private String statutValidation;

	// Getters
	public Long getId() {
		return id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public String getTypeInstitution() {
		return typeInstitution;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public String getStatutValidation() {
		return statutValidation;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public void setTypeInstitution(String typeInstitution) {
		this.typeInstitution = typeInstitution;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public void setStatutValidation(String statutValidation) {
		this.statutValidation = statutValidation;
	}
}
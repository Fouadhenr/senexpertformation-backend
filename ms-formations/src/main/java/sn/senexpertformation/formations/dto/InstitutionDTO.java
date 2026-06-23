package sn.senexpertformation.formations.dto;

public class InstitutionDTO {
	private Long id;
	private String raisonSociale;
	private String typeInstitution;
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

	public void setStatutValidation(String statutValidation) {
		this.statutValidation = statutValidation;
	}
}
package sn.senexpertformation.utilisateurs.dto;

public class InstitutionDTO {
	private String raisonSociale;
	private String typeInstitution;
	private String adresse;
	private String secteurActivite;

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getTypeInstitution() {
		return typeInstitution;
	}

	public void setTypeInstitution(String typeInstitution) {
		this.typeInstitution = typeInstitution;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}
}
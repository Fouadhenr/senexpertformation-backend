package sn.senexpertformation.formations.dto;

public class DemandeFormationDTO {
	private String type; // OFFRE_STANDARD ou A_LA_CARTE
	private Long utilisateurId;
	private Long institutionId;
	private Long offreFormationId; // null si A_LA_CARTE

	// Champs pour formation à la carte
	private String besoinSpecifique;
	private Long domaineSouhaiteId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public Long getOffreFormationId() {
		return offreFormationId;
	}

	public void setOffreFormationId(Long offreFormationId) {
		this.offreFormationId = offreFormationId;
	}

	public String getBesoinSpecifique() {
		return besoinSpecifique;
	}

	public void setBesoinSpecifique(String besoinSpecifique) {
		this.besoinSpecifique = besoinSpecifique;
	}

	public Long getDomaineSouhaiteId() {
		return domaineSouhaiteId;
	}

	public void setDomaineSouhaiteId(Long domaineSouhaiteId) {
		this.domaineSouhaiteId = domaineSouhaiteId;
	}
}
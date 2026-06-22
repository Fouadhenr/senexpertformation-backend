package sn.senexpertformation.formations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "demandes_formation")
public class DemandeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dateDemande;
	private String type; // OFFRE_STANDARD, A_LA_CARTE
	private String statut; // EN_ATTENTE, VALIDEE, REJETEE

	// Références cross-microservices (IDs)
	private Long utilisateurId;
	private Long institutionId;
	private Long offreFormationId; // nullable si à la carte

	// Getters
	public Long getId() {
		return id;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public String getType() {
		return type;
	}

	public String getStatut() {
		return statut;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public Long getOffreFormationId() {
		return offreFormationId;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public void setOffreFormationId(Long offreFormationId) {
		this.offreFormationId = offreFormationId;
	}
}
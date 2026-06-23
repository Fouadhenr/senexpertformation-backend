package sn.senexpertformation.formations.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "demandes_formation")
public class DemandeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dateDemande;

	// OFFRE_STANDARD ou A_LA_CARTE
	private String type;

	// EN_ATTENTE, VALIDEE, REJETEE
	private String statut;

	// Références cross-microservice : on stocke les IDs, pas les objets
	private Long utilisateurId;
	private Long institutionId;
	private Long agentValidationId;

	@ManyToOne
	@JoinColumn(name = "offre_formation_id")
	private OffreFormation offreFormation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public Long getAgentValidationId() {
		return agentValidationId;
	}

	public void setAgentValidationId(Long agentValidationId) {
		this.agentValidationId = agentValidationId;
	}

	public OffreFormation getOffreFormation() {
		return offreFormation;
	}

	public void setOffreFormation(OffreFormation offreFormation) {
		this.offreFormation = offreFormation;
	}
}
package sn.senexpertformation.formations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "formations_a_la_carte")
public class FormationALaCarte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String besoinSpecifique;

	// ID du domaine souhaité — référence simple, pas de jointure
	private Long domaineSouhaiteId;

	@OneToOne
	@JoinColumn(name = "demande_formation_id")
	private DemandeFormation demandeFormation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public DemandeFormation getDemandeFormation() {
		return demandeFormation;
	}

	public void setDemandeFormation(DemandeFormation demandeFormation) {
		this.demandeFormation = demandeFormation;
	}
}
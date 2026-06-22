package sn.senexpertformation.formations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offres_formation")
public class OffreFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titre;
	private String description;
	private String dateDebut;
	private String dateFin;
	private String modalite; // PRESENTIEL, EN_LIGNE, HYBRIDE
	private Integer nbPlaces;
	private String statut; // OUVERTE, CLOTUREE, ANNULEE

	@ManyToOne
	@JoinColumn(name = "domaine_id")
	private Domaine domaine;

	// Getters
	public Long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public String getModalite() {
		return modalite;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public String getStatut() {
		return statut;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public void setModalite(String modalite) {
		this.modalite = modalite;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
}
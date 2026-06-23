package sn.senexpertformation.formations.dto;

import java.time.LocalDate;

public class OffreFormationDTO {
	private String titre;
	private String description;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String modalite;
	private int nbPlaces;
	private Long domaineId;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getModalite() {
		return modalite;
	}

	public void setModalite(String modalite) {
		this.modalite = modalite;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Long getDomaineId() {
		return domaineId;
	}

	public void setDomaineId(Long domaineId) {
		this.domaineId = domaineId;
	}
}
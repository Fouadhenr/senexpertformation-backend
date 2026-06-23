package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("AgentInstitution")
public class AgentInstitution extends Utilisateur {

	@ManyToOne
	@JoinColumn(name = "institution_id")
	private Institution institution;

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}
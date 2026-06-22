package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "agents_institution")
public class AgentInstitution extends Utilisateur {
	// Pas d'attributs supplémentaires
}
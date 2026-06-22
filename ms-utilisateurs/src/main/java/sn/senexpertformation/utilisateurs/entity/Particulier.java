package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "particuliers")
public class Particulier extends Utilisateur {

	// Pas d'attributs supplémentaires
}
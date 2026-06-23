package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Particulier")
public class Particulier extends Utilisateur {
	// Pas d'attributs supplémentaires
}
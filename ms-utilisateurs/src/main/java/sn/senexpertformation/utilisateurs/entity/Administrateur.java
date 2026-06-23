package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Utilisateur {
	// Représente l'administrateur de la plateforme
}
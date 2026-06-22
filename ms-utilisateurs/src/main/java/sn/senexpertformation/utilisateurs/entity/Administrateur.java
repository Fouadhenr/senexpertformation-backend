package sn.senexpertformation.utilisateurs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrateurs")
public class Administrateur extends Utilisateur {

	// répresente l'administrateur du plateforme
}
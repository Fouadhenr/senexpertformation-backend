package sn.senexpertformation.formations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.formations.entity.DemandeFormation;

@Repository
public interface DemandeFormationRepository extends JpaRepository<DemandeFormation, Long> {
	// Toutes les demandes d'un utilisateur
	List<DemandeFormation> findByUtilisateurId(Long utilisateurId);

	// Toutes les demandes d'une institution
	List<DemandeFormation> findByInstitutionId(Long institutionId);

	// Toutes les demandes par statut
	List<DemandeFormation> findByStatut(String statut);
}
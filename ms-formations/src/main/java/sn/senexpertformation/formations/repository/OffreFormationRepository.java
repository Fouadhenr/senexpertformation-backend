package sn.senexpertformation.formations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.formations.entity.OffreFormation;

@Repository
public interface OffreFormationRepository extends JpaRepository<OffreFormation, Long> {
	// Trouver toutes les offres d'un domaine donné
	List<OffreFormation> findByDomaineId(Long domaineId);

	// Trouver toutes les offres ouvertes
	List<OffreFormation> findByStatut(String statut);
}
package sn.senexpertformation.utilisateurs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
	Optional<Institution> findByRaisonSociale(String raisonSociale);
}

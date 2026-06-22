package sn.senexpertformation.utilisateurs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.AgentInstitution;

@Repository
public interface AgentInstitutionRepository extends JpaRepository<AgentInstitution, Long> {
	Optional<AgentInstitution> findByEmail(String email);
}

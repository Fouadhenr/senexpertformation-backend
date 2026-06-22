package sn.senexpertformation.utilisateurs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.Particulier;

@Repository
public interface ParticulierRepository extends JpaRepository<Particulier, Long> {
	Optional<Particulier> findByEmail(String email);
}

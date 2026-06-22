package sn.senexpertformation.utilisateurs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	Optional<Administrateur> findByEmail(String email);
}

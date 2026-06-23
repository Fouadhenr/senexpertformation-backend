package sn.senexpertformation.formations.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.formations.entity.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
	Optional<Domaine> findByLibelle(String libelle);
}
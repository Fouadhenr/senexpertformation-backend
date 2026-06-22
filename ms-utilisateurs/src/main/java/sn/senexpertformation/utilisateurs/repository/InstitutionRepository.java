package sn.senexpertformation.utilisateurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}

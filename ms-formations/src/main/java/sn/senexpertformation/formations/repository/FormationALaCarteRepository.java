package sn.senexpertformation.formations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.formations.entity.FormationALaCarte;

@Repository
public interface FormationALaCarteRepository extends JpaRepository<FormationALaCarte, Long> {
}
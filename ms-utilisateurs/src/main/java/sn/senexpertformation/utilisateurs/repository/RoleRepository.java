package sn.senexpertformation.utilisateurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senexpertformation.utilisateurs.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

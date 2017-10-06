/**
 * 
 */
package com.hostme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostme.entities.Role;

/**
 * @author rmidi
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}

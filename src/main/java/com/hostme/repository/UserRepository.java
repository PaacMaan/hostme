/**
 * 
 */
package com.hostme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hostme.entities.User;

/**
 * @author rmidi
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
	
	@Modifying
	@Query("UPDATE User SET isValidated = 1 WHERE token = :token")
	int validateUser(@Param("token") String token);
}
/**
 * 
 */
package com.hostme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hostme.entities.Ad;


/**
 * @author rmidi
 *
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
	@Query("SELECT a FROM Ad a WHERE a.publisher.username = :username AND a.isValidated = 1 ORDER BY a.date_pub DESC")
	List<Ad> findAdsByPublisherUsername(@Param("username") String username);
	
	List<Ad> findByPropertyVilleContainingIgnoreCase(String location);
}
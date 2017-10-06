/**
 * 
 */
package com.hostme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostme.entities.Property;

/**
 * @author rmidi
 *
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}

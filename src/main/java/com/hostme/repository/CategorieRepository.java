/**
 * 
 */
package com.hostme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostme.entities.Categorie;

/**
 * @author rmidi
 *
 */
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
}

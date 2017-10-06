/**
 * 
 */
package com.hostme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostme.entities.Photo;

/**
 * @author rmidi
 *
 */
@Repository
public interface PhotoRespository extends JpaRepository<Photo, Long> {

}

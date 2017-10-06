/**
 * 
 */
package com.hostme.service.interfac;

import java.util.List;

import com.hostme.entities.Categorie;

/**
 * @author rmidi
 *
 */
public interface CategorieService {
	public List<Categorie> findAllCategories();
}

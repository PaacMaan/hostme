/**
 * 
 */
package com.hostme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostme.entities.Categorie;
import com.hostme.repository.CategorieRepository;
import com.hostme.service.interfac.CategorieService;

/**
 * @author rmidi
 *
 */
@Service("categorieService")
@Transactional
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepository categorieRepo;
	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.CategorieService#findAllCategories()
	 */
	@Override
	public List<Categorie> findAllCategories() {
		return categorieRepo.findAll();
	}

}

/**
 * 
 */
package com.hostme.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rmidi
 *
 */
@Entity
@Table(name="categorie")
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_categ;
	@Column(nullable = false)
	private String libelle;
	/**
	 * 
	 */
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_categ
	 * @param libelle
	 */
	public Categorie(Long id_categ, String libelle) {
		super();
		this.id_categ = id_categ;
		this.libelle = libelle;
	}
	/**
	 * @return the id_categ
	 */
	public Long getId_categ() {
		return id_categ;
	}
	/**
	 * @param id_categ the id_categ to set
	 */
	public void setId_categ(Long id_categ) {
		this.id_categ = id_categ;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categorie [id_categ=" + id_categ + ", libelle=" + libelle + "]";
	}
	
}

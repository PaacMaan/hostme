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
@Table(name="property")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_property;
	@Column(nullable = false)
	private String adress;
	@Column(nullable = false)
	private String ville;
	@Column(nullable = false)
	private String surface;
	@Column(nullable = false)
	private Double price;
	/**
	 * 
	 */
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_property
	 * @param adress
	 * @param ville
	 * @param surface
	 * @param price
	 */
	public Property(Long id_property, String adress, String ville, String surface, Double price) {
		super();
		this.id_property = id_property;
		this.adress = adress;
		this.ville = ville;
		this.surface = surface;
		this.price = price;
	}
	/**
	 * @return the id_property
	 */
	public Long getId_property() {
		return id_property;
	}
	/**
	 * @param id_property the id_property to set
	 */
	public void setId_property(Long id_property) {
		this.id_property = id_property;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the surface
	 */
	public String getSurface() {
		return surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public void setSurface(String surface) {
		this.surface = surface;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Property [id_property=" + id_property + ", adress=" + adress + ", ville=" + ville + ", Surface="
				+ surface + ", price=" + price + "]";
	}
	
}

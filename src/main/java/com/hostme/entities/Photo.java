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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rmidi
 *
 */
@Entity
@Table(name="photo")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_photo;
	@Column(nullable = false)
	private String url;
	@ManyToOne
    @JoinColumn(name = "id_ad",nullable=false, insertable=true)
	private Ad ad;
	/**
	 * 
	 */
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_photo
	 * @param url
	 * @param id_ad
	 */
	public Photo(Long id_photo, String url, Ad ad) {
		super();
		this.id_photo = id_photo;
		this.url = url;
		this.ad = ad;
	}
	/**
	 * @return the id_photo
	 */
	public Long getId_photo() {
		return id_photo;
	}
	/**
	 * @param id_photo the id_photo to set
	 */
	public void setId_photo(Long id_photo) {
		this.id_photo = id_photo;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the id_ad
	 */
	public Ad getAd() {
		return ad;
	}
	/**
	 * @param id_ad the id_ad to set
	 */
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Photo [id_photo=" + id_photo + ", url=" + url + "]";
	}
	
}

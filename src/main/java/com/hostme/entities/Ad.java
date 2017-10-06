/**
 * 
 */
package com.hostme.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rmidi
 *
 */
@Entity
@Table(name="ad")
public class Ad implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_ad;
	@Column(nullable = false)
	private String titre;
	@Column(nullable = false,columnDefinition="text", length=500)
	private String description;
	@Column(nullable = false)
	private Long isValidated = 0L;
	@Column(nullable = false)
	private String reason;
	@Column(nullable = false)
	private Date date_pub;
	@ManyToOne
	@JoinColumn(name="id_user")
	private User publisher;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_property")
	private Property property;
	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(nullable=false, insertable=true)
	private List<Photo> photos;
	@ManyToOne
	@JoinColumn(name="id_categ")
	private Categorie categ;
	/**
	 * 
	 */
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_ad
	 * @param titre
	 * @param description
	 * @param isValidated
	 * @param reason
	 * @param date_pub
	 * @param publisher
	 * @param property
	 * @param photos
	 * @param categ
	 */
	public Ad(Long id_ad, String titre, String description, Long isValidated, String reason, Date date_pub,
			User publisher, Property property, List<Photo> photos, Categorie categ) {
		super();
		this.id_ad = id_ad;
		this.titre = titre;
		this.description = description;
		this.isValidated = isValidated;
		this.reason = reason;
		this.date_pub = date_pub;
		this.publisher = publisher;
		this.property = property;
		this.photos = photos;
		this.categ = categ;
	}
	/**
	 * @return the id_ad
	 */
	public Long getId_ad() {
		return id_ad;
	}
	/**
	 * @param id_ad the id_ad to set
	 */
	public void setId_ad(Long id_ad) {
		this.id_ad = id_ad;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isValidated
	 */
	public Long getIsValidated() {
		return isValidated;
	}
	/**
	 * @param isValidated the isValidated to set
	 */
	public void setIsValidated(Long isValidated) {
		this.isValidated = isValidated;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the date_pub
	 */
	public Date getDate_pub() {
		return date_pub;
	}
	/**
	 * @param date_pub the date_pub to set
	 */
	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}
	/**
	 * @return the publisher
	 */
	public User getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
	/**
	 * @return the photos
	 */
	public List<Photo> getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	/**
	 * @return the categ
	 */
	public Categorie getCateg() {
		return categ;
	}
	/**
	 * @param categ the categ to set
	 */
	public void setCateg(Categorie categ) {
		this.categ = categ;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ad [id_ad=" + id_ad + ", titre=" + titre + ", description=" + description + ", isValidated="
				+ isValidated + ", reason=" + reason + ", date_pub=" + date_pub + ", publisher=" + publisher
				+ ", property=" + property + ", photos=" + photos + ", categ=" + categ + "]";
	}
	
}

/**
 * 
 */
package com.hostme.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

/**
 * @author rmidi
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_user;
	@Column(nullable = false)
	private String fullName;
	@Column(nullable = false)
	private String username;
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String tel;
	@Column(nullable = false)
	private String ville;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private Long isValidated = 0L;
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	private List<Ad> ads;
	@OneToOne
    @JoinColumn(name = "id_role")
	private Role role;
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param username
	 * @param email
	 * @param password
	 * @param tel
	 * @param ville
	 * @param token
	 * @param isValidated
	 * @param ads
	 */
	public User(Long id_user, String fullName, String username, String email, String password, String tel, String ville, String token,
			Long isValidated) {
		super();
		this.id_user = id_user;
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.ville = ville;
		this.token = token;
		this.isValidated = isValidated;
	}
	
	/**
	 * @return the User object
	 */
	public User(User user) {
		this.id_user = user.getId_user();
		this.fullName = user.getFullName();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.tel = user.getTel();
		this.ville = user.getVille();
		this.token = user.getToken();
		this.isValidated = user.getIsValidated();
		this.role = user.getRole();
	}
	
	/**
	 * @return the id_user
	 */
	public Long getId_user() {
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * @return the ads
	 */
	public List<Ad> getAds() {
		return ads;
	}
	/**
	 * @param ads the ads to set
	 */
	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", fullName=" + fullName + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", tel=" + tel + ", ville=" + ville + ", token=" + token + ", isValidated="
				+ isValidated + ", role=" + role + "]";
	}
	
}

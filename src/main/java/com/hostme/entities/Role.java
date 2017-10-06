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
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_role;
	@Column(nullable = false)
	private String role;
	/**
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param users
	 * @param role
	 */
	public Role( String role) {
		super();
		this.role = role;
	}
	/**
	 * @return the role_id
	 */
	public Long getRole_id() {
		return id_role;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Long role_id) {
		this.id_role = role_id;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", role=" + role + "]";
	}
	
	
}

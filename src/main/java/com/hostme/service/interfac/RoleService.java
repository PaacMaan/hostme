/**
 * 
 */
package com.hostme.service.interfac;

import com.hostme.entities.Role;

/**
 * @author rmidi
 *
 */
public interface RoleService {
	void saveRole(Role role);
	void updateRole(Role role);
	void deleteRoleById(Long id);
}

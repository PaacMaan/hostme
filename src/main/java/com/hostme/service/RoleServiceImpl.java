/**
 * 
 */
package com.hostme.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostme.entities.Role;
import com.hostme.repository.RoleRepository;
import com.hostme.service.interfac.RoleService;

/**
 * @author rmidi
 *
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void updateRole(Role role) {
		saveRole(role);
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepository.delete(id);
	}
	
	
}

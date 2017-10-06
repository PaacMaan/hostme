/**
 * 
 */
package com.hostme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostme.entities.CustomUserDetails;
import com.hostme.entities.User;
import com.hostme.repository.UserRepository;

/**
 * @author rmidi
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null || user.getIsValidated() == 0) {
			throw new UsernameNotFoundException("No user present with email: "+email);
		}
		return new CustomUserDetails(user);
	}


}

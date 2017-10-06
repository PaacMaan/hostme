/**
 * 
 */
package com.hostme.service.interfac;


import com.hostme.entities.User;

/**
 * @author rmidi
 *
 */
public interface UserService {
	User findById(Long id);
    User findByEmail(String email);
    User getUserByUsername(String username);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    void sendEmail(String email, String token) throws Exception;
    int validateUser(String token);
}

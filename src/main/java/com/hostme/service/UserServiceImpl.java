/**
 * 
 */
package com.hostme.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostme.entities.User;
import com.hostme.repository.RoleRepository;
import com.hostme.repository.UserRepository;
import com.hostme.service.interfac.UserService;

/**
 * @author rmidi
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private JavaMailSender sender;
	
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(encodeUserPassword(user.getPassword()));
		user.setRole(roleRepository.findByRole("ROLE_USER"));
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		saveUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void sendEmail(String email, String token) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		// Enable the multipart flag!
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(email);
		String msg = ""
				+ "<html><body>"
				+ "<div style=\"line-height:16px;margin:0;font-size:16px;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;padding:0;width:100%\">"
				+ "<table id=\"m_-7307477542101228307backgroundTable\" style=\"border-collapse:collapse;margin:0;padding:0;width:100%;line-height:100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">"
				+ "<tbody><tr><td style=\"border-collapse:collapse\">"
				+ "<table style=\"border-collapse:collapse\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">"
				+ "<tbody><tr>"
				+ "<td id=\"m_-7307477542101228307main\" style=\"border-collapse:collapse;padding-top:0px;padding-bottom:10px\" width=\"600\" valign=\"top\">"
				+ "<h1 id=\"m_-7307477542101228307welcome-to-floyd-\" style=\"text-align:center;font-size:34px;line-height:54px;margin:0 0 25px 0;font-weight:200;color:black\">Welcome to HostMe!</h1>"
				+ "<p>Thank you for signing up. Please verify your email address by clicking the following link:</p>"
				+ "<p><a href='http://localhost:8080/hostme/activate/"+token+"'>Confirm my account</a></p>"
				+ "<p>Thanks, HostMe</p>"
				+ "</td>"
				+ "</tr></tbody>"
				+ "</table>"
				+ "</td></tr></tbody>"
				+ "</table>"
				+ "</div>"
				+ "</body></html>"
				+ "";
		helper.setText(msg, true);
		helper.setSubject("Email Verification");
		sender.send(message);
	}

	@Override
	public int validateUser(String token) {
		return userRepository.validateUser(token);
	}

	public String encodeUserPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}

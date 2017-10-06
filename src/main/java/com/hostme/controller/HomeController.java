/**
 * 
 */
package com.hostme.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostme.entities.User;
import com.hostme.service.interfac.UserService;
import com.hostme.validator.UserValidator;

/**
 * @author rmidi
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
    private UserValidator userValidator;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getRoot() {
		return "redirect:/myads";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is already logged in :) */
		    return "redirect:/home";
		}
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String saveUser(Model model,@Valid @ModelAttribute User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
            return "register";
        }
		/*set user token registration*/
		user.setToken(UUID.randomUUID().toString());
		//System.out.println(user);
		userService.saveUser(user);
		try {
			userService.sendEmail(user.getEmail(), user.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*TODO : inject a message in model telling him to activate his account*/
		return "redirect:/home";
	}
	
	@RequestMapping(value="/activate/{token}", method=RequestMethod.GET)
	public String getActivate(@PathVariable("token") String token) {
		/*update the isValidated field*/
		userService.validateUser(token);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/user/profile", method=RequestMethod.GET)
	public String showProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		User user = (User) userDetail;
		model.addAttribute("user", userService.findById(user.getId_user()));
		return "profile";
	}
	
	@RequestMapping(value="/user/edit_profile", method=RequestMethod.POST)
	public String editProfile(RedirectAttributes attribute, @ModelAttribute User user) {
		System.out.println("data to update are : \nusername : "+user.getUsername()+"\nphone : "+user.getTel()+"\ncity : "+user.getVille());
		/*get the authenticated user to fetch id*/
		User currentUser = userService.findById(user.getId_user());
		/*check if the user trying to updates his data is existing*/
		if (currentUser == null) {
			System.out.println("Unable to update. User with the given id not found.");
		}
		/*set new values to the current user*/
		currentUser.setUsername(user.getUsername());
		currentUser.setTel(user.getTel());
		currentUser.setVille(user.getVille());
		/*update the current user*/
		userService.updateUser(currentUser);
		attribute.addFlashAttribute("successMsg", "your profile was updated successfully");
		return "redirect:/user/profile";
	}
	
	
	
}

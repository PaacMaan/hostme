/**
 * 
 */
package com.hostme.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hostme.entities.User;

/**
 * @author rmidi
 *
 */
@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		/*
		 * validate the fullname
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "NotEmpty");
		if (user.getFullName().length() < 4 || user.getFullName().length() > 32) {
            errors.rejectValue("fullName", "user.fullName", "the fullname is too short");
        }
		
		/*
		 * validate the username
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "user.username", "the username is too short");
        }
		
		/*
		 * validate the email
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getEmail()).matches())) {
			errors.rejectValue("email", "user.email", "Invalid email! Please enter valid email.");
		}
        
        /*
		 * validate the password
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "user.password", "the password should be between 6 and 32 characters");
        }
	}

}

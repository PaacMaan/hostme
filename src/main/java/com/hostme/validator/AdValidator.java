/**
 * 
 */
package com.hostme.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hostme.entities.Ad;

/**
 * @author rmidi
 *
 */
@Component
public class AdValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Ad.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Ad ad = (Ad) obj;
		
		/*
		 * validate the adress
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "property.adress", "NotEmpty");
		if (ad.getProperty().getAdress().length() < 4 || ad.getProperty().getAdress().length() > 32) {
            errors.rejectValue("property.adress", "ad.property.adress", "the adress is too short");
        }
		
		/*
		 * validate the title
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "NotEmpty");
		if (ad.getTitre().length() < 4 || ad.getTitre().length() > 32) {
            errors.rejectValue("titre", "ad.titre", "the title is too short");
        }
		
		/*
		 * validate the description
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		if (ad.getDescription().length() < 4 || ad.getDescription().length() > 500) {
            errors.rejectValue("description", "ad.description", "the description should not overfit 500 characters");
        }
		
		/*
		 * validate the area
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "property.surface", "NotEmpty");
		Pattern pattern = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(ad.getProperty().getSurface()).matches())) {
			errors.rejectValue("property.surface", "ad.property.surface", "Invalid sutface! Please enter only numbers.");
		}
		
		/*
		 * validate the price
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "property.price", "NotEmpty");
		/*if (!(pattern.matcher(ad.getProperty().getPrice()).matches())) {
			errors.rejectValue("property.price", "ad.property.price", "Invalid price! Please enter only numbers.");
		}*/
		
		/*
		 * validate the reason
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason", "NotEmpty");
	}

}

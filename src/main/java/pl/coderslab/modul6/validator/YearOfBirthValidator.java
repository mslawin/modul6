package pl.coderslab.modul6.validator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearOfBirthValidator 
	implements ConstraintValidator<YearOfBirth, Integer> {

	@Override
	public void initialize(YearOfBirth constraintAnnotation) {
	}

	@Override
	public boolean isValid(Integer value, 
			ConstraintValidatorContext context) {
		return LocalDateTime.now().getYear() - 18 < value; 
	}

	
	
	
	
	
	
}

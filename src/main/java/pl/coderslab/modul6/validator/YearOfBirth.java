package pl.coderslab.modul6.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = YearOfBirthValidator.class) 
@Target({ElementType.METHOD, ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME)
public @interface YearOfBirth {

	String message() default "yearOfBirth.error.message";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

package org.presentation.presentation.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author petrof
 */

@Constraint(validatedBy = {ValidUrl.UrlValidator.class})
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface ValidUrl {
    String message() default "Invalid URL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidUrl[] value();
    }
    class UrlValidator implements ConstraintValidator<ValidUrl, String> {
        @Override
        public void initialize(ValidUrl validUrl) {  }
        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
	    try {
		URL url = new URL(s);
	    } catch (MalformedURLException ex) {
		return false;
	    }
	    return true;
        }

    }
}
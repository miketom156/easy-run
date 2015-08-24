package com.job5156.common.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileFormatValidator implements ConstraintValidator<MobileFormat, String> {

	 private Pattern pattern;
	    
	    @Override
	    public void initialize(MobileFormat mobile) {
	        this.pattern = Pattern.compile(mobile.value());
	    }
	    @Override
	    public boolean isValid(String mobile, ConstraintValidatorContext constraintContext) {
            if(mobile == null || mobile.length() == 0 ) {
                return true;
            }
            return this.pattern.matcher(mobile).matches();
        }
}

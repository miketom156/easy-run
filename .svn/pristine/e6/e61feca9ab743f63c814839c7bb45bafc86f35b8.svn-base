package com.job5156.common.validator;

import com.job5156.common.Constants;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileFormatValidator.class)
@Documented
public @interface MobileFormat {
    String message() default "mobile.format.error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default Constants.PATTERN_MOBILE;
}
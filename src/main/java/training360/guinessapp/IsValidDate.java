package training360.guinessapp;

import training360.guinessapp.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = DateValidator.class)
public @interface IsValidDate {

    String message() default "must be in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package training360.guinessapp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = StringValidator.class)
public @interface ValidString {

    String message() default "must not be blank";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

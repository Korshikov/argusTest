package ru.delfserver.argusTest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import ru.delfserver.argusTest.validator.ForbidJoinYourselfValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ForbidJoinYourselfValidator.class})
@Documented
public @interface ForbidJoinYourself {

  String message() default "point should not be connect yourself";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

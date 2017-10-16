package ru.delfserver.argusTest.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.delfserver.argusTest.annotation.ForbidJoinYourself;
import ru.delfserver.argusTest.entity.Point;

public class ForbidJoinYourselfValidator implements
    ConstraintValidator<ForbidJoinYourself, Point> {

  @Override
  public void initialize(ForbidJoinYourself constraintAnnotation) {
  }

  @Override
  public boolean isValid(Point point, ConstraintValidatorContext context) {
    return !(point.getLinkedPoint().equals(point));
  }
}

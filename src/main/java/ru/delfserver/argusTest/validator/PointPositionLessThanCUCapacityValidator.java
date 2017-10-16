package ru.delfserver.argusTest.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.delfserver.argusTest.annotation.PointPositionLessThanCUCapacity;
import ru.delfserver.argusTest.entity.Point;

public class PointPositionLessThanCUCapacityValidator implements
    ConstraintValidator<PointPositionLessThanCUCapacity, Point> {

  @Override
  public void initialize(PointPositionLessThanCUCapacity constraintAnnotation) {
  }

  @Override
  public boolean isValid(Point point, ConstraintValidatorContext context) {
    return (point.getPosition() >= 0) && (point.getPosition() < point.getParentConnectionUnit()
        .getCapacity());
  }
}


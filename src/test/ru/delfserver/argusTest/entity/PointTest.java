package ru.delfserver.argusTest.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

  private static Validator validator;

  private ConnectionUnit connectionUnit = new ConnectionUnit("test", 2L);

  @Before
  public void setUp() throws Exception {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void createPointTest() {
    Point point = new Point(connectionUnit, 2L);
    Set<ConstraintViolation<Point>> constraintViolations =
        validator.validate(point);
    assertNotEquals(0,constraintViolations.size());

  }

}
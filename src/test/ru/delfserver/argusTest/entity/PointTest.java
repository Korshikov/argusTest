package ru.delfserver.argusTest.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

  private static Validator validator;

  private ConnectionUnit connectionUnit = new ConnectionUnit("test", 2L);

  @Before
  public void setUp() throws Exception {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void pointValidationTest() {
    Point point = new Point(connectionUnit, 2L);
    point.setLinkedPoint(point);
    Set<ConstraintViolation<Point>> constraintViolations =
        validator.validate(point);
    assertEquals(2, constraintViolations.size());

  }

}
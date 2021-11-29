package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestForSubmission("h04")
public class H1_1 {

  public void isInterface(){
    assertTrue(WithNaturalCoordinates.class.isInterface(), "WithNaturalCoordinates ist kein Interface");
  }

  @Test
  public void getMethodsCorrect(){
    isInterface();
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "getX", new Class[]{}, Integer.TYPE, false);
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "getY", new Class[]{}, Integer.TYPE, false);
  }

  @Test
  public void setMethodsCorrect(){
    isInterface();
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "setX", new Class[]{Integer.TYPE}, Void.TYPE, false);
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "setY", new Class[]{Integer.TYPE}, Void.TYPE, false);
  }
}

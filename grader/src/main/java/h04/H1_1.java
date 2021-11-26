package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

@TestForSubmission("h04")
public class H1_1 {

  @Test
  public void getMethodsCorrect(){
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "getX", new Class[]{}, Integer.TYPE);
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "getY", new Class[]{}, Integer.TYPE);
  }

  @Test
  public void setMethodsCorrect(){
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "setX", new Class[]{Integer.TYPE}, Void.TYPE);
    TutorTests.checkMethodExist(WithNaturalCoordinates.class, "setY", new Class[]{Integer.TYPE}, Void.TYPE);
  }



}

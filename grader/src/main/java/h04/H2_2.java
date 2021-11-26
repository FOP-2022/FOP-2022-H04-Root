package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H2_2 {

  @Test
  public void enumCorrect(){

  }

  @Test
  public void imlementInterfaceCorrect(){
    assertNotEquals(Robot.class, FloorVector.class.getSuperclass());

    Class[] expectedInterfaces = new Class[]{WithNaturalCoordinates.class};
    Class[] actualInterfaces = FloorVector.class.getInterfaces();
    Arrays.sort(expectedInterfaces);
    Arrays.sort(actualInterfaces);
    assertTrue(Arrays.equals(expectedInterfaces, actualInterfaces), "FloorVector implementiert nicht das richtige Interface");
  }

  @Test
  public void valueAttributesCorrect(){
    fail("Tests not implemented");
  }

  @Test
  public void valueGetSetCorrect(){
    fail("Tests not implemented");
  }

  @Test
  public void axisAttributesCorrect(){
    fail("Tests not implemented");
  }

  @Test
  public void axisGetSetCorrect(){
    fail("Tests not implemented");
  }

  @Test
  public void constructorCorrect(){
    fail("Tests not implemented");
  }

  @Test
  public void getCorrect(){ //2P
    fail("Tests not implemented");
  }

  @Test
  public void setCorrect(){
    fail("Tests not implemented");
  }

}

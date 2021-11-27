package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H2_2 {

  public void enumSingle(String c){
    try {
      Axis.valueOf(c);
    }catch (IllegalArgumentException e){
      fail("Axis besitzt nicht " + c);
    }
  }

  @Test
  public void enumCorrect(){
    assertEquals(3, Axis.values().length);
    enumSingle("X");
    enumSingle("Y");
    enumSingle("Z");
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
    TutorTests.checkAttributeExist(FloorVector.class, "x", Double.TYPE, false);
    TutorTests.checkAttributeExist(FloorVector.class, "y", Double.TYPE, false);
    TutorTests.checkAttributeExist(FloorVector.class, "z", Double.TYPE, false);
  }


  public <C> void valueGetSetSingle(Class<C> c, String attributeName, String setName, String getName, C[] testVals){
    for (Object testVal :testVals) {
      FloorVector fvector = (FloorVector) TutorTests.newInstanceOf(FloorVector.class, new Class[]{Double.TYPE}, new Object[]{0.0});
      //setzen
      TutorTests.callMethod(FloorVector.class, setName, new Class[]{c}, fvector, new Object[]{testVal});
      //getter
      assertEquals(testVal, (C)TutorTests.callMethod(FloorVector.class, getName, new Class[]{}, fvector, new Object[]{}), getName + " aus " + c.getName() + " liefert nicht den gesetzten Wert");
      //und value
      assertEquals(testVal, (C)TutorTests.getAttributeValue(FloorVector.class, attributeName, fvector), attributeName + " aus " + c.getName() + " wird nicht auf den Wert gesetzt");
    }
  }

  @Test
  public void valueGetSetCorrect(){
    valueGetSetSingle(Double.TYPE, "x", "setRealX", "getRealX", new Double[]{1.0, 5.0,-1.9});
    valueGetSetSingle(Double.TYPE, "y", "setRealY", "getRealY", new Double[]{1.0, 5.0,-1.9});
    valueGetSetSingle(Double.TYPE, "z", "setRealZ", "getRealZ", new Double[]{1.0, 5.0,-1.9});
  }

  @Test
  public void axisAttributesCorrect(){
    TutorTests.checkAttributeExist(FloorVector.class, "firstAxis", Axis.class, false);
    TutorTests.checkAttributeExist(FloorVector.class, "secondAxis", Axis.class, false);
  }

  @Test
  public void axisGetSetCorrect(){
    valueGetSetSingle(Axis.class, "firstAxis", "setFirstAxis", "getFirstAxis", new Axis[]{Axis.X, Axis.Y, Axis.Z});
    valueGetSetSingle(Axis.class, "secondAxis", "setSecondAxis", "getSecondAxis", new Axis[]{Axis.X, Axis.Y, Axis.Z});
  }

  @Test
  public void constructorCorrect(){
    for(double x : new double[]{1.0, -7.0, 78.9}) {
      FloorVector fvector = (FloorVector) TutorTests.newInstanceOf(FloorVector.class, new Class[]{Double.TYPE}, new Object[]{x});
      assertEquals(x, (double)TutorTests.getAttributeValue(FloorVector.class, "x", fvector), "x im Konstruktor in FloorVector nicht auf übergebenen Parameterwert gesetzt");
      assertEquals(3.14, (double)TutorTests.getAttributeValue(FloorVector.class, "y", fvector), "y im Konstruktor in FloorVector nicht auf 3.14 gesetzt");
      assertEquals(2.71, (double)TutorTests.getAttributeValue(FloorVector.class, "z", fvector), "z im Konstruktor in FloorVector nicht auf 2.71 gesetzt");
    }
  }


  @Test
  public void getCorrect(){ //2P // danach abs -> sowohl betrag als auch nicht erlaubt
    FloorVector fvector = (FloorVector) TutorTests.newInstanceOf(FloorVector.class, new Class[]{Double.TYPE}, new Object[]{17.6});
    fvector.setRealY(4.8);
    fvector.setRealZ(187.9);

    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.X});
    assertEquals(17, TutorTests.callMethod(FloorVector.class, "getX", new Class[]{}, fvector, new Object[]{}), "getX funktioniert für Axis.X nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Y});
    assertEquals(4, TutorTests.callMethod(FloorVector.class, "getX", new Class[]{}, fvector, new Object[]{}), "getX funktioniert für Axis.Y nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Z});
    assertEquals(187, TutorTests.callMethod(FloorVector.class, "getX", new Class[]{}, fvector, new Object[]{}), "getX funktioniert für Axis.Z nicht erkennbar korrekt");

    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.X});
    assertEquals(17, TutorTests.callMethod(FloorVector.class, "getY", new Class[]{}, fvector, new Object[]{}), "getY funktioniert für Axis.X nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Y});
    assertEquals(4, TutorTests.callMethod(FloorVector.class, "getY", new Class[]{}, fvector, new Object[]{}), "getY funktioniert für Axis.Y nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Z});
    assertEquals(187, TutorTests.callMethod(FloorVector.class, "getY", new Class[]{}, fvector, new Object[]{}), "getY funktioniert für Axis.Z nicht erkennbar korrekt");
  }





  @Test
  public void setCorrect(){ //Nur Testen mit pos. Werten (Betrag akzeptieren und auch nicht)
    FloorVector fvector = (FloorVector) TutorTests.newInstanceOf(FloorVector.class, new Class[]{Double.TYPE}, new Object[]{17.6});
    fvector.setRealY(4.8);
    fvector.setRealZ(187.9);

    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.X});
    TutorTests.callMethod(FloorVector.class, "setX", new Class[]{Integer.TYPE}, fvector, new Object[]{3});
    assertEquals(3.0, TutorTests.getAttributeValue(FloorVector.class, "x", fvector),"setX funktioniert für Axis.X nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Y});
    TutorTests.callMethod(FloorVector.class, "setX", new Class[]{Integer.TYPE}, fvector, new Object[]{56});
    assertEquals(56.0, TutorTests.getAttributeValue(FloorVector.class, "y", fvector),"setX funktioniert für Axis.Y nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setFirstAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Z});
    TutorTests.callMethod(FloorVector.class, "setX", new Class[]{Integer.TYPE}, fvector, new Object[]{197});
    assertEquals(197.0, TutorTests.getAttributeValue(FloorVector.class, "z", fvector),"setX funktioniert für Axis.Z nicht erkennbar korrekt");

    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.X});
    TutorTests.callMethod(FloorVector.class, "setY", new Class[]{Integer.TYPE}, fvector, new Object[]{30});
    assertEquals(30.0, TutorTests.getAttributeValue(FloorVector.class, "x", fvector),"setY funktioniert für Axis.X nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Y});
    TutorTests.callMethod(FloorVector.class, "setY", new Class[]{Integer.TYPE}, fvector, new Object[]{65});
    assertEquals(65.0, TutorTests.getAttributeValue(FloorVector.class, "y", fvector),"setY funktioniert für Axis.Y nicht erkennbar korrekt");
    TutorTests.callMethod(FloorVector.class, "setSecondAxis", new Class[]{Axis.class}, fvector, new Object[]{Axis.Z});
    TutorTests.callMethod(FloorVector.class, "setY", new Class[]{Integer.TYPE}, fvector, new Object[]{55});
    assertEquals(55.0, TutorTests.getAttributeValue(FloorVector.class, "z", fvector),"setY funktioniert für Axis.Z nicht erkennbar korrekt");
  }

}

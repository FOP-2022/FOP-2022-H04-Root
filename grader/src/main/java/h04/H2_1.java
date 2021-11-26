package h04;

import fopbot.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H2_1 {

  @Test
  public void extendsAndImplementsCorrect(){
    assertEquals(Robot.class, RepetitiveRobotImpl.class.getSuperclass());

    Class[] expectedInterfaces = new Class[]{WithNaturalCoordinates.class, RepetitiveRobot.class};
    Class[] actualInterfaces = RepetitiveRobotImpl.class.getInterfaces();
    assertEquals(2, actualInterfaces.length, "MEhr Interfaces implementiert als gefordert");

    boolean foundRepetitiveRobot = false, foundWithNaturalCoordinates = false;
    for(Class c : actualInterfaces){
      if(c == RepetitiveRobot.class)
        foundRepetitiveRobot = true;
      else if(c == WithNaturalCoordinates.class)
        foundWithNaturalCoordinates = true;
    }


    assertTrue(foundRepetitiveRobot, "RepetitiveRobotImpl implementiert RepetitiveRobot nicht erkennbar korrekt");
    assertTrue(foundWithNaturalCoordinates, "RepetitiveRobotImpl implementiert WithNaturalCoordinates nicht erkennbar korrekt");
  }



  @Test
  public void constructorCorrect(){
    TutorTests.setupWorld(10);
    for(int test_element : new int[]{0, 5, 10, 22}){
      RepetitiveRobotImpl rob = (RepetitiveRobotImpl) TutorTests.newInstanceOf(RepetitiveRobotImpl.class, new Class[]{Integer.TYPE}, new Object[]{test_element});
      assertEquals(0, rob.getX());
      assertEquals(0, rob.getY());
      assertEquals(Direction.UP, rob.getDirection());
      assertEquals(100 - test_element, rob.getNumberOfCoins()); // TODO: Check, if really dropped with putCoin(n)
    }
  }


  public void actionMethodSingleTest(String method, int[] testVals, Function<RepetitiveRobotImpl, Boolean> check, String message){
    RepetitiveRobotImpl rob = (RepetitiveRobotImpl) TutorTests.newInstanceOf(RepetitiveRobotImpl.class, new Class[]{Integer.TYPE}, new Object[]{0});
    for(int testVal : testVals)
      TutorTests.callMethod(RepetitiveRobotImpl.class, method, new Class[]{Integer.TYPE}, rob, new Object[]{testVal});
    assertTrue(check.apply(rob), message);
  }

  @Test
  public void actionMethodsCorrect(){
    TutorTests.setupWorld(10);
    World.putCoins(0, 0, 10000);
    actionMethodSingleTest("move", new int[]{2}, (rob) -> rob.getY() == 2, "move nicht korrekt");
    actionMethodSingleTest("move", new int[]{5, 1}, (rob) -> rob.getY() == 6, "move nicht korrekt");
    actionMethodSingleTest("turnLeft", new int[]{6}, (rob) -> rob.getDirection() == Direction.DOWN, "turnLeft nicht korrekt");
    actionMethodSingleTest("turnLeft", new int[]{4}, (rob) -> rob.getDirection() == Direction.UP, "turnLeft nicht korrekt");
    actionMethodSingleTest("putCoin", new int[]{6}, (rob) -> rob.getNumberOfCoins() == 100-6, "putCoin nicht korrekt");
    actionMethodSingleTest("putCoin", new int[]{0}, (rob) -> rob.getNumberOfCoins() == 100-0, "putCoin nicht korrekt");
    actionMethodSingleTest("pickCoin", new int[]{10, 90}, (rob) -> rob.getNumberOfCoins() == 100+100, "pickCoin nicht korrekt");
    actionMethodSingleTest("pickCoin", new int[]{0, 0}, (rob) -> rob.getNumberOfCoins() == 100+0, "pickCoin nicht korrekt");
  }


  public void actionMethodSingleCrashTest(String method, int testVal){
    RepetitiveRobotImpl rob = (RepetitiveRobotImpl) TutorTests.newInstanceOf(RepetitiveRobotImpl.class, new Class[]{Integer.TYPE}, new Object[]{0});
    try {
      TutorTests.callMethod(RepetitiveRobotImpl.class, method, new Class[]{Integer.TYPE}, rob, new Object[]{testVal});
    }catch (RuntimeException e){
      assertEquals("crash", e.getStackTrace()[0].getMethodName(), "Crash für negative Anzahl von Widerholungen in Methode " + method + " nicht aufgerufen");
    }
  }


  @Test
  public void actionMethodsCrashingCorrect(){
    TutorTests.setupWorld(10);
    World.putCoins(0, 0, 10000);
    actionMethodSingleCrashTest("move", -1);
    actionMethodSingleCrashTest("turnLeft", -1);
    actionMethodSingleCrashTest("putCoin", -1);
    actionMethodSingleCrashTest("pickCoin", -1);
  }


  @Test
  public void getMethodsCorrect(){
    TutorTests.setupWorld(10);
    World.putCoins(0, 0, 10000);
    actionMethodSingleTest("move", new int[]{2}, (rob) -> rob.getMoveRepetitions() == 2, "getMoveRepetitions nicht korrekt");
    actionMethodSingleTest("move", new int[]{5, 1}, (rob) -> rob.getMoveRepetitions() == 6, "getMoveRepetitions nicht korrekt");
    actionMethodSingleTest("turnLeft", new int[]{6, 3}, (rob) -> rob.getTurnLeftRepetitions() == 9, "getTurnLeftRepetitions nicht korrekt");
    actionMethodSingleTest("turnLeft", new int[]{4, 0}, (rob) -> rob.getTurnLeftRepetitions() == 4, "getTurnLeftRepetitions nicht korrekt");
    actionMethodSingleTest("putCoin", new int[]{6, 1}, (rob) -> rob.getPutCoinRepetitions() == 7, "getPutCoinRepetitions nicht korrekt");
    actionMethodSingleTest("putCoin", new int[]{0}, (rob) -> rob.getPutCoinRepetitions() == 0, "getPutCoinRepetitions nicht korrekt");
    actionMethodSingleTest("pickCoin", new int[]{10, 90}, (rob) -> rob.getPickCoinRepetitions() == 100, "getPickCoinRepetitions nicht korrekt");
    actionMethodSingleTest("pickCoin", new int[]{0, 0}, (rob) -> rob.getPickCoinRepetitions() == 0, "getPickCoinRepetitions nicht korrekt");
  }

  @Test
  public void setUsingAbs(){
    int[] test_vec = new int[]{0, 5, -6};

    TutorTests.setupWorld(10);
    RepetitiveRobotImpl rob = (RepetitiveRobotImpl) TutorTests.newInstanceOf(RepetitiveRobotImpl.class, new Class[]{Integer.TYPE}, new Object[]{0});

    for(int test_element : test_vec){
      rob.setX(test_element);
      rob.setY(test_element);
    }
  }
}

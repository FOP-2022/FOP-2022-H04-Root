package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestForSubmission("h04")
public class H1_3 {

  public void isInterface(){
    assertTrue(RepetitiveRobot.class.isInterface(), "RepetitiveRobot ist kein Interface");
  }


  @Test
  public void actionMethodsCorrect(){
    isInterface();
    TutorTests.checkMethodExist(RepetitiveRobot.class, "move", new Class[]{Integer.TYPE}, Void.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "turnLeft", new Class[]{Integer.TYPE}, Void.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "pickCoin", new Class[]{Integer.TYPE}, Void.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "putCoin", new Class[]{Integer.TYPE}, Void.TYPE, false);
  }

  @Test
  public void getMethodsCorrect(){
    isInterface();
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getMoveRepetitions", new Class[]{}, Integer.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getTurnLeftRepetitions", new Class[]{}, Integer.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getPickCoinRepetitions", new Class[]{}, Integer.TYPE, false);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getPutCoinRepetitions", new Class[]{}, Integer.TYPE, false);
  }



}

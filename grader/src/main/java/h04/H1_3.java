package h04;


import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

@TestForSubmission("h04")
public class H1_3 {

  @Test
  public void actionMethodsCorrect(){
    TutorTests.checkMethodExist(RepetitiveRobot.class, "move", new Class[]{Integer.TYPE}, Void.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "turnLeft", new Class[]{Integer.TYPE}, Void.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "pickCoin", new Class[]{Integer.TYPE}, Void.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "putCoin", new Class[]{Integer.TYPE}, Void.TYPE);
  }

  @Test
  public void getMethodsCorrect(){
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getMoveRepetitions", new Class[]{}, Integer.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getTurnLeftRepetitions", new Class[]{}, Integer.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getPickCoinRepetitions", new Class[]{}, Integer.TYPE);
    TutorTests.checkMethodExist(RepetitiveRobot.class, "getPutCoinRepetitions", new Class[]{}, Integer.TYPE);
  }



}

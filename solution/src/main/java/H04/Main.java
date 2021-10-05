package H04;

import fopbot.*;

public class Main {

  public static int WORLD_SIZE_X = 10;
  public static int WORLD_SIZE_Y = 10;
  public static int BASIC_ARRAY_SIZE = 5;

  public static void main(String[] args) {
    World.setSize(WORLD_SIZE_X, WORLD_SIZE_Y);
    World.setDelay(0);
    World.setVisible(true);

    //Test
    //robotTests();

    //H3
    CorrectnessCheck correctnesCheck = new CorrectnessCheck(BASIC_ARRAY_SIZE);
    correctnesCheck.run();

  }

  public static void robotTests() {

  }
}

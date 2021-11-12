package h04;

import fopbot.*;

public class Main {

  public static int WORLD_SIZE_X = 10;
  public static int WORLD_SIZE_Y = 10;
  public static int BASIC_ARRAY_SIZE = 5;

  public static boolean ENABLE_CORRCTNESS_CHECK = false; // für H03 ändern


  public static void main(String[] args) {
    World.setSize(WORLD_SIZE_X, WORLD_SIZE_Y);
    World.setDelay(200);
    World.setVisible(true);


    if(ENABLE_CORRCTNESS_CHECK) {
      System.out.println("All tests: " + (new ArrayTesterImpl()).testAll(new ArrayProducerImpl(), BASIC_ARRAY_SIZE));
    }else {
      robotTests();
    }
  }


  public static void robotTests() {
    //TODO
  }


}

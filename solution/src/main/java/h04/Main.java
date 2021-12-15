package h04;

import fopbot.*;

/**
 * This is the solution's main class which replaces the submission main class when graded with Jagr.
 */
public class Main {

    public static int WORLD_SIZE_X = 10;
    public static int WORLD_SIZE_Y = 10;
    public static int BASIC_ARRAY_SIZE = 5;

    public static boolean ENABLE_CORRECTNESS_CHECK = true; // für H03 ändern

    /**
     * Creates World and run robotTests() or testAll of ArrayTester
     * @param args Command Line Args
     */
    public static void main(String[] args) {
        World.setSize(WORLD_SIZE_X, WORLD_SIZE_Y);
        World.setDelay(200);
        World.setVisible(true);

        if (ENABLE_CORRECTNESS_CHECK) {
            // System.out.println("All tests: " + (new ArrayTesterImpl()).testAll(new ArrayProducerImpl(), BASIC_ARRAY_SIZE));
        } else {
            robotTests();
        }
    }

    /**
     * Run some tests with the Robots
     */
    public static void robotTests() {
        //TODO
    }
}

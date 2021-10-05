package H04;

import fopbot.*;

public class CorrectnessCheck {


  private final int BASIC_ARRAY_SIZE;

  private RobotWithNaturalCoordinatesAndClockDirection[] testArray1;
  private RealValuedPoint3D[] testArray2;
  private WithNaturalCoordinates[] testArray3;
  private WithClockDirection[] testArray4;

  public CorrectnessCheck(final int BASIC_ARRAY_SIZE) {
    this.BASIC_ARRAY_SIZE = BASIC_ARRAY_SIZE;
  }

  public void run() {
    init();
    System.out.println("1. Überprüfung: " + check1());
    swap();
    System.out.println("2. Überprüfung: " + check2());
    System.out.println("3. Überprüfung: " + check3());
  }


  private void init() {
    //testArray1
    testArray1 = new RobotWithNaturalCoordinatesAndClockDirection[BASIC_ARRAY_SIZE];
    for (int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      RobotWithNaturalCoordinatesAndClockDirection rob = new RobotWithNaturalCoordinatesAndClockDirection(Direction.UP);
      rob.setY(i);
      rob.setX(2*i);
      for(int r = 0; r < i % 4; r++)
        rob.turnClockwise();

      testArray1[i] = rob;
    }

    //testArray2
    testArray2 = new RealValuedPoint3D[BASIC_ARRAY_SIZE];
    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      RealValuedPoint3D point = new RealValuedPoint3D(3*i+0.1);
      point.setRealY(4*i+0.2);
      point.setRealZ(5*i+0.3);

      point.setFirstChoice(CoordinatesChoice3D.values()[i % 3]);
      point.setSecondChoice(CoordinatesChoice3D.values()[(i+1) % 3]);

      testArray2[i] = point;
    }


    //testArray3
    testArray3 = new WithNaturalCoordinates[2*BASIC_ARRAY_SIZE];
    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      testArray3[2*i] = testArray1[i];
      testArray3[2*i+1] = testArray2[i];
    }

    //testArray4
    testArray4 = new WithClockDirection[BASIC_ARRAY_SIZE];
    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      testArray4[i] = testArray1[i];
    }

  }

  private boolean check1() {
    //check all: violation -> return false;

    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      if(testArray3[2*i].getX() != 2*i || testArray3[2*i].getY() != i)
        return false;

      //x = 3i, y=4i, z=5i
      if(i % 3 == 0) {//x,y
        if(testArray3[2*i + 1].getX() != 3*i || testArray3[2*i + 1].getY() != 4*i)
          return false;
      }else if(i % 3 == 1) {//y,z
        if(testArray3[2*i + 1].getX() != 4*i || testArray3[2*i + 1].getY() != 5*i)
          return false;
      }else {//z, x
        if(testArray3[2*i + 1].getX() != 5*i || testArray3[2*i + 1].getY() != 3*i)
          return false;
      }
    }

    return true;
  }

  private void swap() {
    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      WithNaturalCoordinates tmp = testArray3[2*i];
      testArray3[2*i] = testArray3[2*i + 1];
      testArray3[2*i + 1] = tmp;
    }
  }

  private boolean check2() {
    //check all: violation -> return false;
    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      if(testArray3[2*i+1].getX() != 2*i || testArray3[2*i+1].getY() != i)
        return false;

      //x = 3i, y=4i, z=5i
      if(i % 3 == 0) {//x,y
        if(testArray3[2*i].getX() != 3*i || testArray3[2*i].getY() != 4*i)
          return false;
      }else if(i % 3 == 1) {//y,z
        if(testArray3[2*i].getX() != 4*i || testArray3[2*i].getY() != 5*i)
          return false;
      }else {//z, x
        if(testArray3[2*i].getX() != 5*i || testArray3[2*i].getY() != 3*i)
          return false;
      }
    }

    return true;
  }

  private boolean check3() {
    //check all: violation -> return false;

    for(int i = 0; i < BASIC_ARRAY_SIZE; i++) {
      if(testArray4[i].getClockDirection() != (i % 4 == 0 ? 12 : 3*(i % 4)))
        return false;
    }

    return true;
  }

}

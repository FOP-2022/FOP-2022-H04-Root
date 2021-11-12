package h04;

public class ArrayTesterImpl  implements ArrayTester{


  @Override
  public boolean test1(WithNaturalCoordinates[] array3) {
    return false;
  }

  @Override
  public boolean test2(WithNaturalCoordinates[] array3) {
    return false;
  }

  @Override
  public boolean test3(RepetitiveRobot[] array4) {
    return false;
  }




  /*
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
   */
}

package h04;

public class Tutor_ArrayTesterImpl implements Tutor_ArrayTester {

  @Override
  public boolean test1(RepetitiveRobot[] array1) {
    for (int i = 0; i < array1.length; i++) {
      if (array1[i].getPutCoinRepetitions() != i) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param i Index in array2
   * @return the expected Value for axis at Index i
   */
  private static int getValueForAxisAndIndex(Axis axis, int i) {
    switch (axis) {
      case X:
        return 3 * i;
      case Y:
        return 4 * i;
      case Z:
        return 5 * i;
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean test3(WithNaturalCoordinates[] array3) {
    for (int i = 0; i < array3.length / 2; i++) {
      //RepetitiveRobotImpl an 2*i
      if (array3[2 * i].getX() != 2 * i || array3[2 * i].getY() != i) {
        return false;
      }

      //FloorVector an 2*i+1
      if (array3[2 * i + 1].getX() != getValueForAxisAndIndex(Axis.values()[i % 3], i) || array3[2 * i + 1].getY() != getValueForAxisAndIndex(Axis.values()[(i + 1) % 3], i)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean test4(WithNaturalCoordinates[] array4) {
    for (int i = 0; i < array4.length / 2; i++) {
      //FloorVector an 2*i
      if (array4[2 * i].getX() != getValueForAxisAndIndex(Axis.values()[i % 3], i) || array4[2 * i].getY() != getValueForAxisAndIndex(Axis.values()[(i + 1) % 3], i)) {
        return false;
      }

      //RepetitiveRobotImpl an 2*i+1
      if (array4[2 * i + 1].getX() != 2 * i || array4[2 * i + 1].getY() != i) {
        return false;
      }
    }
    return true;
  }
}

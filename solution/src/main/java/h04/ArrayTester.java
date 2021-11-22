package h04;

public interface ArrayTester {

  /**
   * Run test1, test2 & test3
   * @param producer to create all Arrays for Test
   * @param arraySize to run Tests
   * @return true, if all test run successful; otherwise false
   */
  default boolean testAll(ArrayProducer producer, int arraySize) {
    RepetitiveRobotImpl[] array1 = producer.produceArray1(arraySize);
    FloorVector[] array2 = producer.produceArray2(arraySize);
    WithNaturalCoordinates[] array3 = producer.produceArray3(array1, array2);
    WithNaturalCoordinates[] array4 = producer.produceArray4(array3);
    return test1(array1) && test3(array3) && test4(array4);
  }

  /**
   *
   * @param array1 Array, which got produced by produce1
   * @return true, if array follows specification refering to number dropped Coins; otherwise false
   */
  boolean test1(RepetitiveRobot[] array1);

  /**
   *
   * @param array3 Array, which got produced by produce3
   * @return true, if array follows specification refering to x,y,z for FloorVector and position for RepetitiveRobotImpl; otherwise false
   */
  boolean test3(WithNaturalCoordinates[] array3);

  /**
   *
   * @param array4 Array, which got produced by produce4
   * @return true, if array follows specification refering to x,y,z for FloorVector and position for RepetitiveRobotImpl; otherwise false
   */
  boolean test4(WithNaturalCoordinates[] array4);
}

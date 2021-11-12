package h04;

public interface ArrayProducer {
  RepetitiveRobotImpl[] produceArray1(int arraySize);
  FloorVector[] produceArray2(int arraySize);
  WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2);
  RepetitiveRobot[] produceArray4(RepetitiveRobotImpl[] array1);

  WithNaturalCoordinates[] swap(WithNaturalCoordinates[] array);
}

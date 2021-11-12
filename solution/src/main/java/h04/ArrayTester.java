package h04;

public interface ArrayTester {
  default boolean testAll(ArrayProducer producer, int arraySize){
    return  test1(producer.produceArray3(producer.produceArray1(arraySize), producer.produceArray2(arraySize))) &&
            test2(producer.swap(producer.produceArray3(producer.produceArray1(arraySize), producer.produceArray2(arraySize)))) &&
            test3(producer.produceArray4(producer.produceArray1(arraySize)));
  }
  boolean test1(WithNaturalCoordinates[] array3);
  boolean test2(WithNaturalCoordinates[] array3);
  boolean test3(RepetitiveRobot[] array4);
}

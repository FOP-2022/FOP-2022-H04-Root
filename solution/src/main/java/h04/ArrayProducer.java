package h04;

public interface ArrayProducer {
    /**
     * @param arraySize the array has to be
     * @return Array with the given specifications
     */
    RepetitiveRobotImpl[] produceArray1(int arraySize);

    /**
     * @param arraySize the array has to be
     * @return Array with the given specifications
     */
    FloorVector[] produceArray2(int arraySize);

    /**
     * @param array1 from produceArray1
     * @param array2 from produceArray2
     * @return Array with the given specifications
     */
    WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2);

    /**
     * @param array from produceArray3
     * @return Array with the given specifications
     */
    WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array);
}

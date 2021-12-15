package h04;

public interface ArrayProducer {
    /**
     * Create array, which fulfills requirements of array1
     * @param arraySize the array has to be
     * @return Array with the given specifications
     */
    RepetitiveRobotImpl[] produceArray1(int arraySize);

    /**
     * Create array, which fulfills requirements of array2
     * @param arraySize the array has to be
     * @return Array with the given specifications
     */
    FloorVector[] produceArray2(int arraySize);

    /**
     * Create array, which fulfills requirements of array3
     * @param array1 from produceArray1
     * @param array2 from produceArray2
     * @return Array with the given specifications
     */
    WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2);

    /**
     * Create array, which fulfills requirements of array4
     * @param array from produceArray3
     * @return Array with the given specifications
     */
    WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array);
}

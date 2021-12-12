package h04;

public class ArrayProducerImpl implements ArrayProducer {
    @Override
    public RepetitiveRobotImpl[] produceArray1(int arraySize) {
        RepetitiveRobotImpl[] testArray1 = new RepetitiveRobotImpl[arraySize];
        for (int i = 0; i < arraySize; i++) {
            RepetitiveRobotImpl rob = new RepetitiveRobotImpl(0);
            rob.setY(i);
            rob.setX(2 * i);
            rob.putCoin(i);

            testArray1[i] = rob;
        }
        return testArray1;
    }

    @Override
    public FloorVector[] produceArray2(int arraySize) {
        FloorVector[] array2 = new FloorVector[arraySize];
        for (int i = 0; i < arraySize; i++) {
            FloorVector point = new FloorVector(3 * i + 0.1);
            point.setRealY(4 * i + 0.2);
            point.setRealZ(5 * i + 0.3);

            point.setFirstAxis(Axis.values()[i % 3]);
            point.setSecondAxis(Axis.values()[(i + 1) % 3]);

            array2[i] = point;
        }
        return array2;
    }

    @Override
    public WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2) {
        WithNaturalCoordinates[] array3 = new WithNaturalCoordinates[2 * array1.length];
        for (int i = 0; i < array1.length; i++) {
            array3[2 * i] = array1[i];
            array3[2 * i + 1] = array2[i];
        }
        return array3;
    }

    @Override
    public WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array) {
        WithNaturalCoordinates[] array4 = new WithNaturalCoordinates[array.length];
        for (int i = 0; i < array4.length / 2; i++) {
            array4[2 * i + 1] = array[2 * i];
            array4[2 * i] = array[2 * i + 1];
        }
        return array4;
    }
}

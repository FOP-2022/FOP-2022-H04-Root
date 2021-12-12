package h04;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H3_2 {

    public static int arraySize = 5;

    @Test
    public void test1Correct() {
        TutorTests.setupWorld(2 * arraySize);
        Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();
        RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);

        ArrayTester tester = new ArrayTesterImpl();

        //erkennt richtigenFall
        assertTrue(tester.test1(array1));

        //erkennt kaputte
        RepetitiveRobotImpl[] broken_array1 = Arrays.copyOf(array1, array1.length);
        broken_array1[0].putCoin(1);
        assertFalse(tester.test1(broken_array1));

        RepetitiveRobotImpl[] broken_array2 = Arrays.copyOf(array1, array1.length);
        broken_array1[arraySize - 1].putCoin(1);
        assertFalse(tester.test1(broken_array2));
    }

    @Test
    public void test3RepetitiveRobotImplCorrect() {
        TutorTests.setupWorld(2 * arraySize);
        Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();
        RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);
        FloorVector[] array2 = tutor_producer.produceArray2(arraySize);
        WithNaturalCoordinates[] array3 = tutor_producer.produceArray3(array1, array2);

        ArrayTester tester = new ArrayTesterImpl();

        //erkennt richtigenFall
        assertTrue(tester.test3(array3));

        //erkennt kaputte RepetitiveRobot
        WithNaturalCoordinates[] broken_array1 = Arrays.copyOf(array3, array3.length);
        ((RepetitiveRobotImpl) broken_array1[0]).move();
        assertFalse(tester.test3(broken_array1));

        WithNaturalCoordinates[] broken_array2 = Arrays.copyOf(array3, array3.length);
        ((RepetitiveRobotImpl) broken_array1[2 * (arraySize - 1)]).turnLeft();
        ((RepetitiveRobotImpl) broken_array1[2 * (arraySize - 1)]).move();
        assertFalse(tester.test3(broken_array2));
    }

    @Test
    public void test3FloorVectorCorrect() {
        TutorTests.setupWorld(2 * arraySize);
        Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();
        RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);
        FloorVector[] array2 = tutor_producer.produceArray2(arraySize);
        WithNaturalCoordinates[] array3 = tutor_producer.produceArray3(array1, array2);

        ArrayTester tester = new ArrayTesterImpl();

        //erkennt richtigenFall
        assertTrue(tester.test3(array3));

        //erkennt kaputte FloorVector
        WithNaturalCoordinates[] broken_array1 = Arrays.copyOf(array3, array3.length);
        ((FloorVector) broken_array1[1]).setRealX(99.00);
        assertFalse(tester.test3(broken_array1));

        WithNaturalCoordinates[] broken_array2 = Arrays.copyOf(array3, array3.length);
        ((FloorVector) broken_array1[2 * (arraySize) - 1]).setFirstAxis(Axis.Z);
        assertFalse(tester.test3(broken_array2));
    }

    @Test
    public void test4Correct() {
        TutorTests.setupWorld(2 * arraySize);
        Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();
        RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);
        FloorVector[] array2 = tutor_producer.produceArray2(arraySize);
        WithNaturalCoordinates[] array3 = tutor_producer.produceArray3(array1, array2);
        WithNaturalCoordinates[] array4 = tutor_producer.produceArray4(array3);

        ArrayTester tester = new ArrayTesterImpl();

        //erkennt richtigenFall
        assertTrue(tester.test4(array4));

        //erkennt kaputte RepetitiveRobot
        WithNaturalCoordinates[] broken_array1 = Arrays.copyOf(array4, array4.length);
        ((RepetitiveRobotImpl) broken_array1[1]).move();
        assertFalse(tester.test4(broken_array1));

        WithNaturalCoordinates[] broken_array2 = Arrays.copyOf(array4, array4.length);
        ((RepetitiveRobotImpl) broken_array1[2 * arraySize - 1]).turnLeft();
        ((RepetitiveRobotImpl) broken_array1[2 * arraySize - 1]).move();
        assertFalse(tester.test4(broken_array2));

        //erkennt kaputte FloorVector
        WithNaturalCoordinates[] broken_array3 = Arrays.copyOf(array4, array4.length);
        ((FloorVector) broken_array3[0]).setRealX(99.00);
        assertFalse(tester.test4(broken_array3));

        WithNaturalCoordinates[] broken_array4 = Arrays.copyOf(array4, array4.length);
        ((FloorVector) broken_array4[2 * (arraySize - 1)]).setFirstAxis(Axis.Z);
        assertFalse(tester.test4(broken_array4));
    }

    @Test
    public void testDifferentSizes() {
        for (int i : new int[]{6, 2, 10}) {
            arraySize = i;
            test1Correct();
            test3FloorVectorCorrect();
            test3RepetitiveRobotImplCorrect();
            test4Correct();
        }
    }
}

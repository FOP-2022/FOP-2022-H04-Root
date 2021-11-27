package h04;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H3_1 {

  static int arraySize = 5;

  @Test
  public void produceArray1Correct(){
    TutorTests.setupWorld(10);
    ArrayProducer producer = new ArrayProducerImpl();
    RepetitiveRobotImpl[] array1 = producer.produceArray1(arraySize);
    assertEquals(arraySize, array1.length);
    assertTrue(new Tutor_ArrayTesterImpl().test1(array1));
  }

  @Test
  public void produceArray2Correct(){
    TutorTests.setupWorld(10);
    ArrayProducer producer = new ArrayProducerImpl();
    FloorVector[] array2 = producer.produceArray2(arraySize);
    assertEquals(arraySize, array2.length);
    for(int i = 0; i < array2.length; i++){
      assertEquals(3*i+0.1, (double)TutorTests.getAttributeValue(FloorVector.class, "x", array2[i]), "x an Index " + i + "nicht korrekt");
      assertEquals(4*i+0.2, (double)TutorTests.getAttributeValue(FloorVector.class, "y", array2[i]), "y an Index " + i + "nicht korrekt");
      assertEquals(5*i+0.3, (double)TutorTests.getAttributeValue(FloorVector.class, "z", array2[i]), "z an Index " + i + "nicht korrekt");

      assertEquals(Axis.values()[i % 3], (Axis)TutorTests.getAttributeValue(FloorVector.class, "firstAxis", array2[i]), "firstAxis an Index " + i + "nicht korrekt");
      assertEquals(Axis.values()[(i+1) % 3], (Axis)TutorTests.getAttributeValue(FloorVector.class, "secondAxis", array2[i]), "secondAxis an Index " + i + "nicht korrekt");
    }//TODO: Problematisch, wenn Student andere Reihenfolge als X, Y, Z
  }

  @Test
  public void produceArray3Correct(){
    TutorTests.setupWorld(10);
    ArrayProducer producer = new ArrayProducerImpl();
    Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();

    RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);
    FloorVector[] array2 = tutor_producer.produceArray2(arraySize);

    WithNaturalCoordinates[] array3 = producer.produceArray3(array1, array2);

    assertEquals(2*arraySize, array3.length);

    for(int i = 0; i < arraySize; i++){
      //schauen, dass Typ passt
      assertEquals(array1[i], array3[2*i]);
      assertEquals(array2[i], array3[2*i+1]);
    }

  }

  @Test
  public void produceArray4Correct(){
    TutorTests.setupWorld(10);
    ArrayProducer producer = new ArrayProducerImpl();
    Tutor_ArrayProducer tutor_producer = new Tutor_ArrayProducerImpl();

    RepetitiveRobotImpl[] array1 = tutor_producer.produceArray1(arraySize);
    FloorVector[] array2 = tutor_producer.produceArray2(arraySize);
    WithNaturalCoordinates[] array3 = tutor_producer.produceArray3(array1, array2);

    WithNaturalCoordinates[] array4 = producer.produceArray4(array3);
    assertEquals(array3.length, array4.length);

    for(int i = 0; i < array3.length /2; i++){
      assertEquals(array3[2*i], array4[2*i+1], "produceArray4 (swap) error on Index " + i);
    }
  }
}

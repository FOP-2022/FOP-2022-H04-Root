package h04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.sourcegrade.jagr.api.testing.SourceFile;
import org.sourcegrade.jagr.api.testing.TestCycle;
import org.sourcegrade.jagr.api.testing.extension.TestCycleResolver;
import spoon.Launcher;
import spoon.reflect.code.CtConditional;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.compiler.VirtualFile;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h04")
public class H3_3 {

    static int arraySize = 5;

    public class TracingArrayProducer implements ArrayProducer {
        public RepetitiveRobotImpl[] array1 = new RepetitiveRobotImpl[0];
        public FloorVector[] array2 = new FloorVector[0];
        public WithNaturalCoordinates[] array3 = new WithNaturalCoordinates[0];
        public WithNaturalCoordinates[] array4 = new WithNaturalCoordinates[0];

        @Override
        public RepetitiveRobotImpl[] produceArray1(int arraySize) {
            if (arraySize != H3_3.arraySize) {
                fail("arraySize nicht korrekt übergeben");
            }
            return array1;
        }

        @Override
        public FloorVector[] produceArray2(int arraySize) {
            if (arraySize != H3_3.arraySize) {
                fail("arraySize nicht korrekt übergeben");
            }
            return array2;
        }

        @Override
        public WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2) {
            if (array1 != this.array1 || array2 != this.array2) {
                fail("array1 & array2 falsch and produceArray3 übergeben");
            }
            return array3;
        }

        @Override
        public WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array) {
            if (array != array3) {
                fail("array3 falsch an produceArray4 übergeben");
            }
            return array4;
        }
    }

    public class TracingArrayTester implements ArrayTester {

        boolean r1, r2, r3;
        TracingArrayProducer tracingProducer;

        public TracingArrayTester(boolean r1, boolean r2, boolean r3, TracingArrayProducer tracingProducer) {
            this.r1 = r1;
            this.r2 = r2;
            this.r3 = r3;
            this.tracingProducer = tracingProducer;
        }

        @Override
        public boolean test1(RepetitiveRobot[] array1) {
            if (tracingProducer.array1 != array1) {
                fail("test1 nicht mit Array aus produceArray1 aufgerufen");
            }
            return r1;
        }

        @Override
        public boolean test3(WithNaturalCoordinates[] array3) {
            if (tracingProducer.array3 != array3) {
                fail("test3 nicht mit Array aus produceArray3 aufgerufen");
            }
            return r2;
        }

        @Override
        public boolean test4(WithNaturalCoordinates[] array4) {
            if (tracingProducer.array4 != array4) {
                fail("test4 nicht mit Array aus produceArray4 aufgerufen");
            }
            return r3;
        }
    }

    @Test
    public void testAllCorrect() {
        TracingArrayProducer producer = new TracingArrayProducer();
        boolean[][] test_vec = new boolean[][]{{true, true, true}, {false, true, true}, {true, false, true}, {true, false, false}};

        for (boolean[] test_element : test_vec) {
            TracingArrayTester tester = new TracingArrayTester(test_element[0], test_element[1], test_element[2], producer);
            assertEquals(test_element[0] & test_element[1] & test_element[2], tester.testAll(producer, arraySize));
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void logicOperatorUsed(TestCycle cycle) {
        String fileName = "ArrayTester.java";
        SourceFile sourceFile = cycle.getSubmission().getSourceFile(fileName);
        Launcher spoon = new Launcher();
        spoon.addInputResource(new VirtualFile(Objects.requireNonNull(sourceFile).getContent(), fileName));
        spoon.buildModel();
        CtType<?> type = spoon.getModel().getAllTypes().stream().filter(CtType::isTopLevel).findFirst().orElseThrow();
        CtMethod<?> method = type.getMethodsByName("testAll").stream().findFirst().orElseThrow();

        // Check for if statements
        if (!method.getElements(new TypeFilter<>(CtIf.class)).isEmpty()) {
            fail("If statements are not allowed in method testAll().");
        }

        // Check for switch statements
        if (!method.getElements(new TypeFilter<>(CtSwitch.class)).isEmpty()) {
            fail("Switch statements are not allowed in method testAll().");
        }

        // Check for ternary operator
        if (!method.getElements(new TypeFilter<>(CtConditional.class)).isEmpty()) {
            fail("The ternary operator is not allowed in method testAll().");
        }
    }
}

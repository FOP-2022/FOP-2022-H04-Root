package h04;

import org.sourcegrade.docwatcher.grading.DocumentationCriterion;
import org.sourcegrade.docwatcher.grading.DocumentationGrader;
import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.Grader;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricForSubmission;
import org.sourcegrade.jagr.api.rubric.RubricProvider;
import org.sourcegrade.jagr.api.testing.TestCycle;

@RubricForSubmission("h04")
public class H04_RubricProvider implements RubricProvider {
    // Hack: initialize DI container
    static {
        try {
            Class.forName("org.sourcegrade.docwatcher.DocWatcherModule");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ///////////////////////////////////////////////// H1.1

    public static final Criterion H1_1_T1 = Criterion.builder()
        .shortDescription("getX und getY in WithNaturalCoordinates sind erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("getMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H1_1_T2 = Criterion.builder()
        .shortDescription("setX und setY in WithNaturalCoordinates sind erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("setMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription("H1.1 Interface WithNaturalCoordinates")
        .addChildCriteria(
            H1_1_T1,
            H1_1_T2
        )
        .build();

    ///////////////////////////////////////////////// H1.2

    public static final Criterion H1_3_T1 = Criterion.builder()
        .shortDescription("Die Methoden move, turnLeft, pickCoin und putCoin sind erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H1_3.class.getMethod("actionMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H1_3_T2 = Criterion.builder()
        .shortDescription("get{Move, TurnLeft, PickCoin, PutCoin}Repetitions sind erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H1_3.class.getMethod("getMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H1_3 = Criterion.builder()
        .shortDescription("H1.3 Interface RepetitiveRobot")
        .addChildCriteria(
            H1_3_T1,
            H1_3_T2
        )
        .build();

    ///////////////////////////////////////////////// H2.1

    public static final Criterion H2_1_T1 = Criterion.builder()
        .shortDescription("RepetitiveRobotImpl ist korrekt von Robot abgeleitete und implementiert WithNaturalCoordinates und RepetitiveRobot")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("extendsAndImplementsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1_T2 = Criterion.builder()
        .shortDescription("Der Konstruktor von RepetitiveRobotImpl initialisiert alle Attribute korrekt und ruft putCoin erkennbar korrekt auf")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("constructorCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1_T3 = Criterion.builder()
        .shortDescription("Die Methoden move, turnLeft, pickCoin und putCoin aus RepetitiveRobot sind in RepetitiveRobotImpl erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("actionMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1_T4 = Criterion.builder()
        .shortDescription("Die Methoden move, turnLeft, pickCoin und putCoin aus RepetitiveRobot rufen crash() auf, wenn die Anzahl der Wiederholungen negativ ist")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("actionMethodsCrashingCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1_T5 = Criterion.builder()
        .shortDescription("Die Methoden get{Move, TurnLeft, PickCoin, PutCoin}Repetitions aus RepetitiveRobot liefern die Anzahl der Wiederholungen erkennbar korrekt zurück")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("getMethodsCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1_T6 = Criterion.builder()
        .shortDescription("Die Methoden setX & setY aus WithNaturalCoordinates rufen setX bzw. setY von Robot auf und übergeben bei diesem Aufruf den betrag des aktuallen Parameterwerts")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("setUsingAbs")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_1 = Criterion.builder()
        .shortDescription("H2.1 Implementierende Roboterklasse")
        .addChildCriteria(
            H2_1_T1,
            H2_1_T2,
            H2_1_T3,
            H2_1_T4,
            H2_1_T5,
            H2_1_T6
        )
        .build();

    ///////////////////////////////////////////////// H2.2

    public static final Criterion H2_2_T1 = Criterion.builder()
        .shortDescription("Das Enum Axis wurde erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("enumCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T2 = Criterion.builder()
        .shortDescription("FloorVector implementiert das Interface WithNaturalCoordinates")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("imlementInterfaceCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T3 = Criterion.builder()
        .shortDescription("Die Attribute x, y & z wurden erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("valueAttributesCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T4 = Criterion.builder()
        .shortDescription("getReal{X, Y, Z} und setReal{X, Y, Z} funktionieren erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("valueGetSetCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T5 = Criterion.builder()
        .shortDescription("Die Attribute firstAxis & secondAxis wurden erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("axisAttributesCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T6 = Criterion.builder()
        .shortDescription("{get, set}{First, Second}Axis funktionieren erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("axisGetSetCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T7 = Criterion.builder()
        .shortDescription("Der Konstruktor von FloorVector ist erkennbar korrekt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("constructorCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T8 = Criterion.builder()
        .shortDescription("Die Methoden getX aus WithNaturalCoordinates ist in FloorVector korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("getXCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T9 = Criterion.builder()
        .shortDescription("Die Methoden getY aus WithNaturalCoordinates ist in FloorVector korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("getYCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2_T10 = Criterion.builder()
        .shortDescription("Die Methoden set{X, Y} aus WithNaturalCoordinates sind in FloorVector korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("setCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H2_2 = Criterion.builder()
        .shortDescription("H2.2 Klasse mit drei reellwertigen Koordinaten und Rundung")
        .addChildCriteria(
            H2_2_T1,
            H2_2_T2,
            H2_2_T3,
            H2_2_T4,
            H2_2_T5,
            H2_2_T6,
            H2_2_T7,
            H2_2_T8,
            H2_2_T9,
            H2_2_T10
        )
        .build();

///////////////////////////////////////////////// H3.1

    public static final Criterion H3_1_T1 = Criterion.builder()
        .shortDescription("produceArray1 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_1.class.getMethod("produceArray1Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_1_T2 = Criterion.builder()
        .shortDescription("produceArray2 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_1.class.getMethod("produceArray2Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_1_T3 = Criterion.builder()
        .shortDescription("produceArray3 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_1.class.getMethod("produceArray3Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_1_T4 = Criterion.builder()
        .shortDescription("produceArray4 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_1.class.getMethod("produceArray4Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_1_T5 = Criterion.builder()
        .shortDescription("Die Methoden funktionieren für verschiedene Längen erkennbar korrekt")
        .maxPoints(0)
        .minPoints(-1)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_1.class.getMethod("produceDifferentSizes")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_1 = Criterion.builder()
        .shortDescription("H3.1 Testarrays erzeugen")
        .addChildCriteria(
            H3_1_T1,
            H3_1_T2,
            H3_1_T3,
            H3_1_T4,
            H3_1_T5
        )
        .build();

///////////////////////////////////////////////// H3.2

    public static final Criterion H3_2_T1 = Criterion.builder()
        .shortDescription("test1 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_2.class.getMethod("test1Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_2_T2 = Criterion.builder()
        .shortDescription("test1 ist für RepetitiveRobotImpl erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_2.class.getMethod("test3RepetitiveRobotImplCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_2_T3 = Criterion.builder()
        .shortDescription("test1 ist für FloorVector erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_2.class.getMethod("test3FloorVectorCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_2_T4 = Criterion.builder()
        .shortDescription("test4 ist erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_2.class.getMethod("test4Correct")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_2_T5 = Criterion.builder()
        .shortDescription("Die Methoden funktionieren für verschiedene Längen erkennbar korrekt")
        .maxPoints(0)
        .minPoints(-1)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_2.class.getMethod("testDifferentSizes")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_2 = Criterion.builder()
        .shortDescription("H3.2 Prüfen der Testarrays")
        .addChildCriteria(
            H3_2_T1,
            H3_2_T2,
            H3_2_T3,
            H3_2_T4,
            H3_2_T5
        )
        .build();

///////////////////////////////////////////////// H3.3

    public static final Criterion H3_3_T1 = Criterion.builder()
        .shortDescription("testAll() in ArrayTester wurde erkennbar korrekt umgesetzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_3.class.getMethod("testAllCorrect")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_3_T2 = Criterion.builder()
        .shortDescription("Es wurde nur logische Operatoren zur Verknüpfung der einzelnen Tests genutzt")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H3_3.class.getMethod("logicOperatorUsed", TestCycle.class)))
            .pointsPassedMax()
            .pointsFailedMin()
            .build()
        ).build();

    public static final Criterion H3_3 = Criterion.builder()
        .shortDescription("H3.3 Erstellung und Test zusammenführen")
        .addChildCriteria(
            H3_3_T1,
            H3_3_T2
        )
        .build();

    //Aufgaben
    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 Zwei Interfaces")
        .addChildCriteria(
            H1_1,
            H1_3
        )
        .build();

    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 Implementierende Klassen")
        .addChildCriteria(
            H2_1,
            H2_2
        )
        .build();

    public static final Criterion H3 = Criterion.builder()
        .shortDescription("H3 Korrektheitsprüfungen im größeren Umfang mittels Arrays")
        .addChildCriteria(
            H3_1,
            H3_2,
            H3_3
        )
        .build();

    public static final Criterion JAVADOC = DocumentationCriterion.forGrader(
        DocumentationGrader.builder()
            //.addJavaDoc(d -> d.forTopLevelType("WithNaturalCoordinates"), H1_1)
            .addJavaDoc(d -> d.forTopLevelType("WithNaturalCoordinates").forMethod("getX"), H1_1)
            .addJavaDoc(d -> d.forTopLevelType("WithNaturalCoordinates").forMethod("getY"), H1_1)
            .addJavaDoc(d -> d.forTopLevelType("WithNaturalCoordinates").forMethod("setX", int.class), H1_1)
            .addJavaDoc(d -> d.forTopLevelType("WithNaturalCoordinates").forMethod("setY", int.class), H1_1)
            //addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot"), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("move", int.class), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("turnLeft", int.class), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("putCoin", int.class), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("pickCoin", int.class), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("getMoveRepetitions"), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("getTurnLeftRepetitions"), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("getPutCoinRepetitions"), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobot").forMethod("getPickCoinRepetitions"), H1_3)
            .addJavaDoc(d -> d.forTopLevelType("RepetitiveRobotImpl").forConstructor(int.class), H2_1)
            //.addJavaDoc(d -> d.forTopLevelType("FloorVector"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forConstructor(double.class), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("getRealX"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("getRealY"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("getRealZ"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("setRealX", double.class), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("setRealY", double.class), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("setRealZ", double.class), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("getFirstAxis"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("getSecondAxis"), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("setFirstAxis", Axis.class), H2_2)
            .addJavaDoc(d -> d.forTopLevelType("FloorVector").forMethod("setSecondAxis", Axis.class), H2_2)
            .build()
    );

    public static final Rubric RUBRIC = Rubric.builder()
        .title("h04")
        .addChildCriteria(H1, H2, H3, JAVADOC)
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}

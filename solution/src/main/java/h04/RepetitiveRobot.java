package h04;

public interface RepetitiveRobot {
    /**
     * Do move defined times
     *
     * @param n defines Repetitions
     */
    void move(int n);

    /**
     * Do turnLeft defined times
     *
     * @param n defines Repetitions
     */
    void turnLeft(int n);

    /**
     * Do putCoin defined times
     *
     * @param n defines Repetitions
     */
    void putCoin(int n);

    /**
     * Do pickCoin defined times
     *
     * @param n defines Repetitions
     */
    void pickCoin(int n);

    /**
     * @return cumulative Repetitions of move
     */
    int getMoveRepetitions();

    /**
     * @return cumulative Repetitions of turnLeft
     */
    int getTurnLeftRepetitions();

    /**
     * @return cumulative Repetitions of putCoin
     */
    int getPutCoinRepetitions();

    /**
     * @return cumulative Repetitions of pickCoin
     */
    int getPickCoinRepetitions();
}

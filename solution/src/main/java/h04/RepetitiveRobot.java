package h04;

public interface RepetitiveRobot {
  /**
   * Move defined times
   * @param n defines Repetitions
   */
  void move(int n);

  /**
   * turnLeft defined times
   * @param n defines Repetitions
   */
  void turnLeft(int n);

  /**
   * putCoin defined times
   * @param n defines Repetitions
   */
  void putCoin(int n);

  /**
   * pickCoin defined times
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

package h04;

public interface RepetitiveRobot {
  void move(int n);
  void turnLeft(int n);
  void putCoin(int n);
  void pickCoin(int n);

  int getMoveRepetitions();
  int getTurnLeftRepetitions();
  int getputCoinRepetitions();
  int getpickCoinRepetitions();
}

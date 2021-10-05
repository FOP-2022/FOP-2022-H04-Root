package H04;

import fopbot.*;

public class RobotWithNaturalCoordinatesAndClockDirection extends Robot implements WithNaturalCoordinates, WithClockDirection{

  private int clockDirection;

  public RobotWithNaturalCoordinatesAndClockDirection(Direction direction) {
    super(0, 0, direction, 0);

    switch(direction) {
      case UP: clockDirection = 12; break;
      case RIGHT: clockDirection = 3; break;
      case DOWN: clockDirection = 6; break;
      case LEFT: clockDirection = 9; break;
    }
  }

  @Override
  public void turnClockwise() {
    for(int i = 0; i < 3; i++)
      turnLeft();
    clockDirection = clockDirection == 9 ? 12 : (clockDirection + 3) % 12;
  }

  @Override
  public void turnCounterClockwise() {
    turnLeft();
    clockDirection = clockDirection == 3 ? 12 : clockDirection - 3;
  }

  @Override
  public int getClockDirection() {
    return clockDirection;
  }

  @Override
  public void setX(int x) {
    super.setX(x > 0 ? x : -x);
  }

  @Override
  public void setY(int y) {
    super.setY(y > 0 ? y : -y);
  }




}

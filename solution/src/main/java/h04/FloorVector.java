package h04;

public class FloorVector implements WithNaturalCoordinates {

  private double x;
  private double y;
  private double z;

  private Axis firstAxis;
  private Axis secondAxis;

  public FloorVector(double x) {
    this.x = x;
    y = 3.14;
    z = 2.71;
  }

  public double getRealX() {
    return x;
  }

  public void setRealX(double x) {
    this.x = x;
  }

  public double getRealY() {
    return y;
  }

  public void setRealY(double y) {
    this.y = y;
  }

  public double getRealZ() {
    return z;
  }

  public void setRealZ(double z) {
    this.z = z;
  }

  public Axis getFirstAxis() {
    return firstAxis;
  }

  public void setFirstAxis(Axis firstAxis) {
    this.firstAxis = firstAxis;
  }

  public Axis getSecondAxis() {
    return secondAxis;
  }

  public void setSecondAxis(Axis secondAxis) {
    this.secondAxis = secondAxis;
  }

  private int getValueForAxis(Axis axis) {
    switch (axis) {
      case X:
        return (int) x;
      case Y:
        return (int) y;
      case Z:
        return (int) z;
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public int getX() {
    return getValueForAxis(firstAxis);
  }

  @Override
  public int getY() {
    return getValueForAxis(secondAxis);
  }

  private void setValueForAxis(Axis axis, int value) {
    switch (axis) {
      case X:
        x = value;
        break;
      case Y:
        y = value;
        break;
      case Z:
        z = value;
        break;
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public void setX(int x) {
    setValueForAxis(firstAxis, x);
  }

  @Override
  public void setY(int y) {
    setValueForAxis(secondAxis, y);
  }
}

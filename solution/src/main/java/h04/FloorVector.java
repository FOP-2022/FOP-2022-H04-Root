package h04;

public class FloorVector implements WithNaturalCoordinates{

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

  @Override
  public int getX() {
    switch (firstAxis) {
      case X: return (int)x;
      case Y: return (int)y;
      case Z: return (int)z;
    }
    return -1;
  }

  @Override
  public int getY() {
    switch (secondAxis) {
      case X: return (int)x;
      case Y: return (int)y;
      case Z: return (int)z;
    }
    return -1;
  }

  @Override
  public void setX(int x) {
    switch (firstAxis) {
      case X: setRealX(x); break;
      case Y: setRealY(x); break;
      case Z: setRealZ(x); break;
    }

  }

  @Override
  public void setY(int y) {
    switch (secondAxis) {
      case X: setRealX(y); break;
      case Y: setRealY(y); break;
      case Z: setRealZ(y); break;
    }
  }



}

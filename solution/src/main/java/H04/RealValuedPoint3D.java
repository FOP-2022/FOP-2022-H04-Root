package H04;

public class RealValuedPoint3D implements WithNaturalCoordinates{

  private double realX;
  private double realY;
  private double realZ;

  private CoordinatesChoice3D firstChoice;
  private CoordinatesChoice3D secondChoice;

  public RealValuedPoint3D(double realX) {
    this.realX = realX;
    realY = 3.14;
    realZ = 2.71;
  }

  public double getRealX() {
    return realX;
  }

  public void setRealX(double realX) {
    this.realX = realX;
  }

  public double getRealY() {
    return realY;
  }

  public void setRealY(double realY) {
    this.realY = realY;
  }

  public double getRealZ() {
    return realZ;
  }

  public void setRealZ(double realZ) {
    this.realZ = realZ;
  }

  public CoordinatesChoice3D getFirstChoice() {
    return firstChoice;
  }

  public void setFirstChoice(CoordinatesChoice3D firstChoice) {
    this.firstChoice = firstChoice;
  }

  public CoordinatesChoice3D getSecondChoice() {
    return secondChoice;
  }

  public void setSecondChoice(CoordinatesChoice3D secondChoice) {
    this.secondChoice = secondChoice;
  }

  @Override
  public int getX() {
    switch (firstChoice) {
      case REAL_X: return (int)getRealX();
      case REAL_Y: return (int)getRealY();
      case REAL_Z: return (int)getRealZ();
    }
    return -1;
  }

  @Override
  public int getY() {
    switch (secondChoice) {
      case REAL_X: return (int)getRealX();
      case REAL_Y: return (int)getRealY();
      case REAL_Z: return (int)getRealZ();
    }
    return -1;
  }

  @Override
  public void setX(int x) {
    switch (firstChoice) {
      case REAL_X: setRealX(x); break;
      case REAL_Y: setRealY(x); break;
      case REAL_Z: setRealZ(x); break;
    }

  }

  @Override
  public void setY(int y) {
    switch (secondChoice) {
      case REAL_X: setRealX(y); break;
      case REAL_Y: setRealY(y); break;
      case REAL_Z: setRealZ(y); break;
    }
  }



}

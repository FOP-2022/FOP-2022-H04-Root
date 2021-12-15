package h04;

public class FloorVector implements WithNaturalCoordinates {

    private double x;
    private double y;
    private double z;

    private Axis firstAxis;
    private Axis secondAxis;

    /**
     * Constructor of FloorVector, which sets y=3.14, z=2.71 & x to the attribute value
     * @param x to set the attribute
     */
    public FloorVector(double x) {
        this.x = x;
        y = 3.14;
        z = 2.71;
    }

    /**
     * @return the value of x
     */
    public double getRealX() {
        return x;
    }

    /**
     * set the value of x
     * @param x the x to set
     */
    public void setRealX(double x) {
        this.x = x;
    }

    /**
     * @return the value of y
     */
    public double getRealY() {
        return y;
    }

    /**
     * set the value of y
     * @param y the y to set
     */
    public void setRealY(double y) {
        this.y = y;
    }

    /**
     * @return the value of z
     */
    public double getRealZ() {
        return z;
    }

    /**
     * set the value of z
     * @param z the z to set
     */
    public void setRealZ(double z) {
        this.z = z;
    }

    /**
     *
     * @return the value of firstAxis
     */
    public Axis getFirstAxis() {
        return firstAxis;
    }

    /**
     * set the value of firstAxis
     * @param firstAxis the Axis to set
     */
    public void setFirstAxis(Axis firstAxis) {
        this.firstAxis = firstAxis;
    }

    /**
     *
     * @return the value of secondAxis
     */
    public Axis getSecondAxis() {
        return secondAxis;
    }

    /**
     * set the value of secondAxis
     * @param secondAxis the Axis to set
     */
    public void setSecondAxis(Axis secondAxis) {
        this.secondAxis = secondAxis;
    }

    /**
     * Return x,y,z according to specified Axis
     * @param axis specified Axis to get value
     * @return value of the specified Axis
     */
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
        return Math.abs(getValueForAxis(firstAxis));
    }

    @Override
    public int getY() {
        return Math.abs(getValueForAxis(secondAxis));
    }

    /**
     * Set x,y,z according to specified Axis
     * @param axis specified Axis to set value
     * @param value specified value to set
     */
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

package h04;

import fopbot.*;

public class RepetitiveRobotImpl extends Robot implements WithNaturalCoordinates, RepetitiveRobot {

    private int moveRepetitions = 0;
    private int turnLeftRepetitions = 0;
    private int pickCoinRepetitions = 0;
    private int putCoinRepetitions = 0;

    /**
     * Constructor of RepetitiveRobotImpl, which drops specified amount of Coins
     * @param n Number of Coins to put at the beginning
     */
    public RepetitiveRobotImpl(int n) {
        super(0, 0, Direction.UP, 100);
        putCoin(n);
    }

    @Override
    public void setX(int x) {
        super.setX(x > 0 ? x : -x);
    }

    @Override
    public void setY(int y) {
        super.setY(y > 0 ? y : -y);
    }

    @Override
    public void move(int n) {
        if (n < 0) {
            crash();
        }

        for (int i = 0; i < n; i++) {
            move();
        }

        moveRepetitions += n;
    }

    @Override
    public void turnLeft(int n) {
        if (n < 0) {
            crash();
        }

        for (int i = 0; i < n; i++) {
            turnLeft();
        }

        turnLeftRepetitions += n;
    }

    @Override
    public void putCoin(int n) {
        if (n < 0) {
            crash();
        }

        for (int i = 0; i < n; i++) {
            putCoin();
        }

        putCoinRepetitions += n;
    }

    @Override
    public void pickCoin(int n) {
        if (n < 0) {
            crash();
        }

        for (int i = 0; i < n; i++) {
            pickCoin();
        }

        pickCoinRepetitions += n;
    }

    @Override
    public int getMoveRepetitions() {
        return moveRepetitions;
    }

    @Override
    public int getTurnLeftRepetitions() {
        return turnLeftRepetitions;
    }

    @Override
    public int getPutCoinRepetitions() {
        return putCoinRepetitions;
    }

    @Override
    public int getPickCoinRepetitions() {
        return pickCoinRepetitions;
    }
}

package com.skdgt.calculator.shapes;

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    public String draw() {
        return this.getClass().getName();
    }
}

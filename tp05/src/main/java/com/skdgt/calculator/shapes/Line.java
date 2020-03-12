package com.skdgt.calculator.shapes;

public class Line implements BasicShape {
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Line(double length) {
        this.length = length;
    }

    public String draw() {
        return "com.skdgt.calculator.shapes.Line";
    }
}

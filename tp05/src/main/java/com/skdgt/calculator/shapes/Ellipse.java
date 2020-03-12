package com.skdgt.calculator.shapes;

public class Ellipse implements Shape {
    private double xRadius;
    private double yRadius;

    public Ellipse(double xRadius, double yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public double getxRadius() {
        return xRadius;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public void setyRadius(double yRadius) {
        this.yRadius = yRadius;
    }

    public double getArea() {
        return Math.PI * xRadius * yRadius;
    }

    public String draw() {
        return this.getClass().getName();
    }
}

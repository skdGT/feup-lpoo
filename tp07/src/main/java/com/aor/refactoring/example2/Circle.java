package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(this.x, this.y, this.radius);
    }
}

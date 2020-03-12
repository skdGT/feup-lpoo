public class Ellipse extends Shape {
    private int xRadius;
    private int yRadius;

    public Ellipse(int xRadius, int yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public int getxRadius() {
        return xRadius;
    }

    public void setxRadius(int xRadius) {
        this.xRadius = xRadius;
    }

    public int getyRadius() {
        return yRadius;
    }

    public void setyRadius(int yRadius) {
        this.yRadius = yRadius;
    }
}

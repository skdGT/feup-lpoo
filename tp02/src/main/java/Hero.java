public class Hero {
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        this.x -= 1;
    }

    public void moveRight() {
        this.x += 1;
    }

    public void moveUp() {
        this.y -= 1;
    }

    public void moveDown() {
        this.y += 1;
    }
}

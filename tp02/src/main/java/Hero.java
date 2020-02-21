import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import javafx.geometry.Pos;

public class Hero extends Element{

    private Stamina stamina;

    /** Creates an hero on position x y on the screen**/
    public Hero(int x, int y) {
        super(x, y);
        this.stamina = new Stamina();
    }

    public void hit(int value) {
        stamina.decreaseStamina(value);
    }

    public boolean isAlive() {
        return stamina.getStamina() != 0;
    }

    public void drawStamina(TextGraphics graphics, int width) {
        this.stamina.draw(graphics, width);
    }

    public Position moveLeft() {
        return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
    }

    public Position moveRight() {
        return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
    }

    public Position moveUp() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
    }
}

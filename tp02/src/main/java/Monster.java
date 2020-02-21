import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
    }


    public Position move() {
        Random random = new Random();
        int i = random.nextInt(4);
        Position position = super.getPosition();

        switch (i) {
            case 0:
                position = new Position(super.getPosition().getX() + 1, super.getPosition().getY());
                break;
            case 1:
                position = new Position(super.getPosition().getX() - 1, super.getPosition().getY());
                break;
            case 2:
                position = new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
                break;
            case 3:
                position = new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
                break;
        }
        return position;
    }
}

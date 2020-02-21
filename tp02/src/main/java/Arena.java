import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private Hero hero = new Hero(10, 10);

    /** method to draw on the screen **/
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        hero.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        return (position.getX() < this.width && position.getX() >= 0 &&
                position.getY() < this.height && position.getY() >= 0);
    }


    public void moveHero(Position pos) {
        if (canHeroMove(pos)) {
            hero.setPosition(pos);
        }
    }

    /** Processes a key from the input buffer **/
    public int processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case Character:
                // returns 1 to close screen
                if (key.getCharacter() == 'q') {
                    return 1;
                }
                break;

            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
        }
        return 0;
    }

}

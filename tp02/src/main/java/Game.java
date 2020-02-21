import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private Screen screen;

    Hero hero = new Hero(10, 10);

    /** Default Game ctor - initializes the screen terminal **/
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            // this.screen.clear();
            // this.screen.setCharacter(10, 10, new TextCharacter('X'));
            // this.screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** method to draw on the screen **/
    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(hero.getPosition().getX(), hero.getPosition().getY(), new TextCharacter('X'));
        screen.refresh();
    }

    /** method to move the X on the screen **/
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);

            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
        }
    }

    public void moveHero(Position pos) {
        hero.setPosition(pos);
    }

    /** Processes a key from the input buffer **/
    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case Character:
                if (key.getCharacter() == 'q') {
                    screen.close();
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
    }

}

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.skdgt.hero.arena.Arena;
import com.skdgt.hero.drawables.DrawArena;
import com.skdgt.hero.drawables.Drawable;

import java.io.IOException;
import java.util.Objects;

public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private Arena arena;
    private DrawArena drawArena;

    /** Default Game ctor - initializes the screen terminal **/
    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            this.graphics = screen.newTextGraphics();

            this.arena = new Arena(20,50, 10);
            this.drawArena = new DrawArena(graphics,"#92a8d1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /** method to draw on the screen **/
    private void draw() throws IOException {
        screen.clear();
        drawArena.draw(arena);
        screen.refresh();
    }

    /** method to move the X on the screen **/
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);

            if (key.getKeyType() == KeyType.EOF) {
                screen.close();
                break;
            }
        }
    }

    /** Processes a key from the input buffer **/
    private void processKey(KeyStroke key) throws IOException {
        if (arena.processKey(key) == 1) {
            screen.close();
        }
    }
}

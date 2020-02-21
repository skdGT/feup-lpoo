import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Stamina {

    private int stamina;

    public Stamina() {
        this.stamina = 100;
    }

    public void decreaseStamina(int value) {
        stamina -= value;
    }

    public int getStamina() {
        return stamina;
    }

    public void draw(TextGraphics graphics, int width) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(width + 3, 4), new TerminalSize(9, 2), ' ');

        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(width + 4, 4), "STAMINA");
        graphics.putString(new TerminalPosition(width + 6, 5), String.valueOf(stamina));
    }
}

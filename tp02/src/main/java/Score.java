import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Score {
    private int score;
    private int coinValue;

    public Score() {
        this.score = 0;
        this.coinValue = 5;
    }

    public void increaseScore() {
        this.score += this.coinValue;
    }

    public int getScore() {
        return score;
    }

    public void draw(TextGraphics graphics, int width) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(width + 3, 1), new TerminalSize(7, 2), ' ');

        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(width + 4, 1), "SCORE");
        graphics.putString(new TerminalPosition(width + 4, 2), String.valueOf(score));
    }
}

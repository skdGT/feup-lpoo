package com.skdgt.hero.drawables;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.skdgt.hero.arena.Arena;
import com.skdgt.hero.arena.Coin;
import com.skdgt.hero.arena.Monster;

import java.util.List;

public class DrawCoins implements Drawable {
    private String color;
    private TextGraphics graphics;

    public DrawCoins(TextGraphics graphics, String color) {
        this.color = color;
        this.graphics = graphics;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(Arena arena) {
        for (Coin coin : arena.getCoins()) {
            graphics.setForegroundColor(TextColor.Factory.fromString(color));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), "O");
        }
    }
}

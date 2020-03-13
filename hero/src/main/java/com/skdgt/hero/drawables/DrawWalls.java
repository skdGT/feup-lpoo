package com.skdgt.hero.drawables;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.skdgt.hero.arena.Arena;
import com.skdgt.hero.arena.Wall;

import java.util.List;

public class DrawWalls implements Drawable {
    private TextGraphics graphics;
    private String color;

    public DrawWalls(TextGraphics graphics, String color) {
        this.graphics = graphics;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(Arena arena) {
        for (Wall wall : arena.getWalls()) {
            graphics.setForegroundColor(TextColor.Factory.fromString(color));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), "#");
        }
    }
}

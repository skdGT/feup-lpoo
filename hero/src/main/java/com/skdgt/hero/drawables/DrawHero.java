package com.skdgt.hero.drawables;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.skdgt.hero.arena.Arena;
import com.skdgt.hero.arena.Hero;

public class DrawHero implements Drawable {
    private TextGraphics graphics;
    private String color;

    public DrawHero(TextGraphics graphics, String color) {
        this.graphics = graphics;
        this.color = color;
    }

    @Override
    public void draw(Arena arena) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(arena.getHero().getPosition().getX(), arena.getHero().getPosition().getY()), "X");
    }
}

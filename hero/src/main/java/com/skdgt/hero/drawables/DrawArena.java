package com.skdgt.hero.drawables;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.skdgt.hero.arena.Arena;

public class DrawArena implements Drawable {
    private String color;
    private TextGraphics graphics;
    private Drawable walls, monsters, hero, coins;

    public DrawArena(TextGraphics graphics, String color) {
        this.color = color;
        this.graphics = graphics;

        this.walls = new DrawWalls(graphics, "#FF0000");
        this.monsters = new DrawMonsters(graphics, "#000000");
        this.hero = new DrawHero(graphics, "#00ff00");
        this.coins = new DrawCoins(graphics, "#ffff00");
    }

    @Override
    public void draw(Arena arena) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');

        walls.draw(arena);
        monsters.draw(arena);
        hero.draw(arena);
        coins.draw(arena);
    }
}

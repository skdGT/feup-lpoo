package com.skdgt.hero.arena;

import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;
    private int numCoins;
    private int score;

    private Hero hero;
    private List<Coin> coins;
    private List<Wall> walls;
    private List<Monster> monsters;

    public Hero getHero() {
        return hero;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public Arena(int height, int width, int numCoins) {
        this.height = height;
        this.width = width;
        this.numCoins = numCoins;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.hero = new Hero(new Position(10, 10), 100);
        this.score = 0;
    }

    private void moveHero(String move) {
        switch (move) {
            case "up":
                if (hero.getPosition().getY() > 1)
                    hero.moveUp();
                break;
            case "down":
                if (hero.getPosition().getY() < this.height - 2)
                    hero.moveDown();
                break;
            case "left":
                if (hero.getPosition().getX() > 1)
                    hero.moveLeft();
                break;
            case "right":
                if (hero.getPosition().getX() < this.width - 2)
                    hero.moveRight();
                break;
            default:
                break;
        }

        moveMonsters();

        if (coinCollision(hero.getPosition())) {
            this.score += 5;
            this.numCoins--;
            this.coins = createCoins();
        }
        if (monsterCollision(hero.getPosition())) {
            this.hero.changeHealth(-25);
        }

        this.hero.isAlive();
    }


    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position position;
            do {
                position = monster.move();
                if (position == null) {
                    return;
                }
            } while (wallCollision(position) || coinCollision(position) ||
                    position.getX() < 1 || position.getX() > width - 2 ||
                    position.getY() < 1 || position.getY() > height - 2);

            monster.setPosition(position);
        }
    }

    private boolean wallCollision(Position position) {
        for (Wall wall : this.walls) {
            if (wall.getPosition().equals(position))
                return true;
        }
        return false;
    }

    private boolean monsterCollision(Position position) {
        for (Monster monster : this.monsters) {
            if (monster.getPosition().equals(position))
                return true;
        }
        return false;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall( new Position(width - 1, r)));
        }

        return walls;
    }

    private boolean coinCollision(Position position) {
        for (Coin coin : this.coins) {
            if (coin.getPosition().equals(position))
                return true;
        }
        return false;
    }


    /** Method to create random coins around the arena **/
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < numCoins; i++)
            coins.add(new Coin(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1), 5));
        return coins;
    }

    /** Method to create random monsters around the arena **/
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int x, y;
        for (int i = 0; i < 10; i++) {
            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;

            // This allows the algorithm to skip a position that has been
            // already filled
            while (coinCollision(new Position(x, y))) {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }

            monsters.add(new Monster(new Position(x, y), 25));
        }
        return monsters;
    }

    public int processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case Character:
                // returns 1 to close screen
                if (key.getCharacter() == 'q') {
                    return 1;
                }
                break;

            case ArrowLeft:
                moveHero("left");
                break;
            case ArrowRight:
                moveHero("right");
                break;
            case ArrowUp:
                moveHero("up");
                break;
            case ArrowDown:
                moveHero("down");
                break;
        }
        return 0;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

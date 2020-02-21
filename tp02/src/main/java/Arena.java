import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private Score score;

    public boolean alive;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.score = new Score();
        this.alive = true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int x, y;
        for (int i = 0; i < 5; i++) {
            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;

            while (coinCollision(new Position(x, y))) {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }

            monsters.add(new Monster(x, y));
        }
        return monsters;
    }

    /** method to draw on the screen **/
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        score.draw(graphics, this.width, this.height);

        for (Wall wall : walls) {
            wall.draw(graphics);
        }

        for (Coin coin : coins) {
            coin.draw(graphics);
        }

        for (Monster monster : monsters) {
            monster.draw(graphics);
        }

        hero.draw(graphics);
    }

    // Collision detection for walls - returns true if collision detected
    private boolean wallCollision(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private boolean monsterCollision(Position position) {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private boolean coinCollision(Position position) {
        // Collision detection for coins
        boolean foundCoin = false;

        List<Coin> newCoins = new ArrayList<>();
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                Random random = new Random();
                Position coinPosition;
                do {
                    coinPosition = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                } while (monsterCollision(coinPosition) || hero.getPosition().equals(coinPosition));

                newCoins.add(new Coin(coinPosition.getX(), coinPosition.getY()));

                foundCoin = true;
            } else {
                newCoins.add(coin);
            }
        }
        this.coins = newCoins;

        return foundCoin;
    }


    private boolean canHeroMove(Position position) {
        if (coinCollision(position)) {
            this.score.increaseScore();
        }
        if (monsterCollision(position)) {
            System.out.println("GAME OVER!\n");
            System.out.printf("Score %d\n", this.score.getScore());
            this.alive = false;
        }
        return !wallCollision(position);
    }


    public void moveHero(Position pos) {
        if (canHeroMove(pos)) {
            hero.setPosition(pos);
            for (Monster monster : monsters) {
                Position monsterPosition;
                do {
                    monsterPosition = monster.move();
                } while (wallCollision(monsterPosition) || coinCollision(monsterPosition));
                monster.setPosition(monsterPosition);
            }
        }
        if (monsterCollision(pos)) {
            gameOver();
        }
    }


    public void gameOver() {
        System.out.println("GAME OVER!\n");
        System.out.printf("Score %d\n", this.score);
        this.alive = false;
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

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
    private int width;              // arena width
    private int height;             // arena height
    private Hero hero;              // our hero
    private List<Wall> walls;       // list with all the walls to be printed
    private List<Coin> coins;       // list with all the coins to be printed
    private List<Monster> monsters; // list with all the monsters to be printed
    private Score score;            // our current score

    public boolean alive;           // is our hero still alive?


    public Arena(int width, int height) {
        this.hero = new Hero(10, 10);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.score = new Score();
        this.alive = true;
    }

    /** Method to create walls around the arena **/
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

    /** Method to create random coins around the arena **/
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 7; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
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

            monsters.add(new Monster(x, y));
        }
        return monsters;
    }

    /** method to draw on the screen **/
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');


        for (Wall wall : walls) {           // draws all walls
            wall.draw(graphics);
        }

        for (Coin coin : coins) {           // draws all coins
            coin.draw(graphics);
        }

        for (Monster monster : monsters) {  // draws all monsters
            monster.draw(graphics);
        }

        score.draw(graphics, this.width);   // draws the score
        hero.drawStamina(graphics, width);  // draws our hero's stamina
        hero.draw(graphics);                // draws our hero himself
    }

    /** Collision detection for walls - returns true if collision detected **/
    private boolean wallCollision(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    /** Collision detection for monsters **/
    private boolean monsterCollision(Position position) {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    /** Collision detection for coins **/
    private boolean coinCollision(Position position) {
        // Collision detection for coins
        boolean foundCoin = false;

        List<Coin> newCoins = new ArrayList<>();
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                Random random = new Random();
                Position coinPosition;

                /*
                    This do-while allows us to create a random coin and allows us to
                    prevent a collision situation with a monster or our hero

                    TODO - Find a way to prevent a Coin from spawning in another Coin's Position
                 */
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

    /** Method to determine whether our hero can or not move **/
    private boolean canHeroMove(Position position) {
        if (coinCollision(position)) {
            this.score.increaseScore();
        }
        if (monsterCollision(position)) {
            hero.hit(25);
            if (!hero.isAlive())
                gameOver();
        }
        return !wallCollision(position);
    }

    /** Move our hero if moving is possible **/
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
            hero.hit(25);
            if (!hero.isAlive())
                gameOver();
        }
    }

    /** Game Over method to print some info to the console **/
    public void gameOver() {
        System.out.println("GAME OVER!\n");
        System.out.printf("Score: %d\n", this.score.getScore());
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

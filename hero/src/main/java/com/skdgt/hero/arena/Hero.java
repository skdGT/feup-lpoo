package com.skdgt.hero.arena;

public class Hero extends Element implements Movable{
    private int health;


    public Hero(Position position, int health) {
        super(position);

        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void moveUp() {
        super.position = super.position.up();
    }

    public void moveDown() {
        super.position = super.position.down();
    }

    public void moveRight() {
        super.position = super.position.right();
    }

    public void moveLeft() {
        super.position = super.position.left();
    }

    public void changeHealth(int value) {
        this.health += value;
    }

    public boolean isAlive() {
        return health <= 0;
    }
}

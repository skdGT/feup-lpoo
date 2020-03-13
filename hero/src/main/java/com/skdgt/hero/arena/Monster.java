package com.skdgt.hero.arena;

import java.util.Random;

public class Monster extends Element implements Movable, Cloneable {
    private int power;

    public Monster(Position position, int power) {
        super(position);

        this.power = power;
    }

    @Override
    public void moveDown() {
        for (int i = 0; i < power / 25; i++) {
            super.position = super.position.down();
        }
    }

    @Override
    public void moveUp() {
        for (int i = 0; i < power / 25; i++) {
            super.position = super.position.up();
        }
    }

    @Override
    public void moveRight() {
        for (int i = 0; i < power / 25; i++) {
            super.position = super.position.right();
        }
    }

    @Override
    public void moveLeft() {
        for (int i = 0; i < power / 25; i++) {
            super.position = super.position.left();
        }
    }

    public int getPower() {
        return power;
    }

    public Position move() {
        Random random = new Random();
        int choice = random.nextInt(4);
        Monster clone;
        try {
            clone = (Monster) this.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        switch (choice) {
            case 0:
                clone.moveDown();
                break;
            case 1:
                clone.moveUp();
                break;
            case 2:
                clone.moveLeft();
                break;
            case 3:
                clone.moveRight();
                break;
        }

        return clone.getPosition();
    }

    public void setPower(int power) {
        this.power = power;
    }
}

package com.skdgt.hero.arena;

public class Element {
    protected Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Element(Position position) {
        this.position = position;
    }
}

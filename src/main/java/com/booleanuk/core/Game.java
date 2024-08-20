package com.booleanuk.core;

public class Game {
    public String name;

    // TODO: Is this correct with empty constructor?
    public Game() {}

    public Game(String name) {
        this.name = name;
    }

    public String start() {
        return "Playing " + this.name;
    }
}

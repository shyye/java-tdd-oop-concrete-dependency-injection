package com.booleanuk.core;

import java.util.ArrayList;

public class Computer {
    public ArrayList<Game> installedGames = new ArrayList<>();
    private PowerSupply poewerSupply;
    private Game game;

    public Computer(PowerSupply poewerSupply, Game gameClass) {
        this.poewerSupply = poewerSupply;
        this.game = gameClass;
    }

    public Computer(PowerSupply poewerSupply, ArrayList<Game> preInstalled, Game gameClass) {

        // TODO: is this correct or is the original Game class used here instead?

        this.poewerSupply = poewerSupply;
        this.game = gameClass;
        for (Game game : preInstalled) {
            installGame(game.name);
        }
    }

    public void turnOn() {
        this.poewerSupply.turnOn();
    }

    public void installGame(String gameName) {
        this.game = new Game(gameName);
        this.installedGames.add(game);
    }

    public String playGame(String gameName) {
        for (Game g : this.installedGames) {
            if (g.name.equals(gameName)) {
                return g.start();
            }
        }

        return "Game not installed";
    }
}

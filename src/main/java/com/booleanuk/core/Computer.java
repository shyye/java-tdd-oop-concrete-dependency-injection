package com.booleanuk.core;

import java.util.ArrayList;

public class Computer {
    public ArrayList<Game> installedGames = new ArrayList<>();
    private PowerSupply poewerSupply;

    public Computer(PowerSupply poewerSupply) {
        this.poewerSupply = poewerSupply;
    }

    public Computer(PowerSupply poewerSupply, ArrayList<Game> preInstalled) {
        this.poewerSupply = poewerSupply;
        for (Game game : preInstalled) {
            installGame(game.name);
        }
    }

    public void turnOn() {
        this.poewerSupply.turnOn();
    }

    public void installGame(String gameName) {
        Game game = new Game(gameName);
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

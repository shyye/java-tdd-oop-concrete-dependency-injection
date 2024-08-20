package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComputerTest {
    @Test
    public void shouldTurnOn() {
        PowerSupply myPsu = new PowerSupply();
        // TODO:
        //  Is it right to initialize the class like this?
        //  Or can we pass in a class without initialize it?
        Computer myPc = new Computer(myPsu, new Game());
        myPc.turnOn();

        Assertions.assertTrue(myPsu.isOn);
    }

    @Test
    public void shouldInstallGames() {
        PowerSupply myPsu = new PowerSupply();
        Computer myPc = new Computer(myPsu, new Game());

        myPc.installGame("Final Fantasy XI");

        Assertions.assertEquals(1, myPc.installedGames.size());
        Assertions.assertEquals("Final Fantasy XI", myPc.installedGames.get(0).name);
    }

    @Test
    public void shouldPlayGames() {
        PowerSupply myPsu = new PowerSupply();
        Computer myPc = new Computer(myPsu, new Game());

        myPc.installGame("Duck Game");
        myPc.installGame("Dragon's Dogma: Dark Arisen");

        Assertions.assertEquals("Playing Duck Game", myPc.playGame("Duck Game"));
        Assertions.assertEquals("Playing Dragon's Dogma: Dark Arisen", myPc.playGame("Dragon's Dogma: Dark Arisen"));
        Assertions.assertEquals("Game not installed", myPc.playGame("Morrowind"));
    }

    @Test
    public void canPreinstallGames() {
        PowerSupply myPsu = new PowerSupply();
        ArrayList<Game> preInstalled = new ArrayList<>(){{
            add(new Game("Dwarf Fortress"));
            add(new Game("Baldur's Gate"));
        }};

        Computer myPc = new Computer(myPsu, preInstalled, new Game());

        Assertions.assertEquals(2, myPc.installedGames.size());
        Assertions.assertEquals("Dwarf Fortress", myPc.installedGames.get(0).name);
        Assertions.assertEquals("Baldur's Gate", myPc.installedGames.get(1).name);
    }
}

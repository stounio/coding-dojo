package com.dojo.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<GameListener> listeners = new ArrayList<GameListener>();
    protected boolean hasWon = false;
    private Grid grid;

    public Game() {
        grid = new Grid();
    }

    public void registerListener(GameListener gameListener) {
        listeners.add(gameListener);
    }

    public boolean hasWon() {
        return hasWon;
    }

    public Grid getGrid() {
        return grid;
    }
}

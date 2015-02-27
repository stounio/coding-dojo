package com.dojo.tictactoe;


public class GameListener {
    private Session session;

    public GameListener(Session session, Game game) {
        this.session = session;
        game.registerListener(this);
    }

    public void finished(Game game) {
        if(game.hasWon()){
            session.increaseScore();
        }
    }
}
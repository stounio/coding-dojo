package com.dojo.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SessionTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = new Session("A SIGN");
    }

    @Test
    public void shouldStartANewGame() throws Exception {
        session.newGame();
        assertNotNull(getCurrentGame());
    }

    @Test
    public void shouldIncrementTheScoreWhenHasWonTheGame() {
        session.newGame();
        assertEquals(0, session.getScore());
        winTheGame();
        assertEquals(1, session.getScore());
    }

    @Test
    public void shouldNotIncrementTheScoreWhenHasLostTheGame(){
        session.newGame();
        assertEquals(0, session.getScore());
        loseTheGame();
        assertEquals(0,session.getScore());
    }

    private void winTheGame() {
        getCurrentGame().endWithSuccess();
    }

    private void loseTheGame() {
        getCurrentGame().endWithLoss();
    }

    private GameMock getCurrentGame() {
        return new GameMock(session.newGame());
    }

    private class GameMock extends Game {

        private Game game;

        public GameMock(Game game) {
            super();
            this.game = game;
        }

        public void endWithSuccess() {
            game.hasWon = true;
            fireGameFinished();
        }

        public void endWithLoss() {
            fireGameFinished();
        }

        private void fireGameFinished() {
            for (GameListener listener : game.listeners) {
                listener.finished(game);
            }
        }
    }
}

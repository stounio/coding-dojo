package com.dojo.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static com.dojo.tictactoe.TicTacToe.CROSS;
import static com.dojo.tictactoe.TicTacToe.RING;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        ticTacToe = TicTacToe.newTicTacToe();
    }

    @Test
    public void shouldBeAbleToCreateANewTicTacToeGame() {
        assertNotNull(ticTacToe);
    }

    @Test
    public void shouldUseCrossAsTheDefaultSign() {
        assertEquals(CROSS, ticTacToe.chosenSign());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotLetTheUserEnterANullSign(){
        ticTacToe.chooseSign(null);
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldOnlySupportsCrossAndRingSigns() {
        ticTacToe.chooseSign("Z");
    }

    @Test
    public void shouldModifyTheChosenSignWithTheOneSpecified() {
        ticTacToe.chooseSign(RING);
        assertEquals(RING, ticTacToe.chosenSign());
    }

    @Test
    public void shouldStartANewSessionWithACurrentScoreEqualsToZero(){
        Session session = ticTacToe.newSession();
        assertEquals(0, session.getScore());
    }

    @Test
    public void shouldGiveAccessToTheCurrentSessionOnceAnewSessionIsCreated(){
        assertNotNull(ticTacToe.newSession());
    }

    @Test
    public void shouldReturnAnEmptyGridWhenStartANewSession(){
        Session session = ticTacToe.newSession();
        Grid grid = session.newGame().getGrid();
        assertTrue(grid.isEmpty());
    }

    @Test
    public void shouldUseTheChosenSignDuringTheSession(){
        ticTacToe.chooseSign(RING);
        ticTacToe.newSession();
        Session session = ticTacToe.newSession();
        Assert.assertEquals(RING, session.getUserSign());
    }
}

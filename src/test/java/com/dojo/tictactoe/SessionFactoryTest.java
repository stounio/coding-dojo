package com.dojo.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static com.dojo.tictactoe.TicTacToe.newTicTacToe;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SessionFactoryTest {

    private TicTacToe ticTacToe;
    private Session session;

    @Before
    public void setUp() throws Exception {
        ticTacToe = newTicTacToe();
        session = SessionFactory.getInstance().createSession(ticTacToe);
    }

    @Test
    public void shouldCreateANewSessionForTicTacToe() throws Exception {
        assertNotNull(session);
    }

    @Test
    public void shouldUseTheChosenSignProvidedByTicTacToe() {
        assertEquals(ticTacToe.chosenSign(), session.getUserSign());
    }


}

package com.dojo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void shouldReturnTheGridUsedByTheGame() throws Exception {
        Game game = new Game();
        Grid grid = game.getGrid();
        Assert.assertNotNull(grid);
    }
}

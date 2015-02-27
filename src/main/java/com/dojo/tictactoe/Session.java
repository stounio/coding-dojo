package com.dojo.tictactoe;

class Session {
    private String sign;
    private int score;

    Session(String sign) {
        this.sign = sign;
    }

    public int getScore() {
        return score;
    }

    public String getUserSign() {
        return sign;
    }

    public Game newGame() {
        Game game = new Game();
        new GameListener(this, game);
        return game;
    }

    public void increaseScore() {
        score++;
    }
}

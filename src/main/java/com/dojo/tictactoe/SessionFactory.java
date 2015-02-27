package com.dojo.tictactoe;

class SessionFactory {

    private static SessionFactory factory = new SessionFactory();

    public static SessionFactory getInstance(){
        return factory;
    }

    public Session createSession(TicTacToe ticTacToe) {
        return new Session(ticTacToe.chosenSign());
    }
}
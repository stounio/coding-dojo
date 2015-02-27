package com.dojo.tictactoe;

import java.security.InvalidParameterException;

public class TicTacToe {
    public static final String CROSS = "X";
    public static final String RING = "O";
    private String sign = CROSS;

    static TicTacToe newTicTacToe() {
        return new TicTacToe();
    }

    public String chosenSign() {
        return sign;
    }

    public void chooseSign(String sign) {
        if(sign==null){
            throw new IllegalArgumentException("sign must not be null");
        }
        if (!CROSS.equals(sign) && !RING.equals(sign)) {
            throw new InvalidParameterException("Unsupported sign: " + sign);
        }
        this.sign = sign;
    }

    public Session newSession() {
        return SessionFactory.getInstance().createSession(this);
    }
}

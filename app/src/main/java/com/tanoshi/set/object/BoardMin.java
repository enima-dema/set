package com.tanoshi.set.object;

import java.util.Arrays;

public class BoardMin {
    CardMin[] board;

    public BoardMin(CardMin[] board) {
        this.board = board;
    }

    public CardMin[] getBoard() {
        return board;
    }

    public void setBoard(CardMin[] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "ServiceBoard [board=" + Arrays.toString(board) + "]";
    }
}

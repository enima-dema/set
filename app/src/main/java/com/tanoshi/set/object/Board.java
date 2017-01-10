package com.tanoshi.set.object;

import java.util.Arrays;

public class Board {
	Card[] board;

	public Board(Card[] board) {
		this.board = board;
	}

	public Card[] getBoard() {
		return board;
	}

	public void setBoard(Card[] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "ServiceBoard [board=" + Arrays.toString(board) + "]";
	}
}

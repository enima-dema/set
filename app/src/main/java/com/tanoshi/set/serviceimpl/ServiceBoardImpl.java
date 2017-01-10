package com.tanoshi.set.serviceimpl;

import com.tanoshi.set.object.Board;
import com.tanoshi.set.object.Card;
import com.tanoshi.set.service.ServiceBoard;

public class ServiceBoardImpl implements ServiceBoard {
	ServiceCardImpl sci;
	
	public ServiceBoardImpl() {
		sci = new ServiceCardImpl();
	}

	@Override
	public Card getCard(Board board, int index) {
		return board.getBoard()[index];
	}
	
	@Override
	public Board dispatchCard(int size) {
		Card[] cards = new Card[size];
		for (int i = 0; i < cards.length; i++){
			cards[i] = sci.generateCard();
		}
		return new Board(cards);
	}

	@Override
	public Board reDispatchCard(Board board){
		return null;
	}

	@Override
	public Board deleteCard(Board board, int i) {
		Card[] cards = board.getBoard();
		cards[i] = null;
		board.setBoard(cards);
		return board;
	}

	@Override
	public Board addCard(Board board, int i, Card card) {
		Card[] cards = board.getBoard();
		cards[i] = card;
		board.setBoard(cards);
		return board;
	}

}

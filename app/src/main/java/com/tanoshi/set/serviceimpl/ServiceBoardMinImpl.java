package com.tanoshi.set.serviceimpl;

import com.tanoshi.set.object.Board;
import com.tanoshi.set.object.BoardMin;
import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.CardMin;
import com.tanoshi.set.service.ServiceBoard;
import com.tanoshi.set.service.ServiceBoardMin;

public class ServiceBoardMinImpl implements ServiceBoardMin {
	ServiceCardMinImpl sci;

	public ServiceBoardMinImpl() {
		sci = new ServiceCardMinImpl();
	}

	@Override
	public CardMin getCard(BoardMin board, int index) {
		return board.getBoard()[index];
	}
	
	@Override
	public BoardMin dispatchCard(int size) {
		CardMin[] cards = new CardMin[size];
		for (int i = 0; i < cards.length; i++){
			cards[i] = sci.generateCard();
		}
		return new BoardMin(cards);
	}

	@Override
	public BoardMin deleteCard(BoardMin board, int i) {
		CardMin[] cards = board.getBoard();
		cards[i] = null;
		board.setBoard(cards);
		return board;
	}

	@Override
	public BoardMin addCard(BoardMin board, int i, CardMin card) {
		CardMin[] cards = board.getBoard();
		cards[i] = card;
		board.setBoard(cards);
		return board;
	}

}

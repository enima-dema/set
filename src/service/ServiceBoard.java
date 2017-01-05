package service;

import object.Board;
import object.Card;

public interface ServiceBoard {
	public Board dispatchCard(int size);
	
	public Card getCard(Board board, int index);
	
	public Board deleteCard(Board board,int i);
	
	public Board addCard(Board board, int i, Card card);
}

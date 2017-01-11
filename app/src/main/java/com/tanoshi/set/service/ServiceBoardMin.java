package com.tanoshi.set.service;

import com.tanoshi.set.object.Board;
import com.tanoshi.set.object.BoardMin;
import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.CardMin;

public interface ServiceBoardMin {
    BoardMin dispatchCard(int size);

    CardMin getCard(BoardMin board, int index);

    BoardMin deleteCard(BoardMin board, int i);

    BoardMin addCard(BoardMin board, int i, CardMin card);
}

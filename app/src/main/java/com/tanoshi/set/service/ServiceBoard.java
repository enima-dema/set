package com.tanoshi.set.service;

import com.tanoshi.set.object.Board;
import com.tanoshi.set.object.Card;

public interface ServiceBoard {
    Board dispatchCard(int size);

    Card getCard(Board board, int index);

    Board deleteCard(Board board, int i);

    Board addCard(Board board, int i, Card card);
}

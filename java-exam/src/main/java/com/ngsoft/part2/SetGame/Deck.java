package com.ngsoft.part2.SetGame;

import com.ngsoft.part2.SetGame.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Deck {
    void reset();

    void shuffle();

    List<Card> deal(int qty);

    int size();
}

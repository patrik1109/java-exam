package com.ngsoft.part2.SetGame;

import com.ngsoft.part2.SetGame.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GamePlayImpl implements GamePlay {
    @Autowired
    Deck deck;

    @Autowired
    GameRules gameRules;

    @Autowired
    GameResult gameResult;

    List<Card> revealedCards;

    @Override
    public void start() {
        deck.reset();
        deck.shuffle();
        revealedCards = deck.deal(12);
    }

    @Override
    public List<Card> revealedCards() {
        return revealedCards;
    }

    @Override
    public boolean play(int card1, int card2, int card3) {
        List<Card> cardSet = new ArrayList<>();
        cardSet.add(revealedCards.get(card1));
        cardSet.add(revealedCards.get(card2));
        cardSet.add(revealedCards.get(card3));

        if (gameRules.isSet(cardSet)) {
            gameResult.increasereult();
            gameResult.sets.addAll(cardSet);
            revealedCards.removeAll(cardSet);
            getMoreCards();
            return true;
        } else {
            gameResult.reduceresult();
            return false;
        }
    }

    @Override
    public int getScore() {
        return gameResult.getScore();
    }

    @Override
    public boolean getMoreCards() {
        if (deck.size() >= 3) {
            List<Card> addCards = deck.deal(3);
            if (addCards != null) {
                revealedCards.addAll(addCards);
                return true;
            }
        }
        return false;
    }

    //method only for tests using!!
    public void putSetIntoRelivedCards(List<Card> cardList, int indestart) {
        revealedCards.addAll(indestart, cardList);
    }

    public Deck getDeck() {
        return deck;
    }
}

package com.ngsoft.part2.SetGame;

import com.ngsoft.part2.SetGame.entity.Card;
import com.ngsoft.part2.SetGame.entity.CardFeatures;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeckImpl implements Deck {

    public ArrayList<Card> getCards() {
        return cards;
    }

    private ArrayList<Card> cards;


    public DeckImpl() {
        this.cards = (ArrayList) filldeck();
    }

    @Override
    public void reset() {
        this.cards = (ArrayList) filldeck();
    }

    @Override
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            Card tmpcard = cards.get(i);
            int randindex = (int) (Math.random() * (80 - 1)) + 1;
            cards.set(i, cards.get(randindex));
            cards.set(randindex, tmpcard);
        }
    }

    @Override
    public List<Card> deal(int qty) {
        ArrayList<Card> result;
        if (cards.size() < qty) {
            result = null;
        } else if (cards.size() == qty) {
            result = new ArrayList<Card>(cards);
            cards.clear();
            return result;
        } else {
            int from = (cards.size() - qty - 1);
            int to = (cards.size() - 1);
            result = new ArrayList<Card>(cards.subList(from, to));
            cards.removeAll((ArrayList) result);
        }
        return result;
    }

    @Override
    public int size() {
        return cards.size();
    }

    private List<Card> filldeck() {
        List<Card> cardList = new ArrayList<>();
        for (CardFeatures.Color color : CardFeatures.Color.values()) {
            for (CardFeatures.Shape shape : CardFeatures.Shape.values()) {
                for (CardFeatures.ItemCount count : CardFeatures.ItemCount.values()) {
                    for (CardFeatures.Texture texture : CardFeatures.Texture.values()) {
                        Card card = new Card(shape, color, count, texture);
                        cardList.add(card);
                    }
                }
            }
        }
        return cardList;
    }
}

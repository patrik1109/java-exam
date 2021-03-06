package com.ngsoft.part2.SetGame;

import com.ngsoft.part2.SetGame.entity.Card;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameRulesImpl implements GameRules {
    @Override
    public boolean isSet(Collection<Card> cards) {
        if (cards.size() != 3 || cards == null) {
            return false;
        }

        List<Card> list = cards.stream().limit(3).collect(toList());
        Card card1 = list.get(0);
        Card card2 = list.get(1);
        Card card3 = list.get(2);

        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }

        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                card1.getItemCount().equals(card2.getItemCount()) && card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                !card1.getTexture().equals(card2.getTexture()) && !card2.getTexture().equals(card3.getTexture()) && !card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (card1.getColor().equals(card2.getColor()) && card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                !card1.getShape().equals(card2.getShape()) && !card2.getShape().equals(card3.getShape()) && !card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        if (!card1.getColor().equals(card2.getColor()) && !card2.getColor().equals(card3.getColor()) && !card1.getColor().equals(card3.getColor()) &&
                !card1.getItemCount().equals(card2.getItemCount()) && !card2.getItemCount().equals(card3.getItemCount()) && !card1.getItemCount().equals(card3.getItemCount()) &&
                card1.getShape().equals(card2.getShape()) && card1.getShape().equals(card3.getShape()) &&
                card1.getTexture().equals(card2.getTexture()) && card1.getTexture().equals(card3.getTexture())) {
            return true;
        }
        return false;

    }
}

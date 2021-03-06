package com.ngsoft.part2.SetGameTests;

import com.ngsoft.part2.SetGame.Deck;
import com.ngsoft.part2.SetGame.DeckImpl;
import com.ngsoft.part2.SetGame.entity.Card;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")

public class DeckTests {

    @Autowired
    private Deck deck;

    final int DECK_SIZE = 81;
    final int DEAL_SIZE = 12;

    @Test
    // @Order(1)
    public void A_DECK_HAS_81_CARDS() {
        int size = deck.size();
        Deck decktmp = new DeckImpl();
        assertEquals(DECK_SIZE, deck.size());
    }


    @Test

    public void ALL_CARDS_ARE_DIFFERENT_IN_DECK() {
        HashSet<Card> cardsSet = new HashSet<>(((DeckImpl) deck).getCards());
        assertEquals(deck.size(), cardsSet.size());
    }

    @Test

    public void DEAL_SELECT_RETURNS_REQUIRED_AMOUT_OF_CARDS_FROM_DECK() {
        List<Card> getCards = deck.deal(DEAL_SIZE);
        assertEquals(DEAL_SIZE, getCards.size());
    }

    @Test

    public void DEAL_REMOVES_DEALT_CARD_FROM_DECK() {
        List<Card> getCards = deck.deal(DEAL_SIZE);
        for (Card card : getCards) {
            assertFalse(((DeckImpl) deck).getCards().contains(card));
        }
        assertEquals(DECK_SIZE - DEAL_SIZE, deck.size());
    }

    @Test

    public void A_SHUFFLING_WORKS() {

        //....mmmm how do I test this? the requirement seems unmeasureable. probably should check on google....
        List<Card> unshuffled = ((DeckImpl) deck).getCards();
        deck.shuffle();
        List<Card> shuffled = ((DeckImpl) deck).getCards();
        assertTrue(unshuffled.containsAll(shuffled) && shuffled.containsAll(unshuffled));
    }


}

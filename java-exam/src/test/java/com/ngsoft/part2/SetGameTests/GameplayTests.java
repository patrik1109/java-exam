package com.ngsoft.part2.SetGameTests;

import com.ngsoft.part2.SetGame.Deck;
import com.ngsoft.part2.SetGame.GamePlay;
import com.ngsoft.part2.SetGame.GamePlayImpl;
import com.ngsoft.part2.SetGame.GameRules;
import com.ngsoft.part2.SetGame.entity.Card;
import com.ngsoft.part2.SetGame.entity.CardFeatures;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.ngsoft.part2.SetGame.entity.Card.createNew;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class GameplayTests {

    /**
     * Gameplay should be the main class to interact with the UX.
     * After starting new deck will be reset and shuffled.
     * 12 cards will be displayed on revealed cards list
     * Player may select a set of 3 cards by stating their index (0-11) within the revealed cards list
     * so there should probably be a method called play(int card1,int card2, int card3)
     * this method will return some sort of response object, stating whether success or not, what is the score,
     * the next 3 cards being dealt (that will be added to the revealed cards list), and whether the game is over)
     * How do I make the gameplay testable?
     */


    @Autowired
    private GamePlay gamePlay;

    @Autowired
    private Deck deck;

    @Autowired
    private GameRules rules;

    final int DEAL_SIZE = 12;

    //These are the tests I can think of, but feel free to add some more.....


    @Before
    public void setup() {
        gamePlay.start();
    }

    private List<Card> createSet() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(createNew(CardFeatures.Shape.DIAMOND, CardFeatures.Color.GREEN, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        cardList.add(createNew(CardFeatures.Shape.DIAMOND, CardFeatures.Color.PURPLE, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        cardList.add(createNew(CardFeatures.Shape.DIAMOND, CardFeatures.Color.BLUE, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        return cardList;
    }

    private List<Card> createNoSet() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(createNew(CardFeatures.Shape.DIAMOND, CardFeatures.Color.GREEN, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        cardList.add(createNew(CardFeatures.Shape.OVAL, CardFeatures.Color.PURPLE, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        cardList.add(createNew(CardFeatures.Shape.DIAMOND, CardFeatures.Color.BLUE, CardFeatures.ItemCount.ONE, CardFeatures.Texture.FULL));
        return cardList;
    }

    @Test
    public void WHEN_STARTING_12_CARDS_ARE_DEALT_FROM_DECK() {
        // gamePlay.start();
        assertEquals(DEAL_SIZE, gamePlay.revealedCards().size());
    }

    @Test
    public void CAN_SELECT_CARDS_AND_VERIFY() {
        boolean flag = rules.isSet(createSet());
        boolean falseflag = rules.isSet(createNoSet());
        assertTrue(flag);
        assertFalse(falseflag);
    }

    @Test
    public void IF_SELECTED_PROPER_SET_SCORE_IS_ENHANCED_BY_1() {
        int scoreDefore = gamePlay.getScore();
        gamePlay.play(1, 2, 3);
        int scoreAfter = gamePlay.getScore();
        assertNotEquals(scoreDefore, scoreAfter);
    }

    @Test
    public void IF_PROPER_SET_THEN_CARDS_ARE_REMOVED_FROM_REVEALED_LIST() {
        List<Card> cardsSet = createSet();
        ((GamePlayImpl) gamePlay).putSetIntoRelivedCards(cardsSet, 0);
        gamePlay.play(0, 1, 2);
        assertFalse(gamePlay.revealedCards().containsAll(cardsSet));
    }

    @Test
    public void IF_PROPER_SET_THEN_NEW_CARDS_ARE_DEALT_UNLESS_DECK_IS_EMPTY() {
        while (((GamePlayImpl) gamePlay).getDeck().size() > 0) {
            int sizeDeck = ((GamePlayImpl) gamePlay).getDeck().size();
            List<Card> cardsSet = createSet();
            ((GamePlayImpl) gamePlay).putSetIntoRelivedCards(cardsSet, 0);
            gamePlay.play(0, 1, 2);
            assertEquals(((GamePlayImpl) gamePlay).getDeck().size(), sizeDeck - 3);
        }
        assertEquals(((GamePlayImpl) gamePlay).getDeck().size(), 0);
    }

    @Test
    public void FAILED_SET_ATTEMPT_REDUCES_SCORE_BY_1() {
        int scoreDefore = gamePlay.getScore();
        List<Card> cardsSet = createNoSet();
        ((GamePlayImpl) gamePlay).putSetIntoRelivedCards(cardsSet, 0);
        gamePlay.play(0, 1, 2);
        int scoreAfter = gamePlay.getScore();
        assertEquals(scoreDefore - 1, scoreAfter);
    }
}

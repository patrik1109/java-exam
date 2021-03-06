package com.ngsoft.part2.SetGame;

import com.ngsoft.part2.SetGame.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    int score;
    List<Card> sets = new ArrayList<>();


    public void increasereult(){
        this.score++;
    }

    public void  reduceresult(){
        this.score--;
    }

    public GameResult() {
    }

    public GameResult(int score, List<Card> sets) {
        this.score = score;
        this.sets = sets;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Card> getSets() {
        return sets;
    }

    public void setSets(List <Card> sets) {
        this.sets = sets;
    }


}

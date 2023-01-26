package com.example.wonders;

import domain.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameControllerTest {
    @Test
    public void getScienceEffectDuringGame() {
        ProgressToken science = ProgressToken.Science;
        Card card = new Card(CardType.CardScienceLaw, CardBack.Alexandrie);
        GameController gameController = new GameController();
        boolean found = gameController.getScienceEffectDuringGame(science, card);
        assertTrue(found);
    }

    @Test
    public void canBuildPiece() {
    }

    @Test
    public void buidPiece() {
    }

    @Test
    public void buildPower() {
    }
}
package com.example.wonders;

import domain.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {
    @Test
    public void getScienceEffectDuringGame() {
        GameController gameController = new GameController();
        ProgressToken[] progressTokens = {ProgressToken.Science, ProgressToken.Propaganda, ProgressToken.Jewelry, ProgressToken.Urbanism, ProgressToken.ArtsAndCrafts};
        Card[] scienceCard = {new Card(CardType.CardScienceLaw, CardBack.Alexandrie), new Card(CardType.CardScienceMechanic, CardBack.Alexandrie), new Card(CardType.CardScienceArchitect, CardBack.Alexandrie)};
        Card[] warCard = {new Card(CardType.CardWar_archer, CardBack.Alexandrie), new Card(CardType.CardWar_barbarian, CardBack.Alexandrie)};
        Card[] materialGoldStone = {new Card(CardType.CardMaterialStone, CardBack.Alexandrie), new Card(CardType.CardMaterialGold, CardBack.Alexandrie)};
        Card[] materialWoodBrick = {new Card(CardType.CardMaterialWood, CardBack.Alexandrie), new Card(CardType.CardMaterialBrick, CardBack.Alexandrie)};
        Card[] materialPaperGlass = {new Card(CardType.CardMaterialPaper, CardBack.Alexandrie), new Card(CardType.CardMaterialGlass, CardBack.Alexandrie)};
        Card[] others = {new Card(CardType.CardPolitic_cat, CardBack.Alexandrie), new Card(CardType.CardPolitic_emperor, CardBack.Alexandrie), new Card(CardType.CardWar_centurion, CardBack.Alexandrie)};
        for (ProgressToken p :progressTokens) {
            for (Card i : others) {
                boolean found = gameController.getScienceEffectDuringGame(p, i);
                assertFalse(found);
            }
            switch (p) {
                case Urbanism:
                    for (Card i : scienceCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : warCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialGoldStone) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialPaperGlass) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialWoodBrick) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertTrue(found);
                    }
                    break;
                case ArtsAndCrafts:
                    for (Card i : scienceCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : warCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialGoldStone) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialPaperGlass) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertTrue(found);
                    }
                    for (Card i : materialWoodBrick) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    break;
                case Propaganda:
                    for (Card i : scienceCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : warCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertTrue(found);
                    }
                    for (Card i : materialGoldStone) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialPaperGlass) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialWoodBrick) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    break;
                case Jewelry:
                    for (Card i : scienceCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : warCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialGoldStone) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertTrue(found);
                    }
                    for (Card i : materialPaperGlass) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialWoodBrick) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    break;
                case Science:
                    for (Card i : scienceCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertTrue(found);
                    }
                    for (Card i : warCard) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialGoldStone) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialPaperGlass) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    for (Card i : materialWoodBrick) {
                        boolean found = gameController.getScienceEffectDuringGame(p, i);
                        assertFalse(found);
                    }
                    break;
            }
        }


    }

    @Test
    public void canBuildPiece() {
        GameController gameController = new GameController();

        ArrayList<ProgressToken> tokens = new ArrayList<>();
        Player tester = new Player("Tester", Wonder.Babylone, new Hand(), false, tokens);
        tester.getHand().addMaterials(0);
        tester.getHand().addMaterials(0);

        boolean canBuild = gameController.canBuildPiece(tester.getWonderContruction().getAllPieces().get(0), tester);
        assertFalse(canBuild);
        tester.getHand().addMaterials(3);
        canBuild = gameController.canBuildPiece(tester.getWonderContruction().getAllPieces().get(0), tester);
        assertTrue(canBuild);

        tokens.add(ProgressToken.Ingeniery);
        tester.getHand().addMaterials(0);
        boolean canBuildIngeniery = gameController.canBuildPiece(tester.getWonderContruction().getAllPieces().get(0), tester);
        assertTrue(canBuildIngeniery);

        canBuild = gameController.canBuildPiece(tester.getWonderContruction().getAllPieces().get(1), tester);
        assertTrue(canBuild);

    }

    @Test
    public void buildPiece() throws IOException {
        GameController gameController = new GameController();

        Player tester = new Player("Tester", Wonder.Halicarnasse, new Hand(), false, new ArrayList<>());
        tester.getHand().addMaterials(0);
        tester.getHand().addMaterials(3);
        boolean power = gameController.buildPiece(tester.getWonderContruction(), tester);
        assertFalse(power);

        gameController.buildPiece(tester.getWonderContruction(), tester);
        tester.getHand().addMaterials(0);
        tester.getHand().addMaterials(0);
        power = gameController.buildPiece(tester.getWonderContruction(), tester);
        assertTrue(power);

        ArrayList<ProgressToken> tokens = new ArrayList<>();
        tokens.add(ProgressToken.Ingeniery);
        Player tester2 = new Player("t2", Wonder.Gizeh, new Hand(), false, tokens);
        tester2.getHand().addMaterials(0);
        tester2.getHand().addMaterials(0);
        power = gameController.buildPiece(tester.getWonderContruction(), tester2);
        assertFalse(power);
    }
}
package com.example.wonders;

import domain.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EndScreenTest {

    @Test
    public void calculateFinalPoints() {
        EndScreen endScreen = new EndScreen();

        ArrayList<ProgressToken> p1Tokens = new ArrayList<>();
        p1Tokens.add(ProgressToken.Culture);
        p1Tokens.add(ProgressToken.Culture);
        p1Tokens.add(ProgressToken.Decoration);
        Player player1 = new Player("p1", Wonder.Gizeh, new Hand(), true, p1Tokens);
        for (ConstructionPiece i : player1.getWonderContruction().getAllPieces()) {
            i.isComplete();
        }

        Player player2 = new Player("p2", Wonder.Babylone, new Hand(), false, new ArrayList<>());
        player2.getHand().setMilitaryPoints(4);
        for (int i = 0; i < 3; i++) {
            player2.getWonderContruction().getAllPieces().get(i).isComplete();
        }

        Player player3 = new Player("p2", Wonder.Ephese, new Hand(), false, new ArrayList<>());
        for (int i = 0; i < 2; i++) {
            player3.getHand().setPointVictoire(0);
        }

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        assertEquals(players, endScreen.calculateFinalPoints(players));
    }
}
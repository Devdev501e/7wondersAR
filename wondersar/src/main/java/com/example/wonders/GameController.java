package com.example.wonders;

import domain.*;

import java.util.ArrayList;

public class GameController {
    private Player player;
    Actions actions = new Actions();

    public void startTurn(ArrayList<Player> players, CardDecks mainDeck, ArrayList<CardDecks> allPlayerDecks,
                          Conflict conflict, ProgressTokens res, int turn) {
        player = players.get(turn);

        ArrayList<CardDecks> options = actions.cardDecksOption(allPlayerDecks, turn);
        Card newCard = actions.cardChoice(options);
        player.addCard(newCard, conflict.getAllConflicts());
    }
}

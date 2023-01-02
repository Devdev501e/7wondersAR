package com.example.wonders;

import domain.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class GameController {
    @FXML
    private Button buttonMainDeck;
    @FXML
    private Button buttonLeftDeck;
    @FXML
    private Button buttonRightDeck;

    private Player player;
    Actions actions = new Actions();

    public void startTurn(ArrayList<Player> players, CardDecks mainDeck, ArrayList<CardDecks> allPlayerDecks,
                          Conflict conflict, ProgressTokens res, int turn) {
        player = players.get(turn);

        ArrayList<CardDecks> options = actions.cardDecksOption(allPlayerDecks, turn);

        //Card choice info
        buttonLeftDeck.setText(options.get(0).getCard(0).getFront().cardDisplayName
                + "("+options.get(0).cardDeckSize()+")");
        buttonRightDeck.setText(options.get(1).getCard(0).getFront().cardDisplayName +
                "("+options.get(1).cardDeckSize()+")");

        if (player.getChat()) {
            buttonMainDeck.setText(mainDeck.getCard(0).getFront().cardDisplayName);
        }
        else {
            buttonMainDeck.setText("Main Deck ("+mainDeck.cardDeckSize()+")");
        }
        Card newCard = actions.cardChoice(player, options, mainDeck);
        player.addCard(newCard, conflict.getAllConflicts());
    }
}

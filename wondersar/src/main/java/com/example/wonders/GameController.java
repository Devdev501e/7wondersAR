package com.example.wonders;

import domain.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GameController {
    @FXML
    private Button buttonMainDeck;
    @FXML
    private Button buttonLeftDeck;
    @FXML
    private Button buttonRightDeck;
    Card leftDeckCard;
    @FXML
    private final ImageView leftDeckCardImage = new ImageView();
    Card rightDeckCard;
    @FXML
    private final ImageView rightDeckCardImage = new ImageView();

    Card mainDeckCard;
    @FXML
    private final ImageView mainDeckImage = new ImageView();

    private Player player;
    private final Actions actions = new Actions();
    Conflict conflict;
    ArrayList<CardDecks> allAvailablePlayerDecks =new ArrayList<>();
    CardDecks mainCardDeck;
    CardDecks mainDeck;

    public void startTurn(ArrayList<Player> players,ArrayList<CardDecks> allPlayerDecks,
                          Conflict conflictTokens, ProgressTokens res, int turn) {
        player = players.get(turn);
        conflict = conflictTokens;
        for(int i=1;i<allPlayerDecks.size();i++){
            allAvailablePlayerDecks.add(allPlayerDecks.get(i));
            mainDeck=allPlayerDecks.get(i);
        }

        ArrayList<CardDecks> options = actions.cardDecksOption(allAvailablePlayerDecks, turn);

        //Card choice info
        leftDeckCard = options.get(0).getCard(0);
        Image leftDeckCardPNG = new Image(getClass().getResourceAsStream(leftDeckCard.front.imageResource));

        leftDeckCardImage.setImage(leftDeckCardPNG);
        //buttonLeftDeck.setGraphic(leftDeckCardImage);

        rightDeckCard = options.get(1).getCard(0);
        Image rightDeckCardPNG = new Image(getClass().getResourceAsStream(rightDeckCard.front.imageResource));

        rightDeckCardImage.setImage(rightDeckCardPNG);
       // buttonRightDeck.setGraphic(rightDeckCardImage);


        mainDeckCard = mainDeck.getCard(0);
        Image mainDeckFrontPNG = new Image(getClass().getResourceAsStream(mainDeckCard.front.imageResource));
        Image mainDeckBackPNG = new Image(getClass().getResourceAsStream(mainDeckCard.front.imageResource));   //j'ai mis front au lieu de back
        if (player.getChat()) {
            mainDeckImage.setImage(mainDeckFrontPNG);
           // buttonMainDeck.setGraphic(mainDeckImage);
        }
        else {
            mainDeckImage.setImage(mainDeckBackPNG);
           // buttonMainDeck.setGraphic(mainDeckImage);
        }
       Card newCard = actions.cardChoice(player, options, mainDeck);
        player.addCard(newCard, conflict.getAllConflicts());
    }

    public void onButtonLeftDeck() {
        player.addCard(leftDeckCard, conflict.getAllConflicts());
        allAvailablePlayerDecks.get(0).chooseCard();
    }

    public void onButtonRightDeck() {
        player.addCard(rightDeckCard, conflict.getAllConflicts());
        allAvailablePlayerDecks.get(1).chooseCard();
    }

    public void onButtonMainDeck() {
        player.addCard(mainDeckCard, conflict.getAllConflicts());
        mainCardDeck.chooseCard();
    }
}

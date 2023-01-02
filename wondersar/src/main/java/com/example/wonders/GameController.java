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
    private ImageView leftDeckCardImage = new ImageView();
    private ImageView rightDeckCardImage = new ImageView();
    private ImageView mainDeckImage = new ImageView();

    private Player player;
    private Actions actions = new Actions();


    public void startTurn(ArrayList<Player> players, CardDecks mainDeck, ArrayList<CardDecks> allPlayerDecks,
                          Conflict conflict, ProgressTokens res, int turn) {
        player = players.get(turn);

        ArrayList<CardDecks> options = actions.cardDecksOption(allPlayerDecks, turn);

        //Card choice info
        CardType leftDeckCard = options.get(0).getCard(0).front;
        Image leftDeckCardPNG = new Image(getClass().getResourceAsStream(leftDeckCard.imageResource));

        leftDeckCardImage.setImage(leftDeckCardPNG);
        buttonLeftDeck.setGraphic(leftDeckCardImage);

        CardType rightDeckCard = options.get(1).getCard(0).front;
        Image rightDeckCardPNG = new Image(getClass().getResourceAsStream(rightDeckCard.imageResource));

        rightDeckCardImage.setImage(rightDeckCardPNG);
        buttonRightDeck.setGraphic(rightDeckCardImage);

        Card mainDeckCard = mainDeck.getCard(0);
        Image mainDeckFrontPNG = new Image(getClass().getResourceAsStream(mainDeckCard.front.imageResource));
        Image mainDeckBackPNG = new Image(getClass().getResourceAsStream(mainDeckCard.back.imageResource));

        if (player.getChat()) {
            mainDeckImage.setImage(mainDeckFrontPNG);
            buttonMainDeck.setGraphic(mainDeckImage);
        }
        else {
            mainDeckImage.setImage(mainDeckBackPNG);
            buttonMainDeck.setGraphic(mainDeckImage);
        }
        Card newCard = actions.cardChoice(player, options, mainDeck);
        player.addCard(newCard, conflict.getAllConflicts());
    }

    public void onButtonLeftDeck() {

    }

    public void onButtonRightDeck() {

    }

    public void onButtonMainDeck() {

    }
}

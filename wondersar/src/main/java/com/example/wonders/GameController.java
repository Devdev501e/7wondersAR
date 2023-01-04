package com.example.wonders;

import domain.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    Card leftDeckCard;
    Card rightDeckCard;
    Card mainDeckCard;
    @FXML
    private Tab tab2 = new Tab();
    @FXML
    private ImageView mainDeckImage = new ImageView();
    @FXML
    private ImageView leftDeckCardImage = new ImageView();
    @FXML
    private ImageView rightDeckCardImage = new ImageView();
    @FXML
    private Label cardCountMain;
    @FXML
    private Label cardCountLeft;
    @FXML
    private Label cardCountRight;
    @FXML
    private Label playerName;

    private final Image mainDeckBackPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/cards/card-back/card-back-question.png")));

    private Player player;
    private final Actions actions = new Actions();
    Conflict conflict;
    ArrayList<CardDecks> options = new ArrayList<>();
    CardDecks mainDeck;


    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<CardDecks> allPlayerDecks, Conflict conflictList, int turn) {
        //initialize game
        player = players.get(turn);
        playerName.setText(player.getName());
        tab2.setText(player.getName());

        conflict = conflictList;
        mainDeck = mainCardDeck;

        options = actions.cardDecksOption(allPlayerDecks, turn);

        //Card choice info
        leftDeckCard = options.get(0).getCard(0);
        Image leftDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(leftDeckCard.front.imageResource)));
        leftDeckCardImage.setImage(leftDeckCardPNG);
        cardCountLeft.setText("Cards: "+options.get(0).cardDeckSize());


        rightDeckCard = options.get(1).getCard(0);
        Image rightDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(rightDeckCard.front.imageResource)));
        rightDeckCardImage.setImage(rightDeckCardPNG);
        cardCountRight.setText("Cards: "+options.get(1).cardDeckSize());

        mainDeckCard = mainDeck.getCard(0);
        Image mainDeckFrontPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(mainDeckCard.front.imageResource)));

        if (player.getChat()) {
            mainDeckImage.setImage(mainDeckFrontPNG);
        }
        else {
            mainDeckImage.setImage(mainDeckBackPNG);
        }
        cardCountMain.setText("Cards: "+mainDeck.cardDeckSize());
    }

    public void onButtonLeftDeck() {
        player.addCard(leftDeckCard, conflict.getAllConflicts());
        options.get(0).chooseCard();

        cardCountLeft.setText("Cards: "+options.get(0).cardDeckSize());
        for (Card i : player.getAllPlayerCards()) {
            System.out.println(i.front.cardDisplayName);
        }
    }

    public void onButtonRightDeck() {
        System.out.println("right");
        player.addCard(rightDeckCard, conflict.getAllConflicts());
        options.get(1).chooseCard();

        cardCountRight.setText("Cards: "+options.get(1).cardDeckSize());
        for (Card i : player.getAllPlayerCards()) {
            System.out.println(i.front.cardDisplayName);
        }
    }

    public void onButtonMainDeck() {
        player.getAllPlayerCards().add(mainDeckCard);
        mainDeck.chooseCard();

        cardCountMain.setText("Cards: "+mainDeck.cardDeckSize());
        for (Card i : player.getAllPlayerCards()) {
            System.out.println(i.front.cardDisplayName);
        }
    }
}

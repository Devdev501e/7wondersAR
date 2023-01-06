package com.example.wonders;

import domain.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    Card leftDeckCard;
    Card rightDeckCard;
    Card mainDeckCard;

    // --------------------------------------------table view
    @FXML
    private ImageView mainDeckImage = new ImageView();
    @FXML
    private ImageView leftDeckCardImage = new ImageView();
    @FXML
    private ImageView rightDeckCardImage = new ImageView();
    @FXML
    private Label cardCountMain;
    @FXML
    Label cardCountLeft;
    @FXML
    private Label cardCountRight;
    @FXML
    private Label playerName;
    @FXML
    private ChoiceBox<String> allPlayerNames;
    private final Image mainDeckBackPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/cards/card-back/card-back-question.png")));

    // --------------------------------------------player view
    @FXML
    private Tab tab2 = new Tab();
    @FXML
    private Label playerNameTab;
    @FXML
    private Rectangle playerHandOutline;
    @FXML
    private Label playerHand;
    @FXML
    private ImageView catImage = new ImageView();
    private Image catPNG = new Image(getClass().getResourceAsStream("images/tokens/token-cat.png"));
    @FXML
    private ImageView militaryImage = new ImageView();
    private Image militaryPNG = new Image(getClass().getResourceAsStream("images/tokens/token-3-laurel-points.png"));
    @FXML
    private Label militaryCount;
    @FXML
    private ImageView womanImage = new ImageView();
    @FXML
    private Label womanCount;
    @FXML
    private ImageView emperorImage = new ImageView();
    @FXML
    private Label emperorCount;
    @FXML
    private ImageView centurionImage = new ImageView();
    @FXML
    private Label centurionCount;
    @FXML
    private ImageView barbarianImage = new ImageView();
    @FXML
    private Label barbarianCount;
    @FXML
    private ImageView archerImage = new ImageView();
    @FXML
    private Label archerCount;
    @FXML
    private ImageView lawImage = new ImageView();
    @FXML
    private ImageView architectImage = new ImageView();
    @FXML
    private ImageView mechanicImage = new ImageView();
    @FXML
    private ImageView token1 = new ImageView();
    @FXML
    private ImageView token2 = new ImageView();
    @FXML
    private ImageView token3 = new ImageView();
    @FXML
    private ImageView token4 = new ImageView();
    @FXML
    private ImageView token5 = new ImageView();
    @FXML
    private ImageView token6 = new ImageView();
    @FXML
    private ImageView token7 = new ImageView();
    @FXML
    private ImageView token8 = new ImageView();
    @FXML
    private ImageView token9 = new ImageView();
    ImageView[] tokenImages = {token1, token2, token3, token4, token5, token6, token7, token8, token9};
    @FXML
    private ImageView stoneImage = new ImageView();
    @FXML
    private Label stoneCount;
    @FXML
    private ImageView goldImage = new ImageView();
    @FXML
    private Label goldCount;
    @FXML
    private ImageView paperImage = new ImageView();
    @FXML
    private Label paperCount;
    @FXML
    private ImageView woodImage = new ImageView();
    @FXML
    private Label woodCount;
    @FXML
    private ImageView glassImage = new ImageView();
    @FXML
    private Label glassCount;
    @FXML
    private ImageView brickImage = new ImageView();
    @FXML
    private Label brickCount;
    ImageView[] materialImages = {woodImage, paperImage, brickImage, stoneImage, glassImage, goldImage};
    Label[] materialLabels = {woodCount, paperCount, brickCount, stoneCount, glassCount, goldCount};

    //-------------------------------------------needed variables

    private Player player;
    private ArrayList<String> playerNames = new ArrayList<>();
    private final Actions actions = new Actions();
    Conflict conflict;
    ArrayList<CardDecks> options = new ArrayList<>();
    CardDecks mainDeck;

    ArrayList<Player> allPlayers = new ArrayList<>();


    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<CardDecks> allPlayerDecks, Conflict conflictList, int turn) {
        //initialize table game
        for (Player i : players) {
            playerNames.add(i.getName());
        }
        allPlayerNames.getItems().addAll(playerNames);
        allPlayers.addAll(players);
        player = players.get(turn);
        playerName.setText(player.getName());

        conflict = conflictList;
        mainDeck = mainCardDeck;

        options = actions.cardDecksOption(allPlayerDecks, turn);

        allPlayerNames.setOnAction(this::onPlayerNames);

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

        //set up tab2
        tab2.setText("None");
        playerNameTab.setText("No one selected yet ! Please use the choice box");
    }

    public void onPlayerNames(Event event) {
        String name = allPlayerNames.getValue();
        Player playerView = null;
        for (Player i : allPlayers) {
            if (i.getName().equals(name)) {
                playerView  = i;
                break;
            }
        }

        playerNameTab.setText(playerView.getName());
        tab2.setText(playerView.getName());
        playerHandOutline.setVisible(true);
        playerHand.setText(playerView.getName()+"'s Hand");
        //for cat image
        if (playerView.getChat()) {
            catImage.setImage(catPNG);
        }
        //for tokens image
        for (int i = 0; i < playerView.getAllTokens().size(); i++) {
            tokenImages[i].setImage(new Image(getClass().getResourceAsStream(playerView.getAllTokens().get(i).imageResource)));
        }
        //for military image
        if (playerView.getHand().getMilitaryPoints() != 0) {
            militaryImage.setImage(militaryPNG);
            if (playerView.getHand().getMilitaryPoints() > 1) {
                militaryCount.setText("x"+playerView.getHand().getMilitaryPoints()/3);
            }
        }
        //for material cards image
        for (int i = 0; i < 6; i++) {
            if (playerView.getHand().getMaterials()[i] != 0) {
                String imageLocation = "images/cards/card-material-";
                switch (i) {
                    case 0:
                        materialImages[0].setImage( new Image(getClass().getResourceAsStream(imageLocation+"wood.png")));
                        break;
                    case 1:
                        materialImages[1].setImage( new Image(getClass().getResourceAsStream(imageLocation+"paper.png")));
                        break;
                    case 2:
                        materialImages[2].setImage( new Image(getClass().getResourceAsStream(imageLocation+"brick.png")));
                        break;
                    case 3:
                        materialImages[3].setImage( new Image(getClass().getResourceAsStream(imageLocation+"stone.png")));
                        break;
                    case 4:
                        materialImages[4].setImage( new Image(getClass().getResourceAsStream(imageLocation+"glass.png")));
                        break;
                    case 5:
                        materialImages[5].setImage( new Image(getClass().getResourceAsStream(imageLocation+"gold.png")));
                        break;
                }
                materialLabels[i].setText("x"+playerView.getHand().getMaterials()[i]);
            }
        }
    }

    public void onButtonLeftDeck() {
        System.out.println(options.get(1));
        player.addCard(leftDeckCard, conflict.getAllConflicts());
        options.get(0).chooseCard();
        leftDeckCard = options.get(0).getCard(0);
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

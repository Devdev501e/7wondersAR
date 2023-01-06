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
    private Image lawPNG = new Image(getClass().getResourceAsStream("images/cards/card-progress-law.png"));
    @FXML
    private ImageView architectImage = new ImageView();
    private Image architectPNG = new Image(getClass().getResourceAsStream("images/cards/card-progress-architect.png"));
    @FXML
    private ImageView mechanicImage = new ImageView();
    private Image mechanicPNG = new Image(getClass().getResourceAsStream("images/cards/card-progress-mechanic.png"));
    private ImageView[] scienceImages = {lawImage, mechanicImage, architectImage};
    private Image[] sciencePNG = {lawPNG, mechanicPNG, architectPNG};
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
    private Image stonePNG = new Image(getClass().getResourceAsStream("images/cards/card-material-stone-stonecutter.png"));
    @FXML
    private Label stoneCount;
    @FXML
    private ImageView goldImage = new ImageView();
    private Image goldPNG = new Image(getClass().getResourceAsStream("images/cards/card-material-gold-vizir.png"));
    @FXML
    private Label goldCount;
    @FXML
    private ImageView paperImage = new ImageView();
    private Image paperPNG = new Image(getClass().getResourceAsStream("images/cards/card-material-paper-women.png"));
    @FXML
    private Label paperCount;
    @FXML
    private ImageView woodImage = new ImageView();
    private Image woodPNG = new Image(getClass().getResourceAsStream("images/cards/card-material-wood-lumberjack.png"));
    @FXML
    private Label woodCount;
    @FXML
    private ImageView glassImage = new ImageView();
    private Image glassPNG = new Image(getClass().getResourceAsStream("images/cards/card-material-glass-women.png"));
    @FXML
    private Label glassCount;
    @FXML
    private ImageView brickImage = new ImageView();
    private Image brickPNG = new Image(getClass().getResourceAsStream("images/cards/card-material-brick-women.png"));
    @FXML
    private Label brickCount;
    ImageView[] materialImages = {woodImage, paperImage, brickImage, stoneImage, glassImage, goldImage};
    Image[] materialPNG = {woodPNG, paperPNG, brickPNG, stonePNG, glassPNG, goldPNG};
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
                materialImages[i].setImage(materialPNG[i]);
                //materialLabels[i].setText("x"+playerView.getHand().getMaterials()[i]);
            }
        }

        //for science cards image
        for (int i = 0; i < 3; i++) {
            String imageLocation = "images/cards/card-progress-";
            if (playerView.getHand().getScience()[i] != 0) {
                scienceImages[i].setImage(sciencePNG[i]);
            }
        }
        int empCount = 0;
        int womCount = 0;
        int barbCount = 0;
        int centCount = 0;
        int archCount = 0;
        for (Card i : playerView.getAllPlayerCards()) {
            if (i.front.cardDisplayName.equals("politic:emperor")) {
                empCount++;
                emperorImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                emperorCount.setText("x"+empCount);
            }
            else if (i.front.cardDisplayName.equals("politic:cat")) {
                womCount++;
                womanImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                womanCount.setText("x"+womCount);
            }
            else if (i.front.cardDisplayName.equals("war:barbarian")) {
                barbCount++;
                barbarianImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                barbarianCount.setText("x"+barbCount);
            } else if (i.front.cardDisplayName.equals("war:centurion")) {
                centCount++;
                centurionImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                centurionCount.setText("x"+centCount);
            } else if (i.front.cardDisplayName.equals("war:archer")) {
                archCount++;
                architectImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                archerCount.setText("x"+archCount);
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

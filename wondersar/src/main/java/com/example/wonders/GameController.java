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
import java.util.Arrays;
import java.util.Objects;

public class GameController {
    Card leftDeckCard;
    Card rightDeckCard;
    Card mainDeckCard;

    // --------------------------------------------table view
    @FXML
    private ImageView mainDeckImage = new ImageView();
    @FXML
    private ImageView construction1;
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
    @FXML
    private Label playerLeftName;
    @FXML
    private Label playerLeftMaterial;
    @FXML
    private Label playerLeftScience;
    @FXML
    private Label playerLeftShields;
    @FXML
    private ImageView playerRightImage;
    @FXML
    private Label playerRightName;
    @FXML
    private Label playerRightMaterial;
    @FXML
    private Label playerRightScience;
    @FXML
    private Label playerRightShields;
    @FXML
    private ImageView combat1 = new ImageView();
    @FXML
    private ImageView combat2 = new ImageView();
    @FXML
    private ImageView combat3 = new ImageView();
    @FXML
    private ImageView combat4 = new ImageView();
    @FXML
    private ImageView combat5 = new ImageView();
    @FXML
    private ImageView combat6 = new ImageView();
    private ImageView[] combats = {combat1, combat2, combat3, combat4, combat5, combat6};
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
    private ImageView[] tokenImages = {token1, token2, token3, token4, token5, token6, token7, token8, token9};
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
    @FXML
    private Button endButton;

    //-------------------------------------------needed variables

    private Player player;
    private ArrayList<String> playerNames = new ArrayList<>();
    private final Actions actions = new Actions();
    Conflict conflict;
    ArrayList<CardDecks> options = new ArrayList<>();
    ArrayList<CardDecks> allDecks = new ArrayList<>();
    CardDecks mainDeck;
    private int playerTurn;

    ArrayList<Player> allPlayers = new ArrayList<>();

    public void cardDisable(boolean disable) {
        leftDeckCardImage.setDisable(disable);
        rightDeckCardImage.setDisable(disable);
        mainDeckImage.setDisable(disable);
    }


    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<CardDecks> allPlayerDecks, Conflict conflictList, int turn, boolean beg) {
        //initialize table game
        for (Player i : players) {
            playerNames.add(i.getName());
        }
        endButton.setDisable(true);
        cardDisable(false);
        if (beg) {
            allPlayerNames.getItems().addAll(playerNames);
            allPlayers.addAll(players);
            allDecks.addAll(allPlayerDecks);
        }


        player = players.get(turn);
        playerTurn = turn;
        playerName.setText(player.getName());

        conflict = conflictList;
        mainDeck = mainCardDeck;

        options = actions.cardDecksOption(allPlayerDecks, turn);

        allPlayerNames.setOnAction(this::onPlayerNames);

        for (int i = 0; i < conflictList.getAllConflicts().size(); i++) {
            if (conflictList.getAllConflicts().get(i)) {
                combats[i].setImage(new Image(getClass().getResourceAsStream("images/tokens/token-conflict-peace.png")));
            }
            else {
                combats[i].setImage(new Image(getClass().getResourceAsStream("images/tokens/token-conflict-war.png")));
            }
        }

        Player playerLeft;
        if (turn == 0) {
            playerLeft = players.get(players.size()-1);
        }
        else {
            playerLeft = players.get(turn-1);
        }
        playerLeftName.setText(""+playerLeft.getName());
        int totalMaterial = 0;
        for (int i : playerLeft.getHand().getMaterials()) {
            totalMaterial += i;
        }
        playerLeftMaterial.setText("Materials: "+totalMaterial);
        int totalScience = 0;
        for (int i : playerLeft.getHand().getScience()) {
            totalScience +=i;
        }
        playerLeftScience.setText("Science: "+totalScience);
        playerLeftShields.setText("Shields: "+playerLeft.getHand().getShieldWar());

        if (players.size() > 2) {
            Player playerRight;
            if (turn == players.size()-1) {
                playerRight = players.get(0);
            }
            else {
                playerRight = players.get(turn+1);
            }
            playerRightImage.setImage(new Image(getClass().getResourceAsStream("images/imagejeu/silhouette.png")));
            playerRightName.setText(""+playerRight.getName());
            totalMaterial = 0;
            for (int i : playerRight.getHand().getMaterials()) {
                totalMaterial += i;
            }
            playerRightMaterial.setText("Materials: "+totalMaterial);
            totalScience = 0;
            for (int i : playerRight.getHand().getScience()) {
                totalScience +=i;
            }
            playerRightScience.setText("Science: "+totalScience);
            playerRightShields.setText("Shields: "+playerRight.getHand().getShieldWar());
        }

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

        centurionImage.setImage(null);
        centurionCount.setText("");
        archerImage.setImage(null);
        archerCount.setText("");
        barbarianImage.setImage(null);
        barbarianCount.setText("");

        womanImage.setImage(null);
        catImage.setImage(null);
        womanCount.setText("");
        emperorImage.setImage(null);
        emperorCount.setText("");

        lawImage.setImage(null);
        architectImage.setImage(null);
        mechanicImage.setImage(null);

        woodImage.setImage(null);
        woodCount.setText("");
        paperImage.setImage(null);
        paperCount.setText("");
        brickImage.setImage(null);
        brickCount.setText("");
        stoneImage.setImage(null);
        stoneCount.setText("");
        glassImage.setImage(null);
        glassCount.setText("");
        goldImage.setImage(null);
        goldCount.setText("");

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
        switch (playerView.getWonder()){
            case Alexandrie:
                ConstImage constImage = ConstImage.AlexandrieBack;
                System.out.println(constImage.getCons1());
                Image cons1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons1())));

                construction1.setImage(cons1);

                break;
            case Babylone:
            case Rhodes:
            case Halicarnasse:
            case Gizeh:
            case Olympie:
            case Ephese:
        }
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
        //for cards
        int[] counts = new int[11];
        Arrays.fill(counts, 0);
        for (Card i : playerView.getAllPlayerCards()) {
            switch (i.front.cardDisplayName) {
                case "material:wood":
                    counts[0]++;
                    woodImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    woodCount.setText("x"+counts[0]);
                    break;
                case "material:paper":
                    counts[1]++;
                    paperImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    paperCount.setText("x"+counts[1]);
                    break;
                case "material:brick":
                    counts[2]++;
                    brickImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    brickCount.setText("x"+counts[2]);
                    break;
                case "material:stone":
                    counts[3]++;
                    stoneImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    stoneCount.setText("x"+counts[3]);
                    break;
                case "material:glass":
                    counts[4]++;
                    glassImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    glassCount.setText("x"+counts[4]);
                    break;
                case "material:gold":
                    counts[5]++;
                    goldImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    goldCount.setText("x"+counts[5]);
                    break;
                case "science:law":
                    lawImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    break;
                case "science:mechanic":
                    mechanicImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    break;
                case "science:architect":
                    architectImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    break;
                case "politic:emperor":
                    counts[6]++;
                    emperorImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    emperorCount.setText("x"+counts[6]);
                    break;
                case "politic:cat":
                    counts[7]++;
                    womanImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    catImage.setImage(catPNG);
                    womanCount.setText("x"+counts[7]);
                    break;
                case "war:barbarion":
                    counts[8]++;
                    barbarianImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    barbarianCount.setText("x"+counts[8]);
                    break;
                case "war:centurion":
                    counts[9]++;
                    centurionImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    centurionCount.setText("x"+counts[9]);
                    break;
                case "war:archer":
                    counts[10]++;
                    architectImage.setImage(new Image(getClass().getResourceAsStream(i.front.imageResource)));
                    archerCount.setText("x"+counts[10]);
                    break;
            }
        }

    }

    public void onButtonLeftDeck() {
        player.addCard(leftDeckCard, conflict.getAllConflicts());
        options.get(0).chooseCard();

        leftDeckCard = options.get(0).getCard(0);
        Image leftDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(leftDeckCard.front.imageResource)));
        leftDeckCardImage.setImage(leftDeckCardPNG);
        cardCountLeft.setText("Cards: "+options.get(0).cardDeckSize());

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onButtonRightDeck() {
        player.addCard(rightDeckCard, conflict.getAllConflicts());
        options.get(1).chooseCard();

        rightDeckCard = options.get(1).getCard(0);
        Image rightDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(rightDeckCard.front.imageResource)));
        rightDeckCardImage.setImage(rightDeckCardPNG);
        cardCountRight.setText("Cards: "+options.get(1).cardDeckSize());

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onButtonMainDeck() {
        player.getAllPlayerCards().add(mainDeckCard);
        mainDeck.chooseCard();

        mainDeckCard = mainDeck.getCard(0);
        Image mainDeckFrontPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(mainDeckCard.front.imageResource)));
        if (player.getChat()) {
            mainDeckImage.setImage(mainDeckFrontPNG);
        }
        else {
            mainDeckImage.setImage(mainDeckBackPNG);
        }
        cardCountMain.setText("Cards: "+mainDeck.cardDeckSize());

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onButtonEnd() {
        if (playerTurn == allPlayers.size()-1) {
            playerTurn = 0;
        }
        else {
            playerTurn++;
        }
        startTurn(allPlayers, mainDeck, allDecks, conflict, playerTurn, false);
    }
}
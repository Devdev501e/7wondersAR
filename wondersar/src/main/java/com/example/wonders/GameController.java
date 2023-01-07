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
    @FXML private ImageView construction1;
    @FXML private ImageView construction2;
    @FXML private ImageView construction3;
    @FXML private ImageView construction4;
    @FXML private ImageView construction5;

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
    private ArrayList<ImageView> combats = new ArrayList<>();
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
    private ArrayList<ImageView> tokenImages = new ArrayList<>();
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

    Image tokenPeace = new Image(getClass().getResourceAsStream("images/tokens/token-conflict-peace.png"));
    Image tokenWar = new Image(getClass().getResourceAsStream("images/tokens/token-conflict-war.png"));

    ArrayList<Player> allPlayers = new ArrayList<>();

    public void cardDisable(boolean disable) {
        leftDeckCardImage.setDisable(disable);
        rightDeckCardImage.setDisable(disable);
        mainDeckImage.setDisable(disable);
    }

    public void resetTokens() {
        switch (allPlayers.size()) {
            case 2:
            case 3:
                combat1.setImage(tokenPeace);
                combat2.setImage(tokenPeace);
                combat3.setImage(tokenPeace);
                combats.add(combat1);
                combats.add(combat2);
                combats.add(combat3);
                break;
            case 4:
                combat4.setImage(tokenPeace);
                combats.add(combat4);
                break;
            case 5:
                combat5.setImage(tokenPeace);
                combats.add(combat5);
                break;
            case 6:
            case 7:
                combat6.setImage(tokenPeace);
                combats.add(combat6);
                break;
        }
    }

    public void checkCardCorn(CardType card) {
        if (card.cardCategory == CardCategory.WarCard) {
            int count = 0;
            for (int i = 0; i < combats.size(); i++) {
                if (combats.get(i).getImage() == tokenPeace) {
                    combats.get(i).setImage(tokenWar);
                    count++;
                }
                if (count == card.cornCount) {
                    break;
                }
            }
            boolean battle = true;
            for (ImageView i : combats) {
                if (i.getImage() == tokenPeace) {
                    battle = false;
                    break;
                }
            }
            if (battle) {
                //call battle function
                resetTokens();
            }
        }
    }

    public void battle() {
        if (allPlayers.size() == 2) {
            if (allPlayers.get(0).getHand().getShieldWar() > 2*allPlayers.get(1).getHand().getShieldWar()) {
                allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+6);
            }
            else if (allPlayers.get(0).getHand().getShieldWar() > allPlayers.get(1).getHand().getShieldWar()) {
                allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+3);
            }
            else if (allPlayers.get(1).getHand().getShieldWar() > 2*allPlayers.get(0).getHand().getShieldWar()) {
                allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+6);
            }
            else if (allPlayers.get(1).getHand().getShieldWar() > allPlayers.get(0).getHand().getShieldWar()) {
                allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+3);
            }
        }
        else {
            for (int i = 0; i < allPlayers.size(); i++) {
                Player playerLeft = (i==0)? allPlayers.get(allPlayers.size()-1):allPlayers.get(i-1);
                Player interestingPlayer = allPlayers.get(i);
                Player playerRight = (i == allPlayers.size()-1)? allPlayers.get(0):allPlayers.get(i+1);

                if (interestingPlayer.getHand().getShieldWar() > playerLeft.getHand().getShieldWar()) {
                    interestingPlayer.getHand().setMilitaryPoints(interestingPlayer.getHand().getMilitaryPoints()+3);
                }
                if (interestingPlayer.getHand().getShieldWar() > playerRight.getHand().getShieldWar()) {
                    interestingPlayer.getHand().setMilitaryPoints(interestingPlayer.getHand().getMilitaryPoints()+3);
                }
            }
        }

        for (int j = 0; j < allPlayers.size(); j++) {
            ArrayList<Card> toRemove = new ArrayList<>();
            for (Card i : allPlayers.get(j).getAllPlayerCards()) {
                if ((i.front.cardDisplayName.equals("war:barbarian")) || (i.front.cardDisplayName.equals("war:archer"))) {
                    toRemove.add(i);
                }
            }
            allPlayers.get(j).getAllPlayerCards().removeAll(toRemove);
        }
    }

    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<CardDecks> allPlayerDecks, Conflict conflictList, int turn, boolean beggining) {
        //initialize table game
        for (Player i : players) {
            playerNames.add(i.getName());
        }
        endButton.setDisable(true);
        cardDisable(false);

        if (beggining) {
            allPlayerNames.getItems().addAll(playerNames);
            allPlayers.addAll(players);
            allDecks.addAll(allPlayerDecks);
            resetTokens();

            tokenImages.add(token1);
            tokenImages.add(token2);
            tokenImages.add(token3);
            tokenImages.add(token4);
            tokenImages.add(token5);
            tokenImages.add(token6);
            tokenImages.add(token7);
            tokenImages.add(token8);
            tokenImages.add(token9);
        }

        player = players.get(turn);
        playerTurn = turn;
        playerName.setText(player.getName());

        conflict = conflictList;
        mainDeck = mainCardDeck;

        options = actions.cardDecksOption(allPlayerDecks, turn);

        allPlayerNames.setOnAction(this::onPlayerNames);
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
        resetPlayerViewBlank();

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
                construction1.setLayoutX(309);
                construction1.setLayoutY(270);
                construction1.setFitWidth(200);
                construction1.setFitHeight(46);
                construction1.setX(0);
                construction1.setY(0);

                System.out.println(constImage.getCons2());
                Image cons2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons2())));
                construction2.setImage(cons2);
                construction2.setLayoutX(363);
                construction2.setLayoutY(226);
                construction2.setFitWidth(92);
                construction2.setFitHeight(52);
                construction2.setX(0);
                construction2.setY(0);

                System.out.println(constImage.getCons3());
                Image cons3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons3())));
                construction3.setImage(cons3);
                construction3.setLayoutX(362);
                construction3.setLayoutY(172);
                construction3.setFitWidth(96);
                construction3.setFitHeight(54);
                construction3.setX(0);
                construction3.setY(0);

                System.out.println(constImage.getCons4());
                Image cons4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons4())));
                construction4.setImage(cons4);
                construction4.setLayoutX(376);
                construction4.setLayoutY(118);
                construction4.setFitWidth(84);
                construction4.setFitHeight(56);
                construction4.setX(0);
                construction4.setY(0);

                System.out.println(constImage.getCons5());
                Image cons5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons5())));
                construction5.setImage(cons5);
                construction5.setLayoutX(386);
                construction5.setLayoutY(46);
                construction5.setFitWidth(206);
                construction5.setFitHeight(80);
                construction5.setX(0);
                construction5.setY(0);
                break;
            case Babylone:
                ConstImage constImageB = ConstImage.BabylonBack;
                System.out.println(constImageB.getCons1());
                Image cons1B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons1())));
                construction1.setImage(cons1B);
                construction1.setLayoutX(310);
                construction1.setLayoutY(225);
                construction1.setFitWidth(206);
                construction1.setFitHeight(38);
                construction1.setX(0);
                construction1.setY(0);
                construction1.setScaleX(1);
                construction1.setScaleY(1);
                construction1.setScaleZ(1);
                construction1.setPreserveRatio(true);

                System.out.println(constImageB.getCons2());
                Image cons2B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons2())));
                construction2.setImage(cons2B);
                construction2.setLayoutX(312);
                construction2.setLayoutY(184);
                construction2.setFitWidth(188);
                construction2.setFitHeight(43);
                construction2.setX(0);
                construction2.setY(0);
                construction2.setScaleX(1);
                construction2.setScaleY(1);
                construction2.setScaleZ(1);
                construction2.setPreserveRatio(true);

                System.out.println(constImageB.getCons3());
                Image cons3B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons3())));
                construction3.setImage(cons3B);
                construction3.setLayoutX(328);
                construction3.setLayoutY(148);

                construction3.setFitWidth(163);
                construction3.setFitHeight(38);
                construction3.setX(0);
                construction3.setY(0);
                construction3.setScaleX(1);
                construction3.setScaleY(1);
                construction3.setScaleZ(1);
                construction3.setPreserveRatio(true);

                System.out.println(constImageB.getCons4());
                Image cons4B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons4())));
                construction4.setImage(cons4B);
                construction4.setLayoutX(420);
                construction4.setLayoutY(100);
                construction4.setFitWidth(100);
                construction4.setFitHeight(60);
                construction4.setX(0);
                construction4.setY(0);
                construction4.setScaleX(1);
                construction4.setScaleY(1);
                construction4.setScaleZ(1);
                construction4.setPreserveRatio(true);

                System.out.println(constImageB.getCons5());
                Image cons5B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons5())));
                construction5.setImage(cons5B);
                construction5.setLayoutX(343);
                construction5.setLayoutY(80);
                construction5.setFitWidth(64);
                construction5.setFitHeight(71);
                construction5.setX(0);
                construction5.setY(0);
                construction5.setScaleX(1);
                construction5.setScaleY(1);
                construction5.setScaleZ(1);
                construction5.setPreserveRatio(true);
            case Rhodes:
            case Halicarnasse:
                ConstImage constImageH = ConstImage.Halicarnasse;
                System.out.println(constImageH.getCons1());
                Image cons1H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getCons1())));
                construction1.setImage(cons1H);
                construction1.setLayoutX(284);
                construction1.setLayoutY(281);
                construction1.setFitWidth(229);
                construction1.setFitHeight(27);
                construction1.setX(0);
                construction1.setY(0);

                System.out.println(constImageH.getCons2());
                Image cons2H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getCons2())));
                construction2.setImage(cons2H);
                construction2.setLayoutX(290);
                construction2.setLayoutY(221);
                construction2.setFitWidth(182);
                construction2.setFitHeight(61);
                construction2.setX(0);
                construction2.setY(0);

                System.out.println(constImageH.getCons3());
                Image cons3H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getCons3())));
                construction3.setImage(cons3H);
                construction3.setLayoutX(284);
                construction3.setLayoutY(158);
                construction3.setFitWidth(83);
                construction3.setFitHeight(81);
                construction3.setX(0);
                construction3.setY(0);

                System.out.println(constImageH.getCons4());
                Image cons4H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getCons4())));
                construction4.setImage(cons4H);
                construction4.setLayoutX(398);
                construction4.setLayoutY(158);
                construction4.setFitWidth(83);
                construction4.setFitHeight(81);
                construction4.setX(0);
                construction4.setY(0);

                System.out.println(constImageH.getCons5());
                Image cons5H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getCons5())));
                construction5.setImage(cons5H);
                construction5.setLayoutX(298);
                construction5.setLayoutY(60);
                construction5.setFitWidth(169);
                construction5.setFitHeight(98);
                construction5.setX(0);
                construction5.setY(0);
                break;
            case Gizeh:
            case Olympie:
            case Ephese:
        }
        if (playerView.getChat()) {
            catImage.setImage(catPNG);
        }
        //for tokens image
        for (int i = 0; i < playerView.getAllTokens().size(); i++) {
            tokenImages.get(i).setImage(new Image(getClass().getResourceAsStream(playerView.getAllTokens().get(i).imageResource)));
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
        checkCardCorn(leftDeckCard.front);

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
        checkCardCorn(rightDeckCard.front);

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
        checkCardCorn(mainDeckCard.front);

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

    public void resetPlayerViewBlank() {
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
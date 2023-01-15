package com.example.wonders;



import domain.*;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
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
    private final ArrayList<ImageView> combats = new ArrayList<>();

    @FXML
    private ImageView progress0 = new ImageView();
    @FXML
    private ImageView progress1 = new ImageView();
    @FXML
    private ImageView progress2 = new ImageView();
    private final ArrayList<ImageView> progressImages = new ArrayList<>();

    @FXML
    private Rectangle infoBoxOutline;
    @FXML
    private Label infoBoxLabel;
    @FXML
    private ChoiceBox<String> powerChoiceBox;

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
    private final Image catPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/tokens/token-cat.png")));
    @FXML
    private ImageView militaryImage = new ImageView();
    private final Image militaryPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/tokens/token-3-laurel-points.png")));
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
    private final ArrayList<ImageView> blueImages = new ArrayList<>();
    private final ArrayList<Label> blueLabels = new ArrayList<>();
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
    private final  ArrayList<ImageView> redImages = new ArrayList<>();
    private final ArrayList<Label> redLabels = new ArrayList<>();
    @FXML
    private ImageView lawImage = new ImageView();
    @FXML
    private ImageView architectImage = new ImageView();
    @FXML
    private ImageView mechanicImage = new ImageView();

    private final ArrayList<ImageView> scienceImages = new ArrayList<>();

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
    private final ArrayList<ImageView> tokenImages = new ArrayList<>();
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

    private final ArrayList<ImageView> materialImages = new ArrayList<>();
    private final ArrayList<Label> materialLabels = new ArrayList<>();
    @FXML
    private Button endButton;
    @FXML
    ImageView animationLeft;
    @FXML
    ImageView animationRight;


    //-------------------------------------------needed variables

    private Player player;
    private final ArrayList<String> playerNames = new ArrayList<>();
    ArrayList<CardDecks> options;
    CardDecks mainDeck;
    private int playerTurn;

    Image tokenPeace = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/tokens/token-conflict-peace.png")));
    Image tokenWar = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/tokens/token-conflict-war.png")));

    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<ProgressToken> res;
    private int countCards;
    private int countDraw;
    private int choice;
    @FXML
    private Button retour;
    ArrayList<String> cardChoices;
    ArrayList<String> cardDescription;

    boolean power;


    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<ProgressToken> progressTokens, int turn, boolean beggining) {
        //initialize table game
        countCards = 0;
        countDraw = 1;
        retour.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Back.css")).toExternalForm());
        options = new ArrayList<>();
        powerChoiceBox.setVisible(false);

        for (Player i : players) {
            playerNames.add(i.getName());
        }
        endButton.setDisable(true);
        infoBoxOutline.setVisible(false);
        infoBoxLabel.setText("");
        cardDisable(false);

        if (beggining) {
            players.get(turn).getAllTokens().add(ProgressToken.Ingeniery);
            allPlayerNames.getItems().addAll(playerNames);
            allPlayers.addAll(players);
            resetTokens();
            res = progressTokens;

            tokenImages.add(token1);
            tokenImages.add(token2);
            tokenImages.add(token3);
            tokenImages.add(token4);
            tokenImages.add(token5);
            tokenImages.add(token6);
            tokenImages.add(token7);
            tokenImages.add(token8);
            tokenImages.add(token9);

            progressImages.add(progress0);
            progressImages.add(progress1);
            progressImages.add(progress2);

            materialImages.add(woodImage);
            materialImages.add(paperImage);
            materialImages.add(brickImage);
            materialImages.add(stoneImage);
            materialImages.add(glassImage);
            materialImages.add(goldImage);

            materialLabels.add(woodCount);
            materialLabels.add(paperCount);
            materialLabels.add(brickCount);
            materialLabels.add(stoneCount);
            materialLabels.add(glassCount);
            materialLabels.add(goldCount);

            scienceImages.add(lawImage);
            scienceImages.add(mechanicImage);
            scienceImages.add(architectImage);

            blueImages.add(womanImage);
            blueImages.add(emperorImage);

            blueLabels.add(womanCount);
            blueLabels.add(emperorCount);

            redImages.add(centurionImage);
            redImages.add(barbarianImage);
            redImages.add(archerImage);

            redLabels.add(centurionCount);
            redLabels.add(barbarianCount);
            redLabels.add(archerCount);
        }

        player = players.get(turn);
        playerTurn = turn;
        playerName.setText(player.getName());

        player.setTokenIgnore(new ArrayList<>());

        options.add(player.getCardDecks());

        mainDeck = mainCardDeck;

        allPlayerNames.setOnAction(this::onPlayerNames);

        for (int i = 0; i < progressImages.size(); i++) {
            Image resImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(res.get(i).imageResource)));
            progressImages.get(i).setImage(resImage);
            progressImages.get(i).setDisable(true);
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
        if (players.size() == 2) {
            options.add(playerLeft.getCardDecks());
        }
        if (players.size() > 2) {
            Player playerRight;
            if (turn == players.size()-1) {
                playerRight = players.get(0);
            }
            else {
                playerRight = players.get(turn+1);
            }
            options.add(playerRight.getCardDecks());
            playerRightImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/silhouette.png"))));
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
        resetCardImage(0);
        resetCardImage(1);
        resetCardImage(2);
        resetPlayerViewBlank();

        //set up tab2
        tab2.setText("None");
        playerNameTab.setText("No one selected yet ! Please use the choice box");
    }

    public void onPlayerNames(Event event) {
        if (allPlayerNames.getValue()!=null) {
            String name = allPlayerNames.getValue();
            resetPlayerViewBlank();

            Player playerView = null;
            for (Player i : allPlayers) {
                if (i.getName().equals(name)) {
                    playerView  = i;
                    break;
                }
            }

            assert playerView != null;
            playerNameTab.setText(playerView.getName()+" "+" - "+playerView.getWonder().displayName);
            tab2.setText(playerView.getName());
            playerHandOutline.setVisible(true);
            playerHand.setText(playerView.getName()+"'s Hand");

            for (int i=0;i<5;i++) {
                System.out.println("NbPieces = "+i+" = "+playerView.getWonderContruction().getAllPieces().get(i).getNbPieces());
                System.out.println("Point = "+i+" = "+playerView.getWonderContruction().getAllPieces().get(i).getPoints());
                System.out.println("class = "+i+" = "+playerView.getWonderContruction().getAllPieces().get(i).getClass());
                System.out.println("equal = "+i+" = "+playerView.getWonderContruction().getAllPieces().get(i).getEqual());
            }

            //for wonder construction images
            switch (playerView.getWonder()){
                case Alexandrie:
                    ConstImage constImage = ConstImage.Alexandrie;
                    System.out.println(constImage.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1);
                    construction1.setLayoutX(330);
                    construction1.setLayoutY(272);
                    construction1.setFitWidth(190);
                    construction1.setFitHeight(35);


                    System.out.println(constImage.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2);
                    construction2.setLayoutX(373);
                    construction2.setLayoutY(230);
                    construction2.setFitWidth(95);
                    construction2.setFitHeight(44);


                    System.out.println(constImage.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3);
                    construction3.setLayoutX(373);
                    construction3.setLayoutY(171);
                    construction3.setFitWidth(85);
                    construction3.setFitHeight(58);


                    System.out.println(constImage.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4);
                    construction4.setLayoutX(386);
                    construction4.setLayoutY(136);
                    construction4.setFitWidth(59);
                    construction4.setFitHeight(51);

                    System.out.println(constImage.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5);
                    construction5.setLayoutX(394);
                    construction5.setLayoutY(64);
                    construction5.setFitWidth(64);
                    construction5.setFitHeight(71);

                    break;
                case Babylone:
                    ConstImage constImageB = ConstImage.Babylon;
                    System.out.println(constImageB.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1B);
                    construction1.setLayoutX(307);
                    construction1.setLayoutY(258);
                    construction1.setFitWidth(204);
                    construction1.setFitHeight(42);
                    construction1.setX(0);
                    construction1.setY(0);
                    construction1.setScaleX(1);
                    construction1.setScaleY(1);
                    construction1.setScaleZ(1);
                    construction1.setPreserveRatio(true);

                    System.out.println(constImageB.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2B);
                    construction2.setLayoutX(312);
                    construction2.setLayoutY(218);
                    construction2.setFitWidth(194);
                    construction2.setFitHeight(47);


                    System.out.println(constImageB.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3B);
                    construction3.setLayoutX(325);
                    construction3.setLayoutY(180);
                    construction3.setFitWidth(173);
                    construction3.setFitHeight(47);


                    System.out.println(constImageB.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4B);
                    construction4.setLayoutX(346);
                    construction4.setLayoutY(119);
                    construction4.setFitWidth(74);
                    construction4.setFitHeight(61);


                    System.out.println(constImageB.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5B);
                    construction5.setLayoutX(408);
                    construction5.setLayoutY(143);
                    construction5.setFitWidth(79);
                    construction5.setFitHeight(44);

                    break;
                case Rhodes:
                    ConstImage constImageR = ConstImage.Rhodes;
                    System.out.println(constImageR.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1R);
                    construction1.setLayoutX(291);
                    construction1.setLayoutY(280);
                    construction1.setFitWidth(94);
                    construction1.setFitHeight(33);


                    System.out.println(constImageR.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2R);
                    construction2.setLayoutX(395);
                    construction2.setLayoutY(279);
                    construction2.setFitWidth(94);
                    construction2.setFitHeight(33);


                    System.out.println(constImageR.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3R);
                    construction3.setLayoutX(334);
                    construction3.setLayoutY(203);
                    construction3.setFitWidth(117);
                    construction3.setFitHeight(77);


                    System.out.println(constImageR.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4R);
                    construction4.setLayoutX(327);
                    construction4.setLayoutY(134);
                    construction4.setFitWidth(131);
                    construction4.setFitHeight(70);

                    System.out.println(constImageR.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5R);
                    construction5.setLayoutX(333);
                    construction5.setLayoutY(52);
                    construction5.setFitWidth(255);
                    construction5.setFitHeight(82);

                    break;
                case Halicarnasse:
                    ConstImage constImageH = ConstImage.Halicarnasse;
                    System.out.println(constImageH.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1H);
                    construction1.setLayoutX(290);
                    construction1.setLayoutY(281);
                    construction1.setFitWidth(190);
                    construction1.setFitHeight(30);
                    construction1.setX(0);
                    construction1.setY(0);

                    System.out.println(constImageH.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2H);
                    construction2.setLayoutX(290);
                    construction2.setLayoutY(221);
                    construction2.setFitWidth(182);
                    construction2.setFitHeight(61);
                    construction2.setX(0);
                    construction2.setY(0);

                    System.out.println(constImageH.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3H);
                    construction3.setLayoutX(284);
                    construction3.setLayoutY(158);
                    construction3.setFitWidth(83);
                    construction3.setFitHeight(81);
                    construction3.setX(0);
                    construction3.setY(0);

                    System.out.println(constImageH.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4H);
                    construction4.setLayoutX(398);
                    construction4.setLayoutY(158);
                    construction4.setFitWidth(83);
                    construction4.setFitHeight(81);
                    construction4.setX(0);
                    construction4.setY(0);

                    System.out.println(constImageH.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5H = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageH.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5H);
                    construction5.setLayoutX(298);
                    construction5.setLayoutY(60);
                    construction5.setFitWidth(169);
                    construction5.setFitHeight(98);
                    construction5.setX(0);
                    construction5.setY(0);
                    break;
                case Gizeh:
                    ConstImage constImageG = ConstImage.Giseh;
                    System.out.println(constImageG.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1G);
                    construction1.setLayoutX(280);
                    construction1.setLayoutY(251);
                    construction1.setFitWidth(239);
                    construction1.setFitHeight(45);


                    System.out.println(constImageG.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2G);
                    construction2.setLayoutX(298);
                    construction2.setLayoutY(210);
                    construction2.setFitWidth(205);
                    construction2.setFitHeight(41);


                    System.out.println(constImageG.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3G);
                    construction3.setLayoutX(322);
                    construction3.setLayoutY(172);
                    construction3.setFitWidth(160);
                    construction3.setFitHeight(39);


                    System.out.println(constImageG.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4G);
                    construction4.setLayoutX(345);
                    construction4.setLayoutY(133);
                    construction4.setFitWidth(111);
                    construction4.setFitHeight(42);

                    System.out.println(constImageG.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5G);
                    construction5.setLayoutX(367);
                    construction5.setLayoutY(75);
                    construction5.setFitWidth(70);
                    construction5.setFitHeight(58);

                    break;
                case Olympie:
                    ConstImage constImageO = ConstImage.Olympie;
                    System.out.println(constImageO.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1O = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageO.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1O);
                    construction1.setLayoutX(325);
                    construction1.setLayoutY(261);
                    construction1.setFitWidth(201);
                    construction1.setFitHeight(46);


                    System.out.println(constImageO.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2O = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageO.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2O);
                    construction2.setLayoutX(341);
                    construction2.setLayoutY(182);
                    construction2.setFitWidth(88);
                    construction2.setFitHeight(80);


                    System.out.println(constImageO.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3O = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageO.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3O);
                    construction3.setLayoutX(422);
                    construction3.setLayoutY(182);
                    construction3.setFitWidth(91);
                    construction3.setFitHeight(83);


                    System.out.println(constImageO.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4O = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageO.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4O);
                    construction4.setLayoutX(340);
                    construction4.setLayoutY(110);
                    construction4.setFitWidth(170);
                    construction4.setFitHeight(77);

                    System.out.println(constImageO.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5O = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageO.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5O);
                    construction5.setLayoutX(347);
                    construction5.setLayoutY(64);
                    construction5.setFitWidth(158);
                    construction5.setFitHeight(66);


                    break;
                case Ephese:
                    ConstImage constImageE = ConstImage.Ephese;
                    System.out.println(constImageE.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()));
                    Image cons1E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getConstruction1(playerView.getWonderContruction().getAllPieces().get(0).isComplete()))));
                    construction1.setImage(cons1E);
                    construction1.setLayoutX(277);
                    construction1.setLayoutY(261);
                    construction1.setFitWidth(230);
                    construction1.setFitHeight(45);


                    System.out.println(constImageE.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()));
                    Image cons2E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getConstruction2(playerView.getWonderContruction().getAllPieces().get(1).isComplete()))));
                    construction2.setImage(cons2E);
                    construction2.setLayoutX(289);
                    construction2.setLayoutY(174);
                    construction2.setFitWidth(46);
                    construction2.setFitHeight(88);


                    System.out.println(constImageE.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()));
                    Image cons3E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getConstruction3(playerView.getWonderContruction().getAllPieces().get(2).isComplete()))));
                    construction3.setImage(cons3E);
                    construction3.setLayoutX(369);
                    construction3.setLayoutY(174);
                    construction3.setFitWidth(46);
                    construction3.setFitHeight(88);


                    System.out.println(constImageE.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()));
                    Image cons4E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getConstruction4(playerView.getWonderContruction().getAllPieces().get(3).isComplete()))));
                    construction4.setImage(cons4E);
                    construction4.setLayoutX(442);
                    construction4.setLayoutY(174);
                    construction4.setFitWidth(46);
                    construction4.setFitHeight(88);

                    System.out.println(constImageE.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()));
                    Image cons5E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getConstruction5(playerView.getWonderContruction().getAllPieces().get(4).isComplete()))));
                    construction5.setImage(cons5E);
                    construction5.setLayoutX(280);
                    construction5.setLayoutY(92);
                    construction5.setFitWidth(255);
                    construction5.setFitHeight(82);

                    break;
            }

            //for cat image
            if (playerView.getChat()) {
                catImage.setImage(catPNG);
            }

            //for tokens image
            for (int i = 0; i < playerView.getAllTokens().size(); i++) {
                tokenImages.get(i).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(playerView.getAllTokens().get(i).imageResource))));
            }

            //for military image
            if (playerView.getHand().getMilitaryPoints() != 0) {
                militaryImage.setImage(militaryPNG);
                if (playerView.getHand().getMilitaryPoints() > 1) {
                    militaryCount.setText("x"+playerView.getHand().getMilitaryPoints()/3);
                }
            }

            //for grey cards
            for (int i = 0; i < playerView.getHand().getMaterials().length; i++) {
                if (playerView.getHand().getMaterials()[i] > 0) {
                    materialImages.get(i).setVisible(true);
                }
                if (playerView.getHand().getMaterials()[i] > 1) {
                    if ((i == 5) && (playerView.getAllTokens().contains(ProgressToken.Economy))) {
                        materialLabels.get(i).setText("x"+playerView.getHand().getMaterials()[i]/2);
                    }
                    else {
                        materialLabels.get(i).setText("x"+playerView.getHand().getMaterials()[i]);
                    }
                }
            }
            //for green cards
            for (int i = 0; i < playerView.getHand().getScience().length; i++) {
                if (playerView.getHand().getScience()[i] > 0) {
                    scienceImages.get(i).setVisible(true);
                }
            }
            //for blue cards
            for (int i = 0; i < playerView.getHand().getPointVictoire().length; i++) {
                if (playerView.getHand().getPointVictoire()[i] > 0) {
                    blueImages.get(i).setVisible(true);
                }
                if (playerView.getHand().getPointVictoire()[i] > 1) {
                    blueLabels.get(i).setText("x"+playerView.getHand().getPointVictoire()[i]);
                }
            }
            //for red cards
            for (int i = 0; i < playerView.getHand().getShieldCards().length; i++) {
                if (playerView.getHand().getShieldCards()[i] > 0) {
                    redImages.get(i).setVisible(true);
                }
                if (playerView.getHand().getShieldCards()[i] > 1) {
                    redLabels.get(i).setText("x" + playerView.getHand().getShieldCards()[i]);
                }
            }
        }

        allPlayerNames.setValue(null);
    }

    public void onButtonLeftDeck() throws IOException {
        animationLeft.setImage(leftDeckCardImage.getImage());
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(animationLeft);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(230);
        translate.setByY(80);
        translate.setCycleCount(1);
        translate.setAutoReverse(true);

        translate.play();




        player.addCard(leftDeckCard, allPlayers);

        options.get(0).chooseCard();

        countCards++;

        power = buidPiece(player.getWonderContruction(),player);
        if (power) {
            buildPower(player);
            powerChoiceBox.setValue(null);
        }

        checkChosenCard(player, leftDeckCard);

        resetCardImage(0);

        if (countDraw >= countCards) {
            cardDisable(true);
        }

        endButton.setDisable(false);
    }

    public void onButtonRightDeck() throws IOException {
        animationRight.setImage(rightDeckCardImage.getImage());
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(animationRight);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(-230);
        translate.setByY(-80);
        translate.setCycleCount(1);
        translate.setAutoReverse(true);
        translate.play();
        player.addCard(rightDeckCard, allPlayers);

        options.get(1).chooseCard();

        countCards++;

        power = buidPiece(player.getWonderContruction(),player);
        if (power) {
            buildPower(player);
            powerChoiceBox.setValue(null);
        }

        checkChosenCard(player, rightDeckCard);

        resetCardImage(1);

        if (countDraw >= countCards) {
            cardDisable(true);
        }

        endButton.setDisable(false);
    }

    public void resetCardImage(int place) {
        if (place == 0) {
            Image leftDeckCardPNG;
            try {
                leftDeckCard = options.get(0).getCard(0);
                leftDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(leftDeckCard.front.imageResource)));
            } catch (IndexOutOfBoundsException e) {
                leftDeckCardPNG = null;
            }
            leftDeckCardImage.setImage(leftDeckCardPNG);
            cardCountLeft.setText("Cards: "+options.get(0).cardDeckSize());
        }
        else if (place == 1) {
            Image rightDeckCardPNG;
            try {
                rightDeckCard = options.get(1).getCard(0);
                rightDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(rightDeckCard.front.imageResource)));
            } catch (IndexOutOfBoundsException e) {
                rightDeckCardPNG = null;
            }
            rightDeckCardImage.setImage(rightDeckCardPNG);
            cardCountRight.setText("Cards: "+options.get(1).cardDeckSize());
        }
        else {
            Image mainDeckFrontPNG;
            try {
                mainDeckCard = mainDeck.getCard(0);
                mainDeckFrontPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(mainDeckCard.front.imageResource)));
            } catch (IndexOutOfBoundsException e) {
                mainDeckFrontPNG = null;
            }
            cardCountMain.setText("Cards: "+mainDeck.cardDeckSize());
            if (player.getChat()) {
                mainDeckImage.setImage(mainDeckFrontPNG);
            }
            else {
                mainDeckImage.setImage(mainDeckBackPNG);
            }
        }
    }

    public void onButtonMainDeck() throws IOException {
        player.addCard(mainDeckCard, allPlayers);
        mainDeck.chooseCard();

        countCards++;
        if (!player.getChat()) {
            infoBoxLabel.setText("Card Picked : "+mainDeckCard.front.cardDisplayName);
        }
        power = buidPiece(player.getWonderContruction(),player);

        if (power) {
            buildPower(player);
            powerChoiceBox.setValue(null);
        }

        checkChosenCard(player, mainDeckCard);

        resetCardImage(2);

        if (countDraw >= countCards) {
            cardDisable(true);
        }

        endButton.setDisable(false);
    }

    public void checkChosenCard(Player player, Card card) {
        if (player.getAllTokens().size() == 0) {
            cardDisable(true);
        }
        else {
            for (int i = 0; i < player.getAllTokens().size(); i++) {
                ProgressToken pt = player.getAllTokens().get(i);
                if (!player.getTokenIgnore().contains(i)) {
                    boolean found = getScienceEffectDuringGame(pt, leftDeckCard);
                    if (found) {
                        player.getTokenIgnore().add(i);
                        break;
                    }
                }
            }
        }

        checkCardCorn(card.front);
        canGetToken();
    }

    public void onProgress0() {
        player.getAllTokens().add(res.get(0));

        if (res.get(0) == ProgressToken.Economy) {
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]*2;
        }
        else if (res.get(0) == ProgressToken.Tactic) {
            player.getHand().setShieldWar(player.getHand().getShieldWar()+2);
        }

        res.remove(0);
        for (int i = 0; i < progressImages.size(); i++) {
            Image resImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(res.get(i).imageResource)));
            progressImages.get(i).setImage(resImage);
        }
        disableProgressChoice(true);
    }

    public void onProgress1() {
        player.getAllTokens().add(res.get(1));
        if (res.get(1) == ProgressToken.Economy) {
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]*2;
        }
        else if (res.get(1) == ProgressToken.Tactic) {
            player.getHand().setShieldWar(player.getHand().getShieldWar()+2);
        }
        res.remove(1);
        for (int i = 0; i < progressImages.size(); i++) {
            Image resImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(res.get(i).imageResource)));
            progressImages.get(i).setImage(resImage);
        }

        disableProgressChoice(true);
    }

    public void onProgress2() {
        player.getAllTokens().add(res.get(2));
        if (res.get(2) == ProgressToken.Economy) {
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]*2;
        }
        else if (res.get(2) == ProgressToken.Tactic) {
            player.getHand().setShieldWar(player.getHand().getShieldWar()+2);
        }
        res.remove(2);
        for (int i = 0; i < progressImages.size(); i++) {
            Image resImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(res.get(i).imageResource)));
            progressImages.get(i).setImage(resImage);
        }
        disableProgressChoice(true);
    }

    public void onProgress3() {
        player.getAllTokens().add(res.get(3));
        infoBoxOutline.setVisible(true);
        infoBoxLabel.setText(res.get(3).effectDescription);
        if (res.get(3) == ProgressToken.Economy) {
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]*2;
        }
        else if (res.get(3) == ProgressToken.Tactic) {
            player.getHand().setShieldWar(player.getHand().getShieldWar()+2);
        }
        res.remove(3);
        disableProgressChoice(true);
    }

    public void onButtonEnd() {


        if (playerTurn == allPlayers.size()-1) {
            playerTurn = 0;
        }
        else {
            playerTurn++;
        }
        startTurn(allPlayers, mainDeck, res, playerTurn, false);
    }

    public void resetPlayerViewBlank() {
        for (int i = 0; i < redImages.size(); i++) {
            redImages.get(i).setVisible(false);
            redLabels.get(i).setText("");

            scienceImages.get(i).setVisible(false);
        }
        for (int i = 0; i < blueImages.size(); i++) {
            blueImages.get(i).setVisible(false);
            blueLabels.get(i).setText("");
        }
        for (int i = 0; i < materialImages.size(); i++) {
            materialImages.get(i).setVisible(false);
            materialLabels.get(i).setText("");
        }
        for (ImageView i : tokenImages) {
            i.setImage(null);
        }

        construction1.setImage(null);
        construction2.setImage(null);
        construction3.setImage(null);
        construction4.setImage(null);
        construction5.setImage(null);
    }

    public void cardDisable(boolean disable) {
        leftDeckCardImage.setDisable(disable);
        rightDeckCardImage.setDisable(disable);
        mainDeckImage.setDisable(disable);
    }

    public void resetTokens() {
        combat1.setImage(tokenPeace);
        combat2.setImage(tokenPeace);
        combat3.setImage(tokenPeace);
        combats.add(combat1);
        combats.add(combat2);
        combats.add(combat3);
        if (allPlayers.size() >= 4) {
            combat4.setImage(tokenPeace);
            combats.add(combat4);
        }
        if (allPlayers.size() >= 5) {
            combat5.setImage(tokenPeace);
            combats.add(combat5);
        }
        if (allPlayers.size() >= 6) {
            combat6.setImage(tokenPeace);
            combats.add(combat6);
        }
    }

    public void checkCardCorn(CardType card) {
        if (card.cardCategory == CardCategory.WarCard) {
            int count = 0;
            for (ImageView combat : combats) {
                if (count == card.cornCount) {
                    break;
                }
                if (combat.getImage() == tokenPeace) {
                    combat.setImage(tokenWar);
                    count++;
                }

            }
            String warTime = "no";
            for (int i = 0; i < combats.size(); i++) {
                if (combats.get(i).getImage() == tokenPeace) {
                    warTime = "false";
                    break;
                }
                if (i == combats.size()-1) {
                    warTime = "true";
                }
            }
            if(warTime.equals("true")) {
                infoBoxOutline.setVisible(true);
                infoBoxLabel.setText("Bataille ! ");
                battle();
                resetTokens();
            }
        }
    }

    public void disableProgressChoice(boolean disable) {
        for (ImageView progressImage : progressImages) {
            progressImage.setDisable(disable);
        }
    }

    public void battle() {
        if (allPlayers.size() == 2) {
            if (allPlayers.get(0).getHand().getShieldWar() > allPlayers.get(1).getHand().getShieldWar()) {
                infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+allPlayers.get(0).getName()+" est le gagnant");
                if (allPlayers.get(0).getHand().getShieldWar() > 2*allPlayers.get(1).getHand().getShieldWar()) {
                    allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+6);
                }
                else {
                    allPlayers.get(0).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+3);
                }
            }
            else if (allPlayers.get(1).getHand().getShieldWar() > allPlayers.get(0).getHand().getShieldWar()) {
                infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+allPlayers.get(1).getName()+" est le gagnant");
                if (allPlayers.get(1).getHand().getShieldWar() > 2*allPlayers.get(0).getHand().getShieldWar()) {
                    allPlayers.get(1).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+6);
                }
                else {
                    allPlayers.get(1).getHand().setMilitaryPoints(allPlayers.get(0).getHand().getMilitaryPoints()+3);
                }
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
                if ((interestingPlayer.getHand().getShieldWar() > playerLeft.getHand().getShieldWar()) || (interestingPlayer.getHand().getShieldWar() > playerRight.getHand().getShieldWar())) {
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+interestingPlayer.getName()+" est le gagnant");
                }
            }
        }

        for (Player allPlayer : allPlayers) {
            allPlayer.getHand().getShieldCards()[1] = 0;
            allPlayer.getHand().getShieldCards()[2] = 0;
        }
    }

    public void canGetToken() {
        int count = 0;
        for (int i = 0; i < player.getHand().getScience().length; i++) {
            if (player.getHand().getScience()[i] == 2) {
                player.getHand().getScience()[i] = 0;
                infoBoxLabel.setText("Tu peux choisir un jeton progres");
                disableProgressChoice(false);
                break;
            }
            if (player.getHand().getScience()[i] == 1) {
                count++;
            }
        }
        if (count >= 3) {
            for (int i = 0; i < player.getHand().getScience().length; i++) {
                player.getHand().getScience()[i] -= 1;
                disableProgressChoice(false);
            }
            infoBoxLabel.setText("Tu peux choisir un jeton progres");
        }
    }

    public boolean getScienceEffectDuringGame(ProgressToken progressToken, Card cardChosen) {
        boolean found = false;

        switch (progressToken) {
            case Science:
                if (cardChosen.front.cardCategory == CardCategory.ProgressCard) {
                    countDraw++;
                    found = true;
                    infoBoxLabel.setText("choose another card");
                }
                break;
            case Jewelry:
                if ((cardChosen.front.material == Material.Stone) || (cardChosen.front.material == Material.Gold)) {
                    countDraw++;
                    found = true;
                    infoBoxLabel.setText("choose another card");
                }
                break;
            case Urbanism:
                if ((cardChosen.front.material == Material.Wood) || (cardChosen.front.material == Material.Brick)) {
                    countDraw++;
                    found = true;
                    infoBoxLabel.setText("choose another card");
                }
                break;
            case Propaganda:
                if (cardChosen.front.cornCount != 0) {
                    countDraw++;
                    found = true;
                    infoBoxLabel.setText("choose another card");
                }
                break;
            case ArtsAndCrafts:
                if ((cardChosen.front.material == Material.Paper) || (cardChosen.front.material == Material.Glass)) {
                    countDraw++;
                    found = true;
                    infoBoxLabel.setText("choose another card");
                }
                break;
        }
        return found;
    }
    public boolean canBuildPiece(ConstructionPiece piece, Player player) {
        int nbResources = piece.getNbPieces();
        boolean canBuild = false;
        boolean isEqual;
        if (player.getAllTokens().contains(ProgressToken.Ingeniery)) {
            int totalMaterial = 0;
            for (int i : player.getHand().getMaterials()) {
                totalMaterial +=i;

                if (totalMaterial >= nbResources) {
                    canBuild = true;
                    break;
                }
            }
        }
        else {
            isEqual = piece.isEqual();
            if (isEqual) {
                canBuild = false;
                for (int i = 0; i < 5; i++) {
                    int samePieces = player.getHand().getMaterials()[i] + player.getHand().getMaterials()[5];
                    if (samePieces >= nbResources) {
                        canBuild = true;
                        break;
                    }
                }
            }
            else {
                int differentPieces = 0;
                for (int i = 0; i < 5; i++) {
                    if(player.getHand().getMaterials()[i] != 0)
                    {   differentPieces+=1; }
                }
                differentPieces += player.getHand().getMaterials()[5];
                canBuild = differentPieces >= nbResources;
            }
        }
        return canBuild;
    }

    public boolean buidPiece (Construction cons, Player player) throws IOException {
        ConstructionPiece piece;
        boolean pieceBuild = false;
        boolean piecePower = false;
        boolean pieceBefor;
        for (int i=0;i<5;i++) {
            if (i>0) {
                piece =cons.getAllPieces().get(i);
                pieceBefor = cons.getAllPieces().get(i-1).isComplete();
            } else {
                piece =cons.getAllPieces().get(i);
                pieceBefor =true;
            }

            if (canBuildPiece(piece,player) && !piece.isComplete() && pieceBefor) {
                switch (player.getWonder()) {
                    case Halicarnasse:
                    case Alexandrie:
                    case Babylone:
                    case Olympie:
                    case Rhodes:
                        piecePower = (i == 1) || (i == 3);
                        break;
                    case Ephese:
                        piecePower = ((i>0)&&(i<4));
                        break;
                    case Gizeh:
                        piecePower = false;
                        break;
                }

                pieceBuild = true;
                piece.setComplete(true);
                boolean equal = piece.getEqual();
                int nbRessource = piece.getNbPieces();
                int p=0;
                int previousElem = 10;

                if (player.getAllTokens().contains(ProgressToken.Ingeniery)) {
                    for (int k = 0; k < 6; k++) {
                         p += player.getHand().getMaterials()[k];
                         if (p <= nbRessource) {
                             player.getHand().getMaterials()[k] = 0;
                         }
                         else {
                             player.getHand().getMaterials()[k] -= p-nbRessource;
                         }

                         if (p>= nbRessource) {
                             break;
                         }
                    }
                }
                else {
                    for (int k=0;k<6;k++) {
                        int material=  player.getHand().getMaterials()[k];
                        if (equal) {
                            if (material + player.getHand().getMaterials()[5] >= nbRessource) {
                                int max = player.getHand().getMaterials()[k];

                                int usedGold = nbRessource - max;
                                int usedOther = max;
                                if((player.getAllTokens().contains(ProgressToken.Economy)) && (usedGold%2 != 0)) {
                                    usedGold +=1;
                                    usedOther -=1;
                                }
                                for (int n = 0; n < usedGold; n++) {
                                    player.getHand().removeMaterials(5);
                                }
                                for (int n = 0; n < usedOther; n++) {
                                    player.getHand().removeMaterials(k);
                                }
                                break;
                            }
                        } else {
                            if (material!=0) {
                                int elemLeft = nbRessource-p;
                                if (player.getAllTokens().contains(ProgressToken.Economy) && (k == 5)) {
                                    player.getHand().removeMaterials(k);
                                    if (elemLeft == 1) {
                                        if (previousElem != 10) {
                                            player.getHand().addMaterials(previousElem);
                                        }
                                    }
                                }
                                player.getHand().removeMaterials(k);
                                p++;
                                previousElem = k;
                                if (p==nbRessource) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean buildComplete = player.getWonderContruction().getAllPieces().get(4).isComplete();
        if (buildComplete) {
            FXMLLoader root =  new FXMLLoader(getClass().getResource("endScreen.fxml"));
            Stage stage = (Stage) endButton.getScene().getWindow();
            Scene scene = new Scene(root.load());

            EndScreen endScreen = root.getController();
            endScreen.getInfo(allPlayers);

            stage.setScene(scene);
            stage.setTitle("Round");
            stage.show();
        }

        if(pieceBuild) {
            return piecePower;
        }
        else {
            return false;
        }
    }

    public void buildPower(Player player) {
        Wonder wonder = player.getWonder();
        infoBoxOutline.setVisible(true);
        powerChoiceBox.setDisable(false);
        power = false;
        switch (wonder) {
            case Ephese:
                infoBoxLabel.setText("Power: t'as pris la carte "+mainDeckCard.front.cardDisplayName);
                player.addCard(mainDeckCard, allPlayers);
                checkChosenCard(player, mainDeckCard);

                mainDeck.chooseCard();
                resetCardImage(2);
                break;
            case Rhodes:
                player.getHand().setShieldWar(player.getHand().getShieldWar()+1);
                infoBoxLabel.setText("Power: Ajouter un bouclier au total");
                break;
            case Olympie:
                Card cardLeft = options.get(0).getCard(0);
                Card cardRight = options.get(1).getCard(0);
                infoBoxOutline.setVisible(true);
                infoBoxLabel.setText("Power: t'as pris les carte "+cardLeft.front.cardDisplayName+" et "+cardRight.front.cardDisplayName);
                player.addCard(cardLeft, allPlayers);
                player.addCard(cardRight, allPlayers);
                checkChosenCard(player, cardLeft);
                checkChosenCard(player, cardRight);
                options.get(0).chooseCard();
                resetCardImage(0);
                options.get(1).chooseCard();
                resetCardImage(1);
                break;
            case Babylone:
                disableProgressChoice(false);
                infoBoxOutline.setVisible(true);
                infoBoxLabel.setText("Power: choisis un jetons progrès");
                break;
            case Alexandrie:
                powerChoiceBox.setVisible(true);
                cardDescription = new ArrayList<>();
                for (int i = 0; i < allPlayers.size(); i++) {
                    cardDescription.add("["+i+"]"+allPlayers.get(i).getCardDecks().getCard(0).front.cardDisplayName);
                }
                if (player.getChat()) {
                    cardDescription.add("[2]"+mainDeck.getCard(0).front.cardDisplayName);
                }
                else {
                    cardDescription.add("MainDeck");
                }
                powerChoiceBox.getItems().addAll(cardDescription);
                powerChoiceBox.setOnAction(this::getPowerCardAlexandrie);
                infoBoxLabel.setText("Power: choisis une des cartes de la liste: ");
                break;
            case Halicarnasse:
                powerChoiceBox.setVisible(true);
                String[] choice = {"gauche", "droite"};
                powerChoiceBox.getItems().addAll(choice);
                powerChoiceBox.setOnAction(this::getChoice);
                infoBoxLabel.setText("Power: Gauche ou droite: ");
                break;
        }
    }

    public void getChoice(Event event) {
        if (!powerChoiceBox.getValue().equals("")) {
            cardChoices = new ArrayList<>();
            if (powerChoiceBox.getValue().equals("gauche")) {
                for (int i = 0; i < 5; i++) {
                    cardChoices.add("["+i+"]"+options.get(0).getCard(i).front.cardDisplayName);
                }
                choice = 0;
            }
            else {
                choice = 1;
                for (int i = 0; i < 5; i++) {
                    cardChoices.add("["+i+"]"+options.get(1).getCard(i).front.cardDisplayName);
                }
            }
            powerChoiceBox.getItems().addAll(cardChoices);
            powerChoiceBox.getItems().remove("gauche");
            powerChoiceBox.getItems().remove("droite");
            powerChoiceBox.setOnAction(this::getPowerCardHalicarnasse);
            infoBoxLabel.setText("Power: choisis une des cartes de la liste: ");
        }
    }

    public void getPowerCardHalicarnasse(Event event) {
        if (powerChoiceBox.getValue()!=null) {
            String card = powerChoiceBox.getValue();
            int number = Integer.parseInt(card.substring(1,2));
            player.addCard(options.get(choice).getCard(number), allPlayers);
            checkChosenCard(player, options.get(choice).getCard(number));

            options.get(choice).removeCard(number);
            options.get(choice).shuffleDeck();
            resetCardImage(choice);
            powerChoiceBox.setDisable(true);
            powerChoiceBox.getItems().removeAll(cardChoices);
        }
    }

    public void getPowerCardAlexandrie(Event event) {
        if (powerChoiceBox.getValue()!=null) {
            String card = powerChoiceBox.getValue();
            if (card.equals("MainDeck")) {
                player.addCard(mainDeck.getCard(0), allPlayers);
                mainDeck.chooseCard();
            }
            else {
                int number = Integer.parseInt(card.substring(1,2));
                if (number == 2) {
                    player.addCard(mainDeck.getCard(0), allPlayers);
                    checkChosenCard(player, mainDeck.getCard(0));
                    mainDeck.chooseCard();
                }
                else {
                    player.addCard(allPlayers.get(number).getCardDecks().getCard(0), allPlayers);
                    checkChosenCard(player, allPlayers.get(number).getCardDecks().getCard(0));
                    allPlayers.get(number).getCardDecks().chooseCard();

                }
                resetCardImage(number);
                powerChoiceBox.getItems().removeAll(cardDescription);
                powerChoiceBox.setDisable(true);
            }
        }
    }
    public void retour (Event event) throws  IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
}
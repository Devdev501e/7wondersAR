package com.example.wonders;



import domain.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    @FXML
    private ImageView progress0 = new ImageView();
    @FXML
    private ImageView progress1 = new ImageView();
    @FXML
    private ImageView progress2 = new ImageView();
    @FXML
    private ImageView progressBack = new ImageView();
    private ArrayList<ImageView> progressImages = new ArrayList<>();

    @FXML
    private Rectangle infoBoxOutline;
    @FXML
    private Label infoBoxLabel;

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
    ArrayList<ProgressToken> res;

    public void startTurn(ArrayList<Player> players, CardDecks mainCardDeck, ArrayList<CardDecks> allPlayerDecks, Conflict conflictList,ArrayList<ProgressToken> progressTokens, int turn, boolean beggining) {
        //initialize table game
        for (Player i : players) {
            playerNames.add(i.getName());
        }
        endButton.setDisable(true);
        infoBoxOutline.setVisible(false);
        infoBoxLabel.setText("");
        cardDisable(false);

        if (beggining) {
            allPlayerNames.getItems().addAll(playerNames);
            allPlayers.addAll(players);
            allDecks.addAll(allPlayerDecks);
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
        }

        player = players.get(turn);
        playerTurn = turn;
        playerName.setText(player.getName());

        conflict = conflictList;
        mainDeck = mainCardDeck;

        options = actions.cardDecksOption(allPlayerDecks, turn);

        allPlayerNames.setOnAction(this::onPlayerNames);

        for (int i = 0; i < progressImages.size(); i++) {
            Image resImage = new Image(getClass().getResourceAsStream(res.get(i).imageResource));
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
        switch (playerView.getWonder()){
            case Alexandrie:
                ConstImage constImage = ConstImage.AlexandrieBack;
                System.out.println(constImage.getCons1());
                Image cons1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons1())));
                construction1.setImage(cons1);
                construction1.setLayoutX(330);
                construction1.setLayoutY(272);
                construction1.setFitWidth(190);
                construction1.setFitHeight(35);


                System.out.println(constImage.getCons2());
                Image cons2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons2())));
                construction2.setImage(cons2);
                construction2.setLayoutX(373);
                construction2.setLayoutY(230);
                construction2.setFitWidth(95);
                construction2.setFitHeight(44);


                System.out.println(constImage.getCons3());
                Image cons3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons3())));
                construction3.setImage(cons3);
                construction3.setLayoutX(375);
                construction3.setLayoutY(186);
                construction3.setFitWidth(81);
                construction3.setFitHeight(45);


                System.out.println(constImage.getCons4());
                Image cons4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons4())));
                construction4.setImage(cons4);
                construction4.setLayoutX(386);
                construction4.setLayoutY(136);
                construction4.setFitWidth(59);
                construction4.setFitHeight(51);

                System.out.println(constImage.getCons5());
                Image cons5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImage.getCons5())));
                construction5.setImage(cons5);
                construction5.setLayoutX(394);
                construction5.setLayoutY(71);
                construction5.setFitWidth(64);
                construction5.setFitHeight(71);

                break;
            case Babylone:
                ConstImage constImageB = ConstImage.BabylonBack;
                System.out.println(constImageB.getCons1());
                Image cons1B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons1())));
                construction1.setImage(cons1B);
                construction1.setLayoutX(309);
                construction1.setLayoutY(259);
                construction1.setFitWidth(204);
                construction1.setFitHeight(42);
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
                construction2.setLayoutY(218);
                construction2.setFitWidth(194);
                construction2.setFitHeight(47);


                System.out.println(constImageB.getCons3());
                Image cons3B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons3())));
                construction3.setImage(cons3B);
                construction3.setLayoutX(325);
                construction3.setLayoutY(180);
                construction3.setFitWidth(173);
                construction3.setFitHeight(47);


                System.out.println(constImageB.getCons4());
                Image cons4B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons4())));
                construction4.setImage(cons4B);
                construction4.setLayoutX(346);
                construction4.setLayoutY(119);
                construction4.setFitWidth(74);
                construction4.setFitHeight(61);


                System.out.println(constImageB.getCons5());
                Image cons5B = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageB.getCons5())));
                construction5.setImage(cons5B);
                construction5.setLayoutX(408);
                construction5.setLayoutY(140);
                construction5.setFitWidth(79);
                construction5.setFitHeight(44);

                break;
            case Rhodes:
                ConstImage constImageR = ConstImage.Rhodes;
                System.out.println(constImageR.getCons1());
                Image cons1R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getCons1())));
                construction1.setImage(cons1R);
                construction1.setLayoutX(291);
                construction1.setLayoutY(280);
                construction1.setFitWidth(94);
                construction1.setFitHeight(33);


                System.out.println(constImageR.getCons2());
                Image cons2R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getCons2())));
                construction2.setImage(cons2R);
                construction2.setLayoutX(395);
                construction2.setLayoutY(279);
                construction2.setFitWidth(94);
                construction2.setFitHeight(33);


                System.out.println(constImageR.getCons3());
                Image cons3R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getCons3())));
                construction3.setImage(cons3R);
                construction3.setLayoutX(334);
                construction3.setLayoutY(203);
                construction3.setFitWidth(117);
                construction3.setFitHeight(77);


                System.out.println(constImageR.getCons4());
                Image cons4R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getCons4())));
                construction4.setImage(cons4R);
                construction4.setLayoutX(327);
                construction4.setLayoutY(134);
                construction4.setFitWidth(131);
                construction4.setFitHeight(70);

                System.out.println(constImageR.getCons5());
                Image cons5R = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageR.getCons5())));
                construction5.setImage(cons5R);
                construction5.setLayoutX(333);
                construction5.setLayoutY(52);
                construction5.setFitWidth(255);
                construction5.setFitHeight(82);

                break;
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
                ConstImage constImageG = ConstImage.Giseh;
                System.out.println(constImageG.getCons1());
                Image cons1G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getCons1())));
                construction1.setImage(cons1G);
                construction1.setLayoutX(330);
                construction1.setLayoutY(272);
                construction1.setFitWidth(190);
                construction1.setFitHeight(35);


                System.out.println(constImageG.getCons2());
                Image cons2G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getCons2())));
                construction2.setImage(cons2G);
                construction2.setLayoutX(292);
                construction2.setLayoutY(230);
                construction2.setFitWidth(213);
                construction2.setFitHeight(40);


                System.out.println(constImageG.getCons3());
                Image cons3G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getCons3())));
                construction3.setImage(cons3G);
                construction3.setLayoutX(316);
                construction3.setLayoutY(191);
                construction3.setFitWidth(157);
                construction3.setFitHeight(43);


                System.out.println(constImageG.getCons4());
                Image cons4G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getCons4())));
                construction4.setImage(cons4G);
                construction4.setLayoutX(340);
                construction4.setLayoutY(152);
                construction4.setFitWidth(111);
                construction4.setFitHeight(42);

                System.out.println(constImageG.getCons5());
                Image cons5G = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageG.getCons5())));
                construction5.setImage(cons5G);
                construction5.setLayoutX(360);
                construction5.setLayoutY(94);
                construction5.setFitWidth(70);
                construction5.setFitHeight(57);

                break;
            case Olympie:
                break;
            case Ephese:
                ConstImage constImageE = ConstImage.Ephese;
                System.out.println(constImageE.getCons1());
                Image cons1E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getCons1())));
                construction1.setImage(cons1E);
                construction1.setLayoutX(277);
                construction1.setLayoutY(261);
                construction1.setFitWidth(230);
                construction1.setFitHeight(45);


                System.out.println(constImageE.getCons2());
                Image cons2E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getCons2())));
                construction2.setImage(cons2E);
                construction2.setLayoutX(289);
                construction2.setLayoutY(174);
                construction2.setFitWidth(46);
                construction2.setFitHeight(88);


                System.out.println(constImageE.getCons3());
                Image cons3E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getCons3())));
                construction3.setImage(cons3E);
                construction3.setLayoutX(369);
                construction3.setLayoutY(174);
                construction3.setFitWidth(46);
                construction3.setFitHeight(86);


                System.out.println(constImageE.getCons4());
                Image cons4E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getCons4())));
                construction4.setImage(cons4E);
                construction4.setLayoutX(442);
                construction4.setLayoutY(174);
                construction4.setFitWidth(46);
                construction4.setFitHeight(86);

                System.out.println(constImageE.getCons5());
                Image cons5E = new Image(Objects.requireNonNull(getClass().getResourceAsStream(constImageE.getCons5())));
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
        player.addCard(leftDeckCard, conflict.getAllConflicts(), allPlayers);
        for (ProgressToken i : player.getAllTokens()) {
            getScienceEffectDuringGame(i, player, leftDeckCard);
        }
        options.get(0).chooseCard();
        checkCardCorn(leftDeckCard.front);
        canGetToken();

        leftDeckCard = options.get(0).getCard(0);
        Image leftDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(leftDeckCard.front.imageResource)));
        leftDeckCardImage.setImage(leftDeckCardPNG);
        cardCountLeft.setText("Cards: "+options.get(0).cardDeckSize());

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onButtonRightDeck() {
        player.addCard(rightDeckCard, conflict.getAllConflicts(), allPlayers);
        for (ProgressToken i : player.getAllTokens()) {
            getScienceEffectDuringGame(i, player, rightDeckCard);
        }
        options.get(1).chooseCard();
        checkCardCorn(rightDeckCard.front);
        canGetToken();

        rightDeckCard = options.get(1).getCard(0);
        Image rightDeckCardPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(rightDeckCard.front.imageResource)));
        rightDeckCardImage.setImage(rightDeckCardPNG);
        cardCountRight.setText("Cards: "+options.get(1).cardDeckSize());

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onButtonMainDeck() {
        player.addCard(mainDeckCard, conflict.getAllConflicts(), allPlayers);
        if (!player.getChat()) {
            infoBoxLabel.setText("Card Picked : "+mainDeckCard.front.cardDisplayName);
        }
        for (ProgressToken i : player.getAllTokens()) {
            getScienceEffectDuringGame(i, player, mainDeckCard);
        }

        checkCardCorn(mainDeckCard.front);
        canGetToken();

        mainDeck.chooseCard();
        mainDeckCard = mainDeck.getCard(0);
        cardCountMain.setText("Cards: "+mainDeck.cardDeckSize());

        Image mainDeckFrontPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream(mainDeckCard.front.imageResource)));
        if (player.getChat()) {
            mainDeckImage.setImage(mainDeckFrontPNG);
        }
        else {
            mainDeckImage.setImage(mainDeckBackPNG);
        }

        cardDisable(true);
        endButton.setDisable(false);
    }

    public void onProgress0() {
        player.getAllTokens().add(res.get(0));
        res.remove(0);
        Image resImage = new Image(getClass().getResourceAsStream(res.get(3).imageResource));
        progressImages.get(0).setImage(resImage);
        disableProgressChoice(true);
    }

    public void onProgress1() {
        player.getAllTokens().add(res.get(1));
        res.remove(1);
        Image resImage = new Image(getClass().getResourceAsStream(res.get(3).imageResource));
        progressImages.get(1).setImage(resImage);
        disableProgressChoice(true);
    }

    public void onProgress2() {
        player.getAllTokens().add(res.get(2));
        res.remove(2);
        Image resImage = new Image(getClass().getResourceAsStream(res.get(3).imageResource));
        progressImages.get(2).setImage(resImage);
        disableProgressChoice(true);
    }

    public void onProgress3() {
        player.getAllTokens().add(res.get(3));
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
        startTurn(allPlayers, mainDeck, allDecks, conflict, res, playerTurn, false);
    }

    public void resetPlayerViewBlank() {
        centurionImage.setImage(null);
        centurionCount.setText("");
        archerImage.setImage(null);
        archerCount.setText("");
        barbarianImage.setImage(null);
        barbarianCount.setText("");
        militaryImage.setImage(null);
        militaryCount.setText("");

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

        for (ImageView i : tokenImages) {
            i.setImage(null);
        }
    }

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
                if (count == card.cornCount) {
                    break;
                }
                if (combats.get(i).getImage() == tokenPeace) {
                    combats.get(i).setImage(tokenWar);
                    count++;
                }

            }
            boolean warTime = true;
            for (ImageView i : combats) {
                if (i.getImage() == tokenPeace) {
                    warTime = false;
                    break;
                }
            }
            if(warTime) {
                infoBoxOutline.setVisible(true);
                infoBoxLabel.setText("Bataille ! ");
                battle();
                resetTokens();
            }
        }
    }

    public void disableProgressChoice(boolean disable) {
        for (int j = 0; j < progressImages.size(); j++) {
            progressImages.get(j).setDisable(disable);
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

        for (int j = 0; j < allPlayers.size(); j++) {
            ArrayList<Card> toRemove = new ArrayList<>();
            for (Card i : allPlayers.get(j).getAllPlayerCards()) {
                if ((i.front.cardDisplayName.equals("war:barbarian")) || (i.front.cardDisplayName.equals("war:archer"))) {
                    toRemove.add(i);
                }
            }
            allPlayers.get(j).getAllPlayerCards().removeAll(toRemove);
            allPlayers.get(j).getHand().setShieldWar(allPlayers.get(j).getHand().getShieldWar()-toRemove.size());
        }
    }

    public void canGetToken() {
        int count = 0;
        for (int i = 0; i < player.getHand().getScience().length; i++) {
            System.out.println("science: "+player.getHand().getScience()[i]);
        }
        for (int i = 0; i < player.getHand().getScience().length; i++) {
            if (player.getHand().getScience()[i] == 2) {
                player.getHand().getScience()[i] = 0;
                System.out.println("yes");
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

    public void getScienceEffectDuringGame(ProgressToken progressToken, Player player, Card cardChosen) {
        switch (progressToken) {
            case Tactic:
                player.getHand().setShieldWar(player.getHand().getShieldWar()+2);
                break;
            case Culture:
                player.setCultureTokens(player.getCultureTokens()+1);
                break;
            case Economy:
                player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]*2;
                break;
            case Science:
                if (cardChosen.front.cardCategory == CardCategory.ProgressCard) {
                    cardDisable(false);
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+progressToken.effectDescription);
                }
                break;
            case Jewelry:
                if ((cardChosen.front.material == Material.Stone) || (cardChosen.front.material == Material.Gold)) {
                    cardDisable(false);
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+progressToken.effectDescription);
                }
                break;
            case Urbanism:
                if ((cardChosen.front.material == Material.Wood) || (cardChosen.front.material == Material.Brick)) {
                    cardDisable(false);
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+progressToken.effectDescription);
                }
                break;
            case Propaganda:
                if (cardChosen.front.cornCount != 0) {
                    cardDisable(false);
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+progressToken.effectDescription);
                }
                break;
            case ArtsAndCrafts:
                if ((cardChosen.front.material == Material.Paper) || (cardChosen.front.material == Material.Glass)) {
                    cardDisable(false);
                    infoBoxLabel.setText(infoBoxLabel.getText()+"\n"+progressToken.effectDescription);
                }
                break;
        }
    }
}
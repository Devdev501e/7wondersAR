package com.example.wonders;

import domain.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class InstructionJeu implements Initializable {
    @FXML
    private Label labelTitle;

    @FXML
    private ImageView imagePartie;
    private final Image partiePNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/tourDuJeu.png")));

    @FXML
    private ImageView imageToken;
    @FXML
    private Label tokenName;
    @FXML
    private Label tokenDescription;
    @FXML
    private Rectangle outlineToken;
    @FXML
    private Button buttonLeftToken;
    @FXML
    private Button buttonRightToken;

    @FXML
    private ImageView imageWonder;
    @FXML
    private Label nameWonder;
    @FXML
    private Label descriptionWonder;
    @FXML
    private Rectangle outlineWonder;
    @FXML
    private Button buttonLeftWonder;
    @FXML
    private Button buttonRightWonder;

    @FXML
    private ImageView image2Joueur;
    private final Image joueurPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/partie2joueur.png")));
    @FXML
    private Label joueurDescription;
    @FXML
    private ImageView imageFin;
    private final Image finPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/findepartie.png")));
    @FXML
    private Label finDescription;
    @FXML
    Button retour;

    private final ArrayList<ProgressToken> res = new ArrayList<>();
    private int currentRes = 0;
    private final String[] images = {"images/imagejeu/alexandrie_icon.png", "images/imagejeu/halicarnasse_icon.png", "images/imagejeu/ephese_icon.png", "images/imagejeu/olympie_icon.png", "images/imagejeu/babylon_icon.png", "images/imagejeu/rhodes_icon.png", "images/imagejeu/gizeh_icon.png"};
    private int currentWonder = 0;
    private final ArrayList<Wonder> wonders = new ArrayList<>();
    //------------------------------------------------------------------ Sauvegarde

    ArrayList<CardDecks> options;
    CardDecks mainDeck;
    int playerTurn;
    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<ProgressToken> resPlayer;
    int countCards;
    private   int countDraw;

    ArrayList<String> cardChoices;



//---------------------------------------------------------------------------------------------
public void sauvegarde(ArrayList<CardDecks> options1,
                       ArrayList<Player> allPlayers1,
                       ArrayList<String> cardChoices1,
                       ArrayList<ProgressToken> res1,
                       CardDecks mainDeck1,
                       int playerTurn1,
                       int countCards1,
                       int countDraw1
){

    options=options1;
    allPlayers=allPlayers1;
    System.out.println(allPlayers);
    resPlayer =res1;
    cardChoices=cardChoices1;

    mainDeck=mainDeck1;
    playerTurn=playerTurn1;
    countCards =countCards1;
    countDraw=countDraw1;




}
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        retour.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Back.css")).toExternalForm());
        page2Visible(false);
        wonders.addAll(Arrays.asList(Wonder.values()));

        res.addAll(ProgressTokens.TOKENS);

        imagePartie.setImage(partiePNG);
        labelTitle.setText("Tour d'une partie : ");
    }

    public void onButton1() {
        page2Visible(false);
        imageWonder.setImage(null);
        imageToken.setImage(null);
        image2Joueur.setImage(null);
        imageFin.setImage(null);
        finDescription.setText("");
        joueurDescription.setText("");

        imagePartie.setImage(partiePNG);
        labelTitle.setText("Tour d'une partie : ");
    }

    public void onButton2() {
        page2Visible(false);
        imageWonder.setImage(null);
        imageToken.setImage(null);
        imagePartie.setImage(null);

        labelTitle.setText("Info suplémentaire : ");
        image2Joueur.setImage(joueurPNG);
        imageFin.setImage(finPNG);

        joueurDescription.setText("Pour une partie à 2 joueurs, la seule adaptation concerne la phase de résolution d'une Bataille.\n" +
                "Si votre nombre de Boucliers est supérieur à celui de votre adversaire, prenez 1 jeton Victiore Militaire.\n" +
                "Par contre, si vous aves au minimum 2 fois plus de Boucliers que votre adversaire, prenez 2 jetons Victoire Militaire.");

        finDescription.setText("L'orsqu'un joueur termine la contruction de sa Merveille, la partie s'achève à la fin de son tour de jeu.\n" +
                "Calculez votre score en additionnant les points de victoire se trouvant éventuellement sur:\n" +
                "\t- les étapes construites de votre Merveille\n" +
                "\t- le pion Chat s'il est en votre possession\n" +
                "\t- vos cartes Bleues\n" +
                "\t- vos jetons Victoire Militaire\n" +
                "\t- vos jetons Progrès\n" +
                "Le joueur qui obtient le plus élevé remporte la partie.\n" +
                "En cas d'égalité, le joueur ayant construit le plus d'étapes l'emporte.\n" +
                "En cas de nouvelle égalité, les joueur concernés se partagent la victoire.");

    }

    public void onButton3() {
        page2Visible(true);
        imagePartie.setImage(null);
        image2Joueur.setImage(null);
        imageFin.setImage(null);
        finDescription.setText("");
        joueurDescription.setText("");

        labelTitle.setText("Jetons & Merveilles : ");

        setToken(currentRes);
        setWonder(currentWonder);
    }

    public void onLeftToken() {
        currentRes = (currentRes == 0)? res.size()-1:currentRes-1;
        setToken(currentRes);
    }

    public void onRightToken() {
        currentRes = (currentRes == res.size()-1)? 0:currentRes+1;
        setToken(currentRes);
    }

    public void onLeftWonder() {
        currentWonder = (currentWonder == 0)? wonders.size()-1:currentWonder-1;
        setWonder(currentWonder);
    }

    public void onRightWonder() {
        currentWonder = (currentWonder == wonders.size()-1)? 0:currentWonder+1;
        setWonder(currentWonder);
    }

    public void setToken(int position) {
        imageToken.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(res.get(position).imageResource))));
        tokenName.setText(res.get(position).displayName);
        tokenDescription.setText(res.get(position).effectDescription);
    }

    public void setWonder(int position) {
        imageWonder.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(images[position]))));
        nameWonder.setText(wonders.get(position).displayName);
        descriptionWonder.setText(wonders.get(position).effectDescription);
    }

    public void page2Visible(boolean disable) {
        outlineToken.setVisible(disable);
        outlineWonder.setVisible(disable);

        buttonLeftToken.setVisible(disable);
        buttonRightToken.setVisible(disable);
        buttonLeftWonder.setVisible(disable);
        buttonRightWonder.setVisible(disable);

        nameWonder.setText("");
        descriptionWonder.setText("");
        tokenName.setText("");
        tokenDescription.setText("");
    }

    public void onRetour(Event event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Stage stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

     if(allPlayers.size()!=0) {
         MenuControleur menuControleur = loader.getController();
         menuControleur.sauvegarde(options, allPlayers, cardChoices, res, mainDeck, playerTurn, countCards, countDraw);
     }

        stage.setScene(scene);
        stage.show();
    }
}

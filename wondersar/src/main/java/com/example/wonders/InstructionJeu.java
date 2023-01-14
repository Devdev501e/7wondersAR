package com.example.wonders;

import domain.ProgressToken;
import domain.ProgressTokens;
import domain.Wonder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class InstructionJeu implements Initializable {
    @FXML
    private Button page1;
    @FXML
    private Button page2;
    @FXML
    private Button page3;
    @FXML
    private Label labelTitle;

    @FXML
    private ImageView imagePartie;
    private Image partiePNG = new Image(getClass().getResourceAsStream("images/imagejeu/tourDuJeu.png"));

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
    private Image joueurPNG = new Image(getClass().getResourceAsStream("images/imagejeu/partie2joueur.png"));
    @FXML
    private Label joueurDescription;
    @FXML
    private ImageView imageFin;
    private Image finPNG = new Image(getClass().getResourceAsStream("images/imagejeu/findepartie.png"));
    @FXML
    private Label finDescription;
    @FXML
    Button retour;

    private ArrayList<ProgressToken> res = new ArrayList<>();
    private int currentRes = 0;
    private String[] images = {"images/imagejeu/alexandrie_icon.png", "images/imagejeu/halicarnasse_icon.png", "images/imagejeu/ephese_icon.png", "images/imagejeu/olympie_icon.png", "images/imagejeu/babylon_icon.png", "images/imagejeu/rhodes_icon.png", "images/imagejeu/gizeh_icon.png"};
    private int currentWonder = 0;
    private ArrayList<Wonder> wonders = new ArrayList<>();

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        retour.getStylesheets().add(getClass().getResource("Back.css").toExternalForm());
        page2Visible(false);
        wonders.addAll(Arrays.asList(Wonder.values()));

        ProgressTokens progressTokens = new ProgressTokens();
        res.addAll(progressTokens.TOKENS);

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
        imageToken.setImage(new Image(getClass().getResourceAsStream(res.get(position).imageResource)));
        tokenName.setText(res.get(position).displayName);
        tokenDescription.setText(res.get(position).effectDescription);
    }

    public void setWonder(int position) {
        imageWonder.setImage(new Image(getClass().getResourceAsStream(images[position])));
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

    public void onRetour() throws IOException {
        FXMLLoader root =  new FXMLLoader(getClass().getResource("menu.fxml"));
        Stage stage = (Stage) imagePartie.getScene().getWindow();
        Scene scene = new Scene(root.load(), 800, 550);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.setTitle("7 Wonders: Architecture");
        stage.show();
    }
}

package com.example.wonders;

import domain.CardDecks;
import domain.Player;
import domain.ProgressToken;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuControleur implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Button instruction;
    @FXML
    private Button exit;
    @FXML
     private Button resume;
    //------------------------------------------------------------------ Sauvegarde

    ArrayList<CardDecks> options;
    CardDecks mainDeck;
    int playerTurn;
    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<ProgressToken> res;
    int countCards;
    private int countDraw;

    private boolean additionalChoice;

    ArrayList<String> cardChoices;



//---------------------------------------------------------------------------------------------

    public void sauvegarde(ArrayList<CardDecks> options1, ArrayList<Player> allPlayers1, ArrayList<String> cardChoices1,
                           ArrayList<ProgressToken> res1, CardDecks mainDeck1, int playerTurn1, int countCards1,
                           int countDraw1, boolean additionalChoice1){

        options=options1;
        allPlayers=allPlayers1;
        System.out.println(allPlayers);
        res =res1;
        cardChoices=cardChoices1;
        additionalChoice = additionalChoice1;

        mainDeck=mainDeck1;
        playerTurn=playerTurn1;
        countCards =countCards1;
        countDraw=countDraw1;
        resume.setVisible(true);



    }
    public void resume(Event event) throws Exception{
        Stage stage;
        Scene scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameView.fxml"));
        Parent root = loader.load();
        stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);


           GameController gameController = loader.getController();
           gameController.startTurn(allPlayers, mainDeck, res, playerTurn, "save", countCards, countDraw, additionalChoice);


        stage.setScene(scene);
        stage.show();
    }

    public void button(Event event) throws IOException {
     Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixPerso.fxml")));
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     Scene scene = new Scene(root);

     stage.setScene(scene);

     stage.show();

    }

    public void onInstructions(Event event) throws IOException {
        Stage stage;
        Scene scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("instructionJeu.fxml"));
        Parent root = loader.load();
        stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if(allPlayers.size()!=0) {
            InstructionJeu instructionJeu = loader.getController();
            instructionJeu.sauvegarde(options, allPlayers, cardChoices, res, mainDeck, playerTurn, countCards, countDraw, additionalChoice);
        }

        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resume.setVisible(false);
        resume.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Resume.css")).toExternalForm());

        exit.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Exit.css")).toExternalForm());
        button.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());


        instruction.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Instruction.css")).toExternalForm());
    }
    public void quiter() throws IOException{
        Platform.exit();
    }
}
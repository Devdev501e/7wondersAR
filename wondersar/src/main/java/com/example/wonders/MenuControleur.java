package com.example.wonders;

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
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuControleur implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Button instruction;


    public void button(Event event) throws IOException {
     Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixPerso.fxml")));
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     Scene scene = new Scene(root);

     stage.setScene(scene);

     stage.show();

    }

    public void onInstructions() throws IOException {
        FXMLLoader root =  new FXMLLoader(getClass().getResource("instructionJeu.fxml"));
        Stage stage = (Stage) instruction.getScene().getWindow();
        Scene scene = new Scene(root.load());

        stage.setScene(scene);
        stage.setTitle("Règles du jeu");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());


        instruction.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Instruction.css")).toExternalForm());
    }
}
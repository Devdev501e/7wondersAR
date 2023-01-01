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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChoixpersoControleur implements Initializable {
    @FXML
    private Button retour;
    @FXML
    private Button valider;

    @FXML
    public ChoiceBox<String> myChoiceBox;
    public String[] NP ={"2","3","4","5","6","7"};

    @FXML
    private TextField nameTextField;
    String[] wonderNames = {"Alexandrie", "Halicarnasse", "Ephese", "Olympie", "Babylone", "Rhodes", "Gizeh"};

    private Stage stage;
    private Scene scene;
    private final Image image = new Image(getClass().getResourceAsStream("images/imagejeu/retour.png"));
    private final ImageView icon = new ImageView(image);

    private final Image image2 = new Image(getClass().getResourceAsStream("images/imagejeu/valider1.png"));
    private final ImageView icon2 = new ImageView(image2);
    private Parent root;
    private int nombre;
    private Wonder wonderChoice;
    private ArrayList<Player> players = new ArrayList<>();



    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        nameTextField.setVisible(false);
        retour.setGraphic(icon);
        valider.setGraphic(icon2);

        myChoiceBox.getItems().addAll(NP);//chose box
        myChoiceBox.setOnAction(this::getNumber);

    }

    public void getNumber(Event event) {
        if (myChoiceBox.getValue()!=null) {
            nombre = Integer.parseInt(myChoiceBox.getValue());

            nameTextField.setVisible(true);
            myChoiceBox.setValue(null);
            myChoiceBox.getItems().removeAll(NP);
            myChoiceBox.getItems().addAll(wonderNames);

            myChoiceBox.setOnAction(this::getWonderChoice);
        }
    }

    public void getWonderChoice(Event event) {
        wonderChoice = Wonder.valueOf(myChoiceBox.getValue());
        System.out.println(wonderChoice);
    }

    public void onConfirmButton(Event event) throws IOException{
        String name = nameTextField.getText();
        players.add(new Player(name, wonderChoice, new Hand(new ArrayList<>(), new ArrayList<>()),false, new ArrayList<>()));
        System.out.println(players);
        if (players.size() == nombre) {
            //user proofing
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public void switchScene(Event event)throws IOException{

        if (myChoiceBox.getValue() != null) {

        }
    }


    public void retour (Event event) throws  IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
}

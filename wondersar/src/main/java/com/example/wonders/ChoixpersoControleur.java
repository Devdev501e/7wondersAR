package com.example.wonders;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoixpersoControleur implements Initializable {
    @FXML
    private Button retour;
    @FXML
    private Button valider;

    @FXML
    public ChoiceBox<String> myChoiceBox;
    public String[] NP ={"2","3","4","5","6","7"};
    private Stage stage;
    private Scene scene;
    private final Image image = new Image(getClass().getResourceAsStream("images/imagejeu/retour.png"));
    private final ImageView icon = new ImageView(image);

    private final Image image2 = new Image(getClass().getResourceAsStream("images/imagejeu/valider1.png"));
    private final ImageView icon2 = new ImageView(image2);
    private Parent root;
    private String number;
    private int nombre;



    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        valider.setVisible(false);
        retour.setGraphic(icon);
        valider.setGraphic(icon2);

        myChoiceBox.getItems().addAll(NP);//chose box
        myChoiceBox.setOnAction(this::getNumber);
    }

    public void getNumber(Event event) {
        if (myChoiceBox.getValue()!=null) {
            valider.setVisible(true);

            number = myChoiceBox.getValue();
            nombre = Integer.parseInt(number);
        }
    }


    public void switchScene(Event event)throws IOException{
        if (myChoiceBox.getValue() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
            root = loader.load();

            Scene1Controleur scene1Controleur=loader.getController();
            scene1Controleur.number(nombre);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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

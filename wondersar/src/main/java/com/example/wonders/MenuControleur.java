package com.example.wonders;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuControleur implements Initializable {
    @FXML
    private Button button;
    @FXML
    private ImageView imageView;
    @FXML
    private Label label;

    private Image myimage;
    @FXML
    private Button instruction;
    private Scene scene;
    private Stage stage;
    private final Image image = new Image(getClass().getResourceAsStream("images/imagejeu/startvr.png"));
    private final Image image2 = new Image(getClass().getResourceAsStream("images/imagejeu/instruction.png"));
    private final ImageView start = new ImageView(image);
    private final ImageView intruction = new ImageView(image2);

    public void button(Event event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("ChoixPerso.fxml"));
     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     scene = new Scene(root);

     stage.setScene(scene);

     stage.show();

    }
    public void surbrillance(Event event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


        instruction.setGraphic(intruction);
    }
}
package com.example.wonders;

import domain.ConstructionPiece;
import domain.Player;
import domain.ProgressToken;
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

import java.net.URL;
import java.util.*;

public class EndScreen implements Initializable {
    @FXML
    private ImageView imagePodium = new ImageView();
    private final Image podiumPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/podium.png")));
    @FXML
    private Label player1st;
    @FXML
    private Label player2nd;
    @FXML
    private Label player3rd;
    @FXML
    private Label loserLabel;
    @FXML
    private ImageView imageMedal = new ImageView();
    private final Image medalPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/imagejeu/1st_place.png")));
    @FXML
    private Label playerWinner;
    @FXML
    Button back;
    ArrayList<Label> playerLabels = new ArrayList<>();

    public void getInfo(ArrayList<Player> players) {
        System.out.println(players);
        playerLabels.add(player1st);
        playerLabels.add(player2nd);
        playerLabels.add(player3rd);
        playerLabels.add(loserLabel);
        ArrayList<Player> playerOrder = calculateFinalPoints(players);
        for (Player i : playerOrder) {
            System.out.println(i.getName());
        }
        if (players.size() == 2) {
            imageMedal.setImage(medalPNG);
            playerWinner.setText(playerOrder.get(0).getName()+"("+playerOrder.get(0).getTotalPoints()+" points)");
            loserLabel.setText(playerOrder.get(1).getName()+"("+playerOrder.get(1).getTotalPoints()+" points)");
        }
        else {
            imagePodium.setImage(podiumPNG);
            for (int i = 0; i < players.size(); i++) {
                int num = Math.min(players.size()-1, 3);
                playerLabels.get(num).setText(playerLabels.get(num).getText()+i+". "+playerOrder.get(i).getName()+"("+playerOrder.get(i).getTotalPoints()+" points)\n");
            }
        }
    }

    public ArrayList<Player> calculateFinalPoints(ArrayList<Player> allPlayers) {
        for (Player i : allPlayers) {
            int cultureCount = 0;

            for (ProgressToken j : i.getAllTokens()) {
                //points vennant de jetons scientifique
                switch (j) {
                    case Decoration:
                        boolean totalCompletion = true;
                        for (ConstructionPiece k : i.getWonderContruction().getAllPieces()) {
                            if (!k.isComplete()) {
                                totalCompletion = false;
                                break;
                            }
                        }
                        if (totalCompletion) {
                            i.setTotalPoints(i.getTotalPoints()+6);
                        } else {
                            i.setTotalPoints(i.getTotalPoints()+4);
                        }
                        break;
                    case Politic:
                        i.setTotalPoints((i.getTotalPoints()+(i.getHand().getPointVictoire()[0]/2)));
                        break;
                    case Strategy:
                        int nbMilitaryTokens = i.getHand().getMilitaryPoints()/3;
                        i.setTotalPoints(i.getTotalPoints()+nbMilitaryTokens);
                        break;
                    case Education:
                        for (int k = 0; k < i.getAllTokens().size(); k++) {
                            i.setTotalPoints(i.getTotalPoints()+1);
                        }
                        break;
                    case Culture:
                        cultureCount++;
                        break;
                }
            }
            if (cultureCount == 1) {
                i.setTotalPoints(i.getTotalPoints()+4);
            }
            else if (cultureCount == 2) {
                i.setTotalPoints(i.getTotalPoints()+12);
            }

            //points vennant de construction
            for (ConstructionPiece j : i.getWonderContruction().getAllPieces()) {
                if (j.isComplete()) {
                    i.setTotalPoints(i.getTotalPoints()+ j.getPoints());
                }
            }

            //points vennant de guerre
            i.setTotalPoints(i.getTotalPoints()+i.getHand().getMilitaryPoints());

            //points vennant de carte bleu
            i.setTotalPoints(i.getTotalPoints()+ i.getHand().getPointVictoire()[0]*2);
            i.setTotalPoints(i.getTotalPoints()+ i.getHand().getPointVictoire()[1]*3);

            if (i.getChat()) {
                i.setTotalPoints(i.getTotalPoints()+2);
            }
            System.out.println(i.getName()+": "+i.getTotalPoints());
        }

        allPlayers.sort(Comparator.comparing(Player::getTotalPoints));
        Collections.reverse(allPlayers);

        return allPlayers;
    }
    public void retour(Event event)throws Exception{
        Stage stage;
        Scene scene;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Back.css")).toExternalForm());
    }
}

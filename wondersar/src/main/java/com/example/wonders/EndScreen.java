package com.example.wonders;

import domain.ConstructionPiece;
import domain.Player;
import domain.ProgressToken;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class EndScreen {
    @FXML
    private ImageView imagePodium = new ImageView();
    private Image podiumPNG = new Image(getClass().getResourceAsStream("images/imagejeu/podium.png"));
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
    private Image medalPNG = new Image(getClass().getResourceAsStream("images/imagejeu/1st_place.png"));
    @FXML
    private Label playerWinner;
    ArrayList<Label> playerLabels = new ArrayList<>();

    public void getInfo(ArrayList<Player> players) {
        playerLabels.add(player1st);
        playerLabels.add(player2nd);
        playerLabels.add(player3rd);
        playerLabels.add(loserLabel);
        Player[] playerOrder = calculateFinalPoints(players);
        if (players.size() == 2) {
            imageMedal.setImage(medalPNG);
            playerWinner.setText(playerOrder[0].getName()+"("+playerOrder[0].getTotalPoints()+" points)");
            loserLabel.setText(playerOrder[1].getName()+"("+playerOrder[1].getTotalPoints()+" points)");
        }
        else {
            imagePodium.setImage(podiumPNG);
            for (int i = 0; i < players.size(); i++) {
                int num = Math.min(players.size()-1, 3);
                playerLabels.get(num).setText(playerLabels.get(num).getText()+i+". "+playerOrder[i].getName()+"("+playerOrder[i].getTotalPoints()+" points)\n");
            }
        }
    }

    public Player[] calculateFinalPoints(ArrayList<Player> allPlayers) {
        Player[] playerWinner = new Player[allPlayers.size()];
        Player temp;
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
                i.setTotalPoints(i.getTotalPoints()+ j.getPoints());
            }

            //points vennant de guerre
            i.setTotalPoints(i.getTotalPoints()+i.getHand().getMilitaryPoints());

            //points vennant de carte bleu
            i.setTotalPoints(i.getTotalPoints()+ i.getHand().getPointVictoire()[0]*2);
            i.setTotalPoints(i.getTotalPoints()+ i.getHand().getPointVictoire()[1]*3);

            if (i.getChat()) {
                i.setTotalPoints(i.getTotalPoints()+2);
            }
        }

        for (int i = 0; i < allPlayers.size(); i++) {
            for (int j=1+i; j < allPlayers.size()-1; i++) {
                if (allPlayers.get(i).getTotalPoints() > allPlayers.get(j).getTotalPoints()) {
                    temp = allPlayers.get(i);
                    playerWinner[i] = allPlayers.get(j);
                    allPlayers.add(j, temp);
                }
            }
        }
        return playerWinner;
    }
}

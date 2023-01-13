package com.example.wonders;

import domain.ConstructionPiece;
import domain.Player;
import domain.ProgressToken;

import java.util.ArrayList;

public class EndScreen {

    public void getInfo(ArrayList<Player> players) {

    }

    public void calculateFinalPoints(ArrayList<Player> allPlayers) {
        for (Player i : allPlayers) {
            int cultureCount = 0;

            //points vennant de jetons scientifique
            for (ProgressToken j : i.getAllTokens()) {
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

            //points vennant de guerre

            //points vennant de carte bleu
        }
    }
}

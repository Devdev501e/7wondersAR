package domain;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {
    Scanner sc = new Scanner(System.in);

    public ArrayList<Player> createPlayers(int nbPlayer, ChoiceBox choiceBox, TextField textField, ArrayList<Player> players,ArrayList<String> choicestring) {
        ArrayList<Card> card=new ArrayList<>();

        if (players.size()< nbPlayer) {
            Wonder wonder = Wonder.valueOf((String) choiceBox.getValue());
            choicestring.remove( choiceBox.getValue());

            Player player = new Player(textField.getText(),wonder, new Hand(new ArrayList<>(), new ArrayList<>()),false,card);
            players.add(player);

            return players;
        }
        else {
            return players;
        }
    }

    public ArrayList<CardDecks> createPlayerDecks(ArrayList<Player> players) {
        ArrayList<CardDecks> playerDecks = new ArrayList<>();
        for (Player i : players) {
            String wonder = i.getWonder().getDisplayName();

            CardDecks cardDecks = new CardDecks(wonder);
            cardDecks.shuffleDeck();

            playerDecks.add(cardDecks);
        }

        return playerDecks;
    }

    public ArrayList<CardDecks> cardDecksOption(ArrayList<CardDecks> playerDecks, int playerPosition) {
        ArrayList<CardDecks> cardDecksOptions = new ArrayList<>();

        cardDecksOptions.add(playerDecks.get(playerPosition));
        if (playerPosition == 0) {
            cardDecksOptions.add(playerDecks.get(playerDecks.size()-1));
        }
        else {
            cardDecksOptions.add(playerDecks.get(playerPosition-1));
        }

        return cardDecksOptions;
    }

    public Card cardChoice(ArrayList<CardDecks> options, CardDecks mainDeck) {
        int count = 1;

        for (CardDecks i : options) {
            System.out.print("[" + count + "] " + i.getCard(0).getFront().cardDisplayName + " ");
            count ++;
        }
        System.out.println("[" + count + "] " + "Main");
        int choice = sc.nextInt();

        CardDecks deckChoice;
        if (choice == 3) { deckChoice = mainDeck; }
        else { deckChoice = options.get(choice-1); }

        return deckChoice.chooseCard();
    }

    public boolean canBuildPiece(ConstructionPiece piece, Player player) {
        int nbResources = piece.getNbPieces();
        boolean isEqual = piece.isEqual();

        if (isEqual) {
            boolean canBuild = false;
            for (int i = 0; i < 4; i++) {
                int samePieces = player.getHand().getMaterials().get(i) + player.getHand().getMaterials().get(5);
                if (samePieces >= nbResources) {
                    canBuild = true;
                    break;
                }
            }
            return canBuild;
        }
        else {
            int differentPieces = 0;
            for (int i : player.getHand().getMaterials()) {
                if ( i != 0) {
                    differentPieces++;
                }
            }
            return differentPieces >= nbResources;
        }
    }

    public void buildPiece(ConstructionPiece piece, Player player, ArrayList<Card> cardToUse) {

    }
}

package domain;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {
    Scanner sc = new Scanner(System.in);

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

    public Material getMaterialType(int number) {
        Material material = null;

        switch (number) {
            case 0:
                material = Material.Wood;
                break;
            case 1:
                material = Material.Paper;
                break;
            case 2:
                material = Material.Brick;
                break;
            case 3:
                material = Material.Stone;
                break;
            case 4:
                material = Material.Glass;
                break;
        }

        return material;
    }

    public Card cardChoice(Player player, ArrayList<CardDecks> options, CardDecks mainDeck) {
        int count = 1;

        for (CardDecks i : options) {
            System.out.print("[" + count + "] " + i.getCard(0).getFront().cardDisplayName + " ");
            count ++;
        }

        if (player.getChat()) {
            System.out.println("[" + count + "] " + mainDeck.getCard(0).getFront().cardDisplayName);
        }
        else {
            System.out.println("[" + count + "] " + "Main");
        }

        int choice = sc.nextInt();
        CardDecks deckChoice;
        if (choice == 3) {deckChoice = mainDeck;}
        else {deckChoice = options.get(choice-1);}
        return deckChoice.chooseCard();
    }

    public boolean canBuildPiece(ConstructionPiece piece, Player player) {
        int nbResources = piece.getNbPieces();
        boolean isEqual = piece.isEqual();

        if (isEqual) {
            boolean canBuild = false;
            for (int i = 0; i < 5; i++) {
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
            for (int i = 0; i < 5; i++) {
                differentPieces = (player.getHand().getMaterials().get(i) != 0)? differentPieces++:differentPieces;
            }
            differentPieces += player.getHand().getMaterials().get(5);
            return differentPieces >= nbResources;
        }
    }

    public void buildPiece(ConstructionPiece piece, Player player) {
        piece.setComplete(true);

        int nbResources = piece.getNbPieces();
        boolean isEqual = piece.isEqual();

        ArrayList<Card> cardsToRemove = new ArrayList<>();

        if (isEqual) {
            int max = 0;
            int intMaterial = 0;
            Material material;

            for (int i = 0; i < 5; i++) {
                if (max < player.getHand().getMaterials().get(i)) {
                    max = player.getHand().getMaterials().get(i);
                    intMaterial = i;
                }
            }

            int nbGold = nbResources - max;
            player.getHand().getMaterials().add(5, player.getHand().getMaterials().get(5)-nbGold);

            material = getMaterialType(intMaterial);
            player.getHand().getMaterials().add(intMaterial, 0);

            int j = 0;
            for (Card i : player.getAllPlayerCards()) {
                if (i.getFront().material == material) {
                    cardsToRemove.add(i);
                }
                if (j < nbGold) {
                    if (i.getFront().material == Material.Gold) {
                        cardsToRemove.add(i);
                        j++;
                    }
                }
            }
            player.getAllPlayerCards().removeAll(cardsToRemove);
        }
        else {
            ArrayList<Integer> intMaterialToRemove = new ArrayList<>();
            ArrayList<Material> materialToRemove = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                if (player.getHand().getMaterials().get(i) != 0) {
                    intMaterialToRemove.add(i);
                    player.getHand().getMaterials().add(i, player.getHand().getMaterials().get(i)-1);
                }
            }
            int nbGold = nbResources - intMaterialToRemove.size();
            player.getHand().getMaterials().add(5, player.getHand().getMaterials().get(5)-nbGold);

            for (int i : intMaterialToRemove) {
                materialToRemove.add(getMaterialType(i));
            }

            int j = 0;
            for (Card i : player.getAllPlayerCards()) {
                if (materialToRemove.contains(i.getFront().material)) {
                    cardsToRemove.add(i);
                    materialToRemove.remove(i.getFront().material);
                }
                if (j < nbGold) {
                    if (i.getFront().material == Material.Gold) {
                        cardsToRemove.add(i);
                        j++;
                    }
                }
            }
            player.getAllPlayerCards().removeAll(cardsToRemove);

        }

    }
}

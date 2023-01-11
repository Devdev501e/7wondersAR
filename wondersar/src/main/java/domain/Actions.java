package domain;

import java.util.ArrayList;

public class Actions {

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

    public boolean canBuildPiece(ConstructionPiece piece, Player player) {
        int nbResources = piece.getNbPieces();
        boolean isEqual = piece.isEqual();

        if (isEqual) {
            boolean canBuild = false;
            for (int i = 0; i < 5; i++) {
                int samePieces = player.getHand().getMaterials()[i] + player.getHand().getMaterials()[5];
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
                differentPieces = (player.getHand().getMaterials()[i] != 0)? differentPieces++:differentPieces;
            }
            differentPieces += player.getHand().getMaterials()[5];
            return differentPieces >= nbResources;
        }
    }public void buidPiece2 (Construction cons, Player player){
        ConstructionPiece piece;
        for(int i=0;i<5;i++){
        piece =cons.getAllPieces().get(i);
        if(canBuildPiece(piece,player) && !piece.isComplete()){
            piece.setComplete(true);
          boolean equal= piece.getEqual();
          int nbRessource =piece.getNbPieces();

          for(int k=0;k<6;k++){
          int material=  player.getHand().getMaterials()[k];

          if(equal){
              if(material + player.getHand().getMaterials()[5]>=nbRessource  ){

                  for (int n=0;n<nbRessource;n++){
                      if(player.getHand().getMaterials()[k]!=0){
                  player.getHand().removeMaterials(k);}
                  else{player.getHand().removeMaterials(5);}}
                break;}
          } else{
              if (material!=0 ){
                    player.getHand().removeMaterials(k);
                  break;
              }
          }
          }
        }
    }}

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
                if (max < player.getHand().getMaterials()[i]) {
                    max = player.getHand().getMaterials()[i];
                    intMaterial = i;
                }
            }

            int nbGold = nbResources - max;
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]-nbGold;

            material = getMaterialType(intMaterial);
            player.getHand().getMaterials()[intMaterial] = 0;

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
                if (player.getHand().getMaterials()[i] != 0) {
                    intMaterialToRemove.add(i);
                    player.getHand().removeMaterials(i);
                }
            }
            int nbGold = nbResources - intMaterialToRemove.size();
            player.getHand().getMaterials()[5] = player.getHand().getMaterials()[5]-nbGold;

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

    public void effect(Wonder wonder , CardDecks deckschoisi, Player player, ArrayList<Boolean> conflict ,Card card, ArrayList<Player> players){
        switch (wonder){
            case Olympie:
            case Alexandrie:

            case Ephese:
                player.addCard(deckschoisi.getCard(0), players);
                deckschoisi.chooseCard();
                break;


            case Babylone:


            // ajouts des jetons

            case Halicarnasse:

              player.addCard(card, players);
              break;

            case Rhodes:
                player.getHand().setShieldWar(1);
                break;

            case Gizeh:
                break;



        }

    }
}

package domain;


import java.util.ArrayList;

public class Player {
    private final String  name;
    private final  Wonder wonder;
    private final Construction wonderContruction;
    private ArrayList<Card> allPlayerCards;
    private ArrayList<ProgressToken> allTokens;
    private Hand hand;
    private Boolean chat;


    public Player(String name,Wonder wonder, Hand hand,Boolean chat, ArrayList<Card> allPlayerCards, ArrayList<ProgressToken> allTokens){
        this.name=name;
        this.wonder=wonder;
        this.hand = hand;
        this.chat=chat;
        this.allPlayerCards = allPlayerCards;
        this.allTokens = allTokens;
        this.wonderContruction = new Construction(wonder);
    }

    public String getName() {
        return name;
    }

    public Construction getWonderContruction() {
        return wonderContruction;
    }

    public Wonder getWonder() {
        return wonder;
    }

    public Boolean getChat() {
        return chat;
    }
    public void setChat(Boolean chat) {
        this.chat = chat;
    }

    public Hand getHand() {
        return hand;
    }

    public ArrayList<ProgressToken> getAllTokens() {
        return allTokens;
    }

    public ArrayList<Card> getAllPlayerCards() {
        return allPlayerCards;
    }

    public void addCard(Card card, ArrayList<Boolean> conflict) {
        this.allPlayerCards.add(card);

        switch (card.getFront().getCardCategory()) {
            case WarCard:
                this.getHand().setShieldWar(this.getHand().getShieldWar()+card.getFront().shieldCount);
                for (int i = 0; i < card.getFront().cornCount; i++) {
                    int count = 0;
                    while (!conflict.get(count)) {
                        count ++;
                    }
                    conflict.add(count, false);
                }
                break;
            case PoliticCard:
                this.getHand().setPointVictoire(this.getHand().getPointVictoire()+card.getFront().laurelCount);
                this.setChat(card.getFront().cat);
                break;
            case MaterialCard:
                switch (card.front.getMaterial()) {
                    case Gold:
                        this.getHand().addMaterials(5);
                        break;
                    case Wood:
                        this.getHand().addMaterials(0);
                        break;
                    case Brick:
                        this.getHand().addMaterials(2);
                        break;
                    case Glass:
                        this.getHand().addMaterials(4);
                        break;
                    case Paper:
                        this.getHand().addMaterials(1);
                        break;
                    case Stone:
                        this.getHand().addMaterials(3);
                        break;
                }
                break;
            case ProgressCard:
                switch (card.getFront().getScienceCategory()) {
                    case Law:
                        this.getHand().addScience(0);
                        break;
                    case Mechanic:
                        this.getHand().addScience(1);
                        break;
                    case Architect:
                        this.getHand().addScience(2);
                        break;
                }
                break;
        }
    }

    public void useCard(Card card) {
        allPlayerCards.remove(card);
    }

}


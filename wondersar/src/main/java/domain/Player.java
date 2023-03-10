package domain;


import java.util.ArrayList;

public class Player {
    private final String  name;
    private final  Wonder wonder;
    private final Construction wonderContruction;
    private final ArrayList<ProgressToken> allTokens;
    private final Hand hand;
    private Boolean chat;
    private int totalPoints;
    private final CardDecks cardDecks;
    private ArrayList<Integer> tokenIgnore;


    public Player(String name,Wonder wonder, Hand hand,Boolean chat, ArrayList<ProgressToken> allTokens){
        this.name=name;
        this.wonder=wonder;
        this.hand = hand;
        this.chat=chat;
        this.allTokens = allTokens;
        this.wonderContruction = new Construction(wonder);
        this.totalPoints = 0;
        this.cardDecks = new CardDecks(wonder.displayName);
        this.tokenIgnore = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public CardDecks getCardDecks() {
        return cardDecks;
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

    public Hand getHand() {
        return hand;
    }

    public ArrayList<ProgressToken> getAllTokens() {
        return allTokens;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public ArrayList<Integer> getTokenIgnore() {
        return tokenIgnore;
    }

    public void setTokenIgnore(ArrayList<Integer> tokenIgnore) {
        this.tokenIgnore = tokenIgnore;
    }

    public void addCard(Card card, ArrayList<Player> players) {
        switch (card.front.cardCategory) {
            case WarCard:
                this.getHand().addShield(card.front.cornCount);
                break;
            case PoliticCard:
                if (card.front.laurelCount == 2) {
                    this.getHand().setPointVictoire(0);
                }
                else {
                    this.getHand().setPointVictoire(1);
                }
                if (card.front.cat) {
                    for (Player i : players) {
                        i.chat = false;
                    }
                    this.chat = true;
                }
                break;
            case MaterialCard:
                switch (card.front.material) {
                    case Gold:
                        this.getHand().addMaterials(5);
                        if (this.getAllTokens().contains(ProgressToken.Economy)) {
                            this.getHand().addMaterials(5);
                        }
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
                switch (card.front.scienceCategory) {
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
}


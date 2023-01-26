package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardDecksTest {

    @Test
    public void cardDeckSize() {
        CardDecks cardDeckMain = new CardDecks("Main");
        CardDecks cardDeckHalicarnasse = new CardDecks("Halicarnasse");
        CardDecks cardDeckGizeh = new CardDecks("Gizeh");
        CardDecks cardDeckAlexandrie = new CardDecks("Alexandrie");
        CardDecks cardDeckEphese = new CardDecks("Ephese");
        CardDecks cardDeckOlympie = new CardDecks("Olympie");
        CardDecks cardDeckBabylone = new CardDecks("Babylone");
        CardDecks cardDeckRhodes = new CardDecks("Rhodes");
        CardDecks[] wonderDecks = {cardDeckAlexandrie, cardDeckBabylone, cardDeckRhodes, cardDeckEphese, cardDeckOlympie,cardDeckGizeh, cardDeckHalicarnasse};
        assertEquals(60, cardDeckMain.cardDeckSize());
        for (CardDecks i : wonderDecks) {
            assertEquals(25, i.cardDeckSize());
        }
    }

    @Test
    public void getCard() {
        CardDecks cardDeckMain = new CardDecks("Main");
        assertEquals(cardDeckMain.getCardDeck().get(0), cardDeckMain.getCard(0));
    }

    @Test
    public void chooseCard() {
        CardDecks cardDeckMain = new CardDecks("Main");
        cardDeckMain.chooseCard();
        assertEquals(59, cardDeckMain.cardDeckSize());
    }
}
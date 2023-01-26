package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    ArrayList<ProgressToken> allToken=new ArrayList<>();
    Hand hand=new Hand();
    Wonder wonder =Wonder.Alexandrie;
    Player player=new Player("lol",wonder,hand,true,allToken);


    @Test
    void getName() {
        assertEquals("lol",player.getName());
    }

    @Test
    void getCardDecks() {
        assertEquals(hand,player.getHand());
    }

    @Test
    void getWonderContruction() {

    }

    @Test
    void getWonder() {
        assertEquals(wonder,player.getWonder());
    }

    @Test
    void getChat() {
        assertEquals(true,player.getChat());
    }

    @Test
    void getHand() {
        assertEquals(hand,player.getHand());
    }

    @Test
    void getAllTokens() {
        assertEquals(allToken,player.getAllTokens());
    }

    @Test
    void getTotalPoints() {
        assertEquals(0,player.getTotalPoints());
    }

    @Test
    void getTokenIgnore() {
        ArrayList<Integer> tokenIgnore=new ArrayList<>();
        assertEquals(tokenIgnore,player.getTokenIgnore());
    }
}
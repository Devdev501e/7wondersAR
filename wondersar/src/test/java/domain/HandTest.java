package domain;
import domain.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private final int[] science = new int[3];
    private final int[] materials = new int[6];
    private final int[] pointVictoire = new int[2];
    private final int[] shieldCards = new int[3];
    Hand hand=new Hand();

    @Test
    void getShieldWar() {


        assertEquals(0,hand.getShieldWar());
    }

    @Test
    void getShieldCards() {


    }

    @Test
    void getPointVictoire() {
    }

    @Test
    void getMilitaryPoints() {
        assertEquals(0,hand.getMilitaryPoints());
    }

    @Test
    void getMaterials() {
    }

    @Test
    void getScience() {
    }
}
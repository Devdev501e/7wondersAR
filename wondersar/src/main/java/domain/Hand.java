package domain;

import java.util.Arrays;

public class Hand {
    private final int[] science = new int[3];
    private final int[] materials = new int[6];
    private final int[] pointVictoire = new int[2];
    private final int[] shieldCards = new int[3];
    private int shieldWar;
    private int militaryPoints;

    public Hand () {
        Arrays.fill(materials, 0);
        Arrays.fill(science, 0);
        Arrays.fill(pointVictoire, 0);
        Arrays.fill(shieldCards, 0);
        this.shieldWar = 0;
        this.militaryPoints = 0;
    }

    public void setShieldWar(int shieldWar) {
        this.shieldWar = shieldWar;
    }
    public int getShieldWar() {
        return shieldWar;
    }

    public void addShield(int shieldNumber) {
        setShieldWar(getShieldWar()+1);
        shieldCards[shieldNumber] += 1;
    }

    public int[] getShieldCards() {
        return shieldCards;
    }

    public int[] getPointVictoire() {
        return pointVictoire;
    }
    public void setPointVictoire(int position) {
        pointVictoire[position] +=1;
    }

    public int getMilitaryPoints() {
        return militaryPoints;
    }
    public void setMilitaryPoints(int militaryPoints) {
        this.militaryPoints = militaryPoints;
    }

    public int[] getMaterials() {
        return materials;
    }
    public void addMaterials(int materialNb) {
        materials[materialNb] +=1;
    }
    public void removeMaterials(int materialNb) {
        materials[materialNb] -= 1;
    }

    public int[] getScience() {
        return science;
    }
    public void addScience(int scienceNb) {
        science[scienceNb] += 1;
    }
}

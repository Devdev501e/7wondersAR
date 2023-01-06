package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    private int[] science = new int[3];
    private int[] materials = new int[6];
    private int pointVictoire;
    private int shieldWar;
    private int militaryPoints;

    public Hand () {
        Arrays.fill(materials, 0);
        Arrays.fill(science, 0);
        this.pointVictoire = 0;
        this.shieldWar = 0;
        this.militaryPoints = 0;
    }

    public void setShieldWar(int shieldWar) {
        this.shieldWar = shieldWar;
    }
    public int getShieldWar() {
        return shieldWar;
    }

    public int getPointVictoire() {
        return pointVictoire;
    }
    public void setPointVictoire(int pointVictoire) {
        this.pointVictoire = pointVictoire;
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
        materials[materialNb] = materials[materialNb]+1;
    }
    public void removeMaterials(int materialNb) {
        materials[materialNb] = materials[materialNb]-1;
    }

    public int[] getScience() {
        return science;
    }
    public void addScience(int scienceNb) {
        science[scienceNb] = science[scienceNb]+1;
    }
    public void removeScience(int scienceNb) {
        science[scienceNb] = science[scienceNb]-1;
    }
}

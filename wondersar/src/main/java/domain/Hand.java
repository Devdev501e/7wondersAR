package domain;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Integer> science;
    private ArrayList<Integer> materials;
    private int pointVictoire;
    private int shieldWar;

    public Hand (ArrayList<Integer> science, ArrayList<Integer> materials) {
        this.science = science;
        this.materials = materials;
        this.pointVictoire = 0;
        this.shieldWar = 0;
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

    public ArrayList<Integer> getMaterials() {
        return materials;
    }
    public void addMaterials(int materialNb) {
        materials.add(materialNb, 1);
    }
    public void removeMaterials(int materialNb) {
        int previousQuantity = materials.get(materialNb);
        materials.add(materialNb, Math.max(previousQuantity-1, 0));
    }

    public ArrayList<Integer> getScience() {
        return science;
    }
    public void addScience(int scienceNb) {
        science.add(scienceNb, 1);
    }
    public void removeScience(int scienceNb) {
        int previousQuantity = science.get(scienceNb);
        science.add(scienceNb, Math.max(previousQuantity-1, 0));
    }
}

package domain;

public class ConstructionPiece {
    private final int layer;
    private final int points;
    private final boolean equal;
    private final int nbPieces;
    private boolean complete;
    private final boolean power;

    public ConstructionPiece(int layer, int points, boolean equal, int nbPieces,boolean power, boolean complete) {
        this.layer = layer;
        this.points = points;
        this.equal = equal;
        this.nbPieces = nbPieces;
        this.complete = complete;
        this.power = power;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public int getLayer() {
        return layer;
    }

    public int getPoints() {
        return points;
    }

    public boolean isPower() {
        return power;
    }

    public boolean isEqual() {
        return equal;
    }

    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}


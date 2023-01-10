package domain;

public class ConstructionPiece {
    private final int points;
    private final boolean equal;
    private final int nbPieces;
    private boolean complete;
    private final boolean power;

    public ConstructionPiece(int points, boolean equal, int nbPieces,boolean power, boolean complete) {
        this.points = points;
        this.equal = equal;
        this.nbPieces = nbPieces;
        this.complete = complete;
        this.power = power;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public int getPoints() {
        return points;
    }
    public boolean getEqual(){
        return equal;
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


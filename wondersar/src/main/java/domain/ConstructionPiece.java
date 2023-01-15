package domain;

public class ConstructionPiece {
    private final int points;
    private boolean equal;
    private final int nbPieces;
    private boolean complete;

    public ConstructionPiece(int points, boolean equal, int nbPieces, boolean complete) {
        this.points = points;
        this.equal = equal;
        this.nbPieces = nbPieces;
        this.complete = complete;
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

    public boolean isEqual() {
        return equal;
    }

    public void setEqual(boolean equal) {
        this.equal = equal;
    }

    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}


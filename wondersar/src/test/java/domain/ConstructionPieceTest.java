package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructionPieceTest {
    ConstructionPiece constructionPiece = new ConstructionPiece(2, false, 4, false);

    @Test
    public void getNbPieces() {
        assertEquals(4, constructionPiece.getNbPieces());
    }

    @Test
    public void getPoints() {
        assertEquals(2, constructionPiece.getPoints());
    }

    @Test
    public void getEqual() {
        assertEquals(false, constructionPiece.getEqual());
    }

    @Test
    public void isComplete() {
        assertEquals(false, constructionPiece.isComplete());
    }
}
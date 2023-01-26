package tests;


 import domain.ConstImage;
 import org.junit.Test;

 import static org.junit.Assert.*;

public class ConstImageTest {
    ConstImage constImageH = ConstImage.Halicarnasse;

    @Test
   public void getConstruction1() {
        assertEquals("alexandrie/piece-back-alexandrie-1.png", constImageH.getConstruction1(false));
    }

}
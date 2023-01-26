package domain;


import org.junit.Test;
import static org.junit.Assert.*;

public class ConstimageTest {

    ConstImage constImageH = ConstImage.Halicarnasse;
    ConstImage constImageG = ConstImage.Giseh;
    ConstImage constImageB = ConstImage.Babylon;
    ConstImage constImageE = ConstImage.Ephese;
    ConstImage constImageO = ConstImage.Olympie;
    ConstImage constImageR = ConstImage.Rhodes;
    ConstImage constImageA = ConstImage.Alexandrie;

    @Test
    public void getConstruction1() {
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-1.png", constImageH.getConstruction1(false));
        assertEquals("images/wonders/giseh/piece-back-giseh-1.png", constImageG.getConstruction1(false));
        assertEquals("images/wonders/babylon/piece-back-babylon-1.png", constImageB.getConstruction1(false));
        assertEquals("images/wonders/ephese/piece-back-ephese-1.png", constImageE.getConstruction1(false));
        assertEquals("images/wonders/olympie/piece-back-olympie-1.png", constImageO.getConstruction1(false));
        assertEquals("images/wonders/rhodes/piece-back-rhodes-2.png", constImageR.getConstruction1(false));
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-1.png", constImageA.getConstruction1(false));        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-1.png", constImageH.getConstruction1(false));
        assertEquals("images/wonders/giseh/piece-front-giseh-1.png", constImageG.getConstruction1(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-1.png", constImageB.getConstruction1(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-1.png", constImageE.getConstruction1(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-1.png", constImageO.getConstruction1(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-2.png", constImageR.getConstruction1(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-1.png", constImageA.getConstruction1(true));
    } @Test
    public void getConstruction2() {
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-2.png", constImageH.getConstruction2(false));
        assertEquals("images/wonders/giseh/piece-back-giseh-2.png", constImageG.getConstruction2(false));
        assertEquals("images/wonders/babylon/piece-back-babylon-2.png", constImageB.getConstruction2(false));
        assertEquals("images/wonders/ephese/piece-back-ephese-2.png", constImageE.getConstruction2(false));
        assertEquals("images/wonders/olympie/piece-back-olympie-3.png", constImageO.getConstruction2(false));
        assertEquals("images/wonders/rhodes/piece-back-rhodes-1.png", constImageR.getConstruction2(false));
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-4.png", constImageA.getConstruction2(false));        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-1.png", constImageH.getConstruction1(false));
        assertEquals("images/wonders/giseh/piece-front-giseh-2.png", constImageG.getConstruction2(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-2.png", constImageB.getConstruction2(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-2.png", constImageE.getConstruction2(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-3.png", constImageO.getConstruction2(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-1.png", constImageR.getConstruction2(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-2.png", constImageA.getConstruction2(true));
    }






}
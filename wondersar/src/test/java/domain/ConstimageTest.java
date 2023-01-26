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
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-1.png", constImageA.getConstruction1(false));
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-1.png", constImageH.getConstruction1(true));
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
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-4.png", constImageA.getConstruction2(false));
        ;
        assertEquals("images/wonders/halicarnasse/piece-front-halicarnasse-2.png", constImageH.getConstruction2(true));
        assertEquals("images/wonders/giseh/piece-front-giseh-2.png", constImageG.getConstruction2(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-2.png", constImageB.getConstruction2(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-2.png", constImageE.getConstruction2(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-3.png", constImageO.getConstruction2(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-1.png", constImageR.getConstruction2(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-2.png", constImageA.getConstruction2(true));
    }
    @Test
    public void getConstruction3() {
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-4.png", constImageH.getConstruction3(false));
        assertEquals("images/wonders/giseh/piece-back-giseh-3.png", constImageG.getConstruction3(false));
        assertEquals("images/wonders/babylon/piece-back-babylon-4.png", constImageB.getConstruction3(false));
        assertEquals("images/wonders/ephese/piece-back-ephese-4.png", constImageE.getConstruction3(false));
        assertEquals("images/wonders/olympie/piece-back-olympie-2.png", constImageO.getConstruction3(false));
        assertEquals("images/wonders/rhodes/piece-back-rhodes-3.png", constImageR.getConstruction3(false));
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-2.png", constImageA.getConstruction3(false));
        assertEquals("images/wonders/halicarnasse/piece-front-halicarnasse-4.png", constImageH.getConstruction3(true));
        assertEquals("images/wonders/giseh/piece-front-giseh-3.png", constImageG.getConstruction3(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-4.png", constImageB.getConstruction3(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-4.png", constImageE.getConstruction3(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-2.png", constImageO.getConstruction3(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-3.png", constImageR.getConstruction3(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-4.png", constImageA.getConstruction3(true));
    }
    @Test
    public void getConstruction4() {
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-3.png", constImageH.getConstruction4(false));
        assertEquals("images/wonders/giseh/piece-back-giseh-4.png", constImageG.getConstruction4(false));
        assertEquals("images/wonders/babylon/piece-back-babylon-5.png", constImageB.getConstruction4(false));
        assertEquals("images/wonders/ephese/piece-back-ephese-3.png", constImageE.getConstruction4(false));
        assertEquals("images/wonders/olympie/piece-back-olympie-4.png", constImageO.getConstruction4(false));
        assertEquals("images/wonders/rhodes/piece-back-rhodes-4.png", constImageR.getConstruction4(false));
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-3.png", constImageA.getConstruction4(false));
        assertEquals("images/wonders/halicarnasse/piece-front-halicarnasse-3.png", constImageH.getConstruction4(true));
        assertEquals("images/wonders/giseh/piece-front-giseh-4.png", constImageG.getConstruction4(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-5.png", constImageB.getConstruction4(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-3.png", constImageE.getConstruction4(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-4.png", constImageO.getConstruction4(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-4.png", constImageR.getConstruction4(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-3.png", constImageA.getConstruction4(true));
    }    @Test
    public void getConstruction5() {
        assertEquals("images/wonders/halicarnasse/piece-back-halicarnasse-5.png", constImageH.getConstruction5(false));
        assertEquals("images/wonders/giseh/piece-back-giseh-5.png", constImageG.getConstruction5(false));
        assertEquals("images/wonders/babylon/piece-back-babylon-6.png", constImageB.getConstruction5(false));
        assertEquals("images/wonders/ephese/piece-back-ephese-6.png", constImageE.getConstruction5(false));
        assertEquals("images/wonders/olympie/piece-back-olympie-5.png", constImageO.getConstruction5(false));
        assertEquals("images/wonders/rhodes/piece-back-rhodes-5.png", constImageR.getConstruction5(false));
        assertEquals("images/wonders/alexandrie/piece-back-alexandrie-6.png", constImageA.getConstruction5(false));
        assertEquals("images/wonders/halicarnasse/piece-front-halicarnasse-5.png", constImageH.getConstruction5(true));
        assertEquals("images/wonders/giseh/piece-front-giseh-5.png", constImageG.getConstruction5(true));
        assertEquals("images/wonders/babylon/piece-front-babylon-6.png", constImageB.getConstruction5(true));
        assertEquals("images/wonders/ephese/piece-front-ephese-6.png", constImageE.getConstruction5(true));
        assertEquals("images/wonders/olympie/piece-front-olympie-5.png", constImageO.getConstruction5(true));
        assertEquals("images/wonders/rhodes/piece-front-rhodes-5.png", constImageR.getConstruction5(true));
        assertEquals("images/wonders/alexandrie/piece-front-alexandrie-6.png", constImageA.getConstruction5(true));
    }







}
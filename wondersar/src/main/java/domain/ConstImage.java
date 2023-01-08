package domain;

public enum ConstImage {

    AlexandrieBack("alexandrie/piece-back-alexandrie-1.png","alexandrie/piece-back-alexandrie-4.png","alexandrie/piece-back-alexandrie-2.png","alexandrie/piece-back-alexandrie-3.png","alexandrie/piece-back-alexandrie-6.png"),
    BabylonBack("babylon/piece-back-babylon-1.png","babylon/piece-back-babylon-2.png","babylon/piece-back-babylon-4.png","babylon/piece-back-babylon-5.png","babylon/piece-back-babylon-6.png"),
    Ephese("ephese/piece-back-ephese-5.png","ephese/piece-back-ephese-2.png","ephese/piece-back-ephese-4.png","ephese/piece-back-ephese-3.png","ephese/piece-back-ephese-6.png"),
    Giseh("giseh/piece-back-giseh-1.png","giseh/piece-back-giseh-1.png","giseh/piece-back-giseh-2.png","giseh/piece-back-giseh-3.png","giseh/piece-back-giseh-4.png"),
    Halicarnasse("halicarnasse/piece-back-halicarnasse-1.png","halicarnasse/piece-back-halicarnasse-2.png","halicarnasse/piece-back-halicarnasse-4.png","halicarnasse/piece-back-halicarnasse-3.png","halicarnasse/piece-back-halicarnasse-5.png"),
    Olympie("","","","",""),
    Rhodes("rhodes/piece-back-rhodes-2.png","rhodes/piece-back-rhodes-1.png","rhodes/piece-back-rhodes-3.png","rhodes/piece-back-rhodes-4.png","rhodes/piece-back-rhodes-5.png");

    public  String  construction1;
    public String construction2;
    public String construction3;
    public String construction4;
    public String construction5;
    public String constructionFront1;
    public String constructionFront2;
    public String constructionFront3;
    public String constructionFront4;
    public String constructionFront5;

    private ConstImage(String constructionBack1,String constructionBack2,String constructionBack3,String constructionBack4,String constructionBack5){
        this.construction1= "images/wonders/" +constructionBack1;
        this.construction2=  "images/wonders/"+ constructionBack2;
        this.construction3= "images/wonders/"+ constructionBack3;
        this.construction4= "images/wonders/"+constructionBack4;
        this.construction5= "images/wonders/"+constructionBack5;

    }
    public String getCons1(){
        return this.construction1;
    }
    public String getCons2(){
        return this.construction2;
    }
    public String getCons3(){
        return this.construction3;
    }
    public String getCons4(){
        return this.construction4;
    }
    public String getCons5(){
        return this.construction5;
    }

}

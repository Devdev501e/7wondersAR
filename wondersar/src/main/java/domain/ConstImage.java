package domain;

public enum ConstImage {

    AlexandrieBack("piece-back-alexandrie-1.png","piece-back-alexandrie-4.png","piece-back-alexandrie-2.png","piece-back-alexandrie-3.png","piece-back-alexandrie-6.png"),
    BabylonBack("piece-back-babylon-1.png","piece-back-babylon-2.png","piece-back-babylon-4.png","piece-back-babylon-5.png","piece-back-babylon-6.png"),
    Ephese("piece-back-ephese-5.png","piece-back-ephese-2.png","piece-back-ephese-4.png","piece-back-ephese-3.png","piece-back-ephese-6.png"),
    Giseh("?","piece-back-giseh-1.png","piece-back-giseh-2.png","piece-back-giseh-3.png","piece-back-giseh-4.png"),
    Halicarnasse("piece-back-halicarnasse-1.png","piece-back-halicarnasse-2.png","piece-back-halicarnasse-4.png","piece-back-halicarnasse-3.png","piece-back-halicarnasse-5.png"),
    Olympie("","","","",""),
    Rhodes("piece-back-rhodes-2.png","piece-back-rhodes-1.png","piece-back-rhodes-3.png","piece-back-rhodes-3","piece-back-rhodes-4.png");

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
        this.construction1=construction1;
        this.construction2=construction2;
        this.construction3=construction3;
        this.construction4=construction4;
        this.construction5=construction5;

    }

}

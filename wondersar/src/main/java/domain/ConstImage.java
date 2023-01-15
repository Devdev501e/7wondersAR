package domain;

public enum ConstImage {

    Alexandrie("alexandrie/piece-back-alexandrie-1.png","alexandrie/piece-back-alexandrie-4.png","alexandrie/piece-back-alexandrie-2.png","alexandrie/piece-back-alexandrie-3.png","alexandrie/piece-back-alexandrie-6.png","alexandrie/piece-front-alexandrie-1.png","alexandrie/piece-front-alexandrie-2.png","alexandrie/piece-front-alexandrie-4.png","alexandrie/piece-front-alexandrie-3.png","alexandrie/piece-front-alexandrie-6.png"),
    Babylon("babylon/piece-back-babylon-1.png","babylon/piece-back-babylon-2.png","babylon/piece-back-babylon-4.png","babylon/piece-back-babylon-5.png","babylon/piece-back-babylon-6.png","babylon/piece-front-babylon-1.png","babylon/piece-front-babylon-2.png","babylon/piece-front-babylon-4.png","babylon/piece-front-babylon-5.png","babylon/piece-front-babylon-6.png"),
    Ephese("ephese/piece-back-ephese-1.png","ephese/piece-back-ephese-2.png","ephese/piece-back-ephese-4.png","ephese/piece-back-ephese-3.png","ephese/piece-back-ephese-6.png","ephese/piece-front-ephese-1.png","ephese/piece-front-ephese-2.png","ephese/piece-front-ephese-4.png","ephese/piece-front-ephese-3.png","ephese/piece-front-ephese-6.png"),
    Giseh("giseh/piece-back-giseh-1.png","giseh/piece-back-giseh-2.png","giseh/piece-back-giseh-3.png","giseh/piece-back-giseh-4.png","giseh/piece-back-giseh-5.png","giseh/piece-front-giseh-1.png","giseh/piece-front-giseh-2.png","giseh/piece-front-giseh-3.png","giseh/piece-front-giseh-4.png","giseh/piece-front-giseh-5.png"),
    Halicarnasse("halicarnasse/piece-back-halicarnasse-1.png","halicarnasse/piece-back-halicarnasse-2.png","halicarnasse/piece-back-halicarnasse-4.png","halicarnasse/piece-back-halicarnasse-3.png","halicarnasse/piece-back-halicarnasse-5.png","halicarnasse/piece-front-halicarnasse-1.png","halicarnasse/piece-front-halicarnasse-2.png","halicarnasse/piece-front-halicarnasse-4.png","halicarnasse/piece-front-halicarnasse-3.png","halicarnasse/piece-front-halicarnasse-5.png"),
    Olympie( "olympie/piece-back-olympie-1.png","olympie/piece-back-olympie-3.png","olympie/piece-back-olympie-2.png","olympie/piece-back-olympie-4.png","olympie/piece-back-olympie-5.png","olympie/piece-front-olympie-1.png","olympie/piece-front-olympie-3.png","olympie/piece-front-olympie-2.png","olympie/piece-front-olympie-4.png","olympie/piece-front-olympie-5.png"),
    Rhodes("rhodes/piece-back-rhodes-2.png","rhodes/piece-back-rhodes-1.png","rhodes/piece-back-rhodes-3.png","rhodes/piece-back-rhodes-4.png","rhodes/piece-back-rhodes-5.png","rhodes/piece-front-rhodes-2.png","rhodes/piece-front-rhodes-1.png","rhodes/piece-front-rhodes-3.png","rhodes/piece-front-rhodes-4.png","rhodes/piece-front-rhodes-5.png");

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

    private ConstImage(String constructionBack1,String constructionBack2,String constructionBack3,String constructionBack4,String constructionBack5, String constructionFront1,String constructionFront2,String constructionFront3,String constructionFront4,String constructionFront5){
        this.construction1= "images/wonders/" +constructionBack1;
        this.construction2=  "images/wonders/"+ constructionBack2;
        this.construction3= "images/wonders/"+ constructionBack3;
        this.construction4= "images/wonders/"+constructionBack4;
        this.construction5= "images/wonders/"+constructionBack5;
        this.constructionFront1= "images/wonders/"+constructionFront1;
        this.constructionFront2= "images/wonders/"+constructionFront2;
        this.constructionFront3= "images/wonders/"+constructionFront3;
        this.constructionFront4= "images/wonders/"+constructionFront4;
        this.constructionFront5= "images/wonders/"+constructionFront5;
    }

    public String getConstruction1(Boolean completed){
        if(completed){
            return this.constructionFront1;
        }else{
            return this.construction1;
        }
    }
    public String getConstruction2(Boolean completed){
        if(completed){
            return this.constructionFront2;
        }else{
            return this.construction2;
        }
    }
    public String getConstruction3(Boolean completed){
        if(completed){
            return this.constructionFront3;
        }else{
            return this.construction3;
        }
    }
    public String getConstruction4(Boolean completed){
        if(completed){
            return this.constructionFront4;
        }else{
            return this.construction4;
        }}
        public String getConstruction5(Boolean completed){
            if(completed){
                return this.constructionFront5;
            }else{
                return this.construction5;
            }
        }


}

package domain;

public enum ConstImage {

    Alexandrie("piece-back-alexandrie-1.png","piece-back-alexandrie-4.png","piece-back-alexandrie-2.png","piece-back-alexandrie-3.png","piece-back-alexandrie-6.png"),
    Babylon("","","","",""),
    Ephese("","","","",""),
    Giseh("","","","",""),
    Halicarnasse("","","","",""),
    Olympie("","","","",""),
    Rhodes("","","","","");

    public  String  construction1;
    public String construction2;
    public String construction3;
    public String construction4;
    public String construction5;
    private ConstImage(String construction1,String construction2,String construction3,String construction4,String construction5){
        this.construction1=construction1;
        this.construction2=construction2;
        this.construction3=construction3;
        this.construction4=construction4;
        this.construction5=construction5;

    }

}

package proiectdiz.Storage.Model;

public class ShareObject {
    private String GUID;
    private String X;
    private String Y;

    public ShareObject(String X, String Y, String GUID){
        this.GUID=GUID;
        this.X=X;
        this.Y=Y;
    }
    public ShareObject(String GUID){
        this.GUID=GUID;
    }

    public void setX(String x) {
        X = x;
    }

    public void setY(String y) {
        Y = y;
    }

}

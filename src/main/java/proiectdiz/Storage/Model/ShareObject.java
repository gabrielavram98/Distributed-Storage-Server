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
}

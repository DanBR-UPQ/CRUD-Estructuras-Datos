package structures.list;
import model.Asset;

public class ListNode {
    private final Asset asset;
    private ListNode sig;

    public ListNode(Asset asset) {
        this.asset = asset;
        sig = null;
    }

    public Asset getAsset(){
        return asset;
    }
    public ListNode getSig(){
        return sig;
    }

    public void setSig(ListNode sig){
        this.sig = sig;
    }
}
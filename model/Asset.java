package model;
public class Asset {
    private int id;
    private int assetValue;

    private String Name;
    private String category;

    public Asset(int id, String Name, int assetValue, String category) {
        this.id = id;
        this.assetValue = assetValue;
        this.Name = Name;
        this.category = category;
    }

    public Asset(){
        id = assetValue = 0;
        Name = category = "";
    }
    public void imprimir(){
        System.out.println("[ " + id + ", " + Name + ", " + assetValue + ", " + category + " ]");
    }

    public int getId(){
        return id;
    }
    public int getAssetValue(){
        return assetValue;
    }
    public String getAssetName(){
        return Name;
    }
    public String getCategory(){
        return category;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setAssetValue(int assetValue){
        this.assetValue = assetValue;
    }
    public void setAssetName(String Name){
        this.Name = Name;
    }
    public void setCategory(String category){
        this.category = category;
    }
}

public class ItemInformation {
    String itemID;
    String itemName;
    double itemPrice;
    String datePurchase;

    ItemInformation() {
        itemID = "";
        itemName = "";
        itemPrice = 0.0;
        datePurchase = "";
    }

    ItemInformation(String id, String name, double price, String date) {
        itemID = id;
        itemName = name;
        itemPrice = price;
        datePurchase = date;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemId(String itemId) {
        this.itemID= itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDate() {
        return datePurchase;
    }

}

import java.text.DecimalFormat;
import java.util.*;

public class CustomerInformation {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private String custID;
    private String custIC;
    private int counterPaid;
    private LinkedList<ItemInformation> itemList;

    CustomerInformation(String id, String ic, int paid) {
        custID = id;
        custIC = ic;
        counterPaid = paid;
        this.itemList = new LinkedList<>();
    }

    // Accessor
    public String getCustIC() {
        return custIC;
    }

    public String getCustID() {
        return custID;
    }

    public int getCounterPaid() {
        return counterPaid;
    }

    public double totPrice() {
        double total = 0;
        for (ItemInformation items : itemList) {
            total = total + items.getItemPrice();
        }
        return total;
    }

    public int getItemQuantity() {
        return itemList.size();
    }

    // Mutator
    public void addItem(List<ItemInformation> items) {
        itemList.addAll(items);
    }

    public void setCounterPaid(int counter) {
        counterPaid = counter;
    }

    public void purchaseItem(ItemInformation item) {
        itemList.add(item);
    }

    public void removePurchasedItem(ItemInformation item) {
        itemList.remove(item);
    }

    // method to display purchased items
    public String displayPurchasedItems() {
        ItemInformation item;
        String table = "";

        table += "\n+----------+---------+------------------------+------------+--------------+\n";
        table += "| Item No. | Item ID |       Item Name        | Item Price |     Date     |\n";
        table += "+----------+---------+------------------------+------------+--------------+\n";

        for (int i = 0; i < itemList.size(); i++) {
            item = itemList.get(i);
            table += String.format("|  %-6s  | %-7s | %-22s | %10.2f | %12s |\n", (i + 1), item.getItemID(),
                item.getItemName(), item.getItemPrice(), item.getDate());
        }

        table += "+----------+---------+------------------------+------------+--------------+\n";

        return table;
    }

    // toString
    public String toString() {
        return ("ID: " + custID + "\nIc: " + custIC + "\nCounter Paid: " + counterPaid + "\nQuantity: "
            + getItemQuantity() + displayPurchasedItems() + "Total : " + decimalFormat.format(totPrice()) + "\n");
    }
}

import javax.swing.*;
import java.util.*;
import java.io.*;

public class MainClass
{
    public static void main (String [] args)
    {
        try
        {
            //Create 3 queues
            Queue qCounter1 = new Queue();
            Queue qCounter2 = new Queue();
            Queue qCounter3 = new Queue();
            
            //Create stack
            Stack completedStack = new Stack();

            //Read from customer.txt file
            BufferedReader in = new BufferedReader(new FileReader("customer.txt"));
            
            //Create Arraylist
            LinkedList<CustomerInformation> customerList = new LinkedList<CustomerInformation>();
            
            //Declare indata ( a line in input file)
            String inline = null;
            
            //Create object
            CustomerInformation cust;
            
            double total = 0.0;
            int totCustomer = 0;
            
            while ((inline = in.readLine()) !=null)
            {
                StringTokenizer st = new StringTokenizer(inline, ";");
                
                String custID = st.nextToken();
                String custIC = st.nextToken();
                int counterPaid = Integer.parseInt(st.nextToken());
                
                ArrayList<ItemInformation> itemList = new ArrayList<>();
                StringTokenizer itemTokenizer = new StringTokenizer(st.nextToken(), ":");
                while (itemTokenizer.hasMoreTokens())
                {
                    StringTokenizer infoTokenizer = new StringTokenizer(itemTokenizer.nextToken(),",");
                    String itemID = infoTokenizer.nextToken();
                    String itemName = infoTokenizer.nextToken();
                    double itemPrice = Double.parseDouble(infoTokenizer.nextToken());
                    String date = infoTokenizer.nextToken();
                    
                    ItemInformation item = new ItemInformation(itemID, itemName, itemPrice, date);
                    itemList.add(item);
                    counterPaid += itemPrice;
                }
                //create object
                cust = new CustomerInformation (custID, custIC, counterPaid);
                cust.addItem(itemList);
                customerList.add(cust);
                totCustomer++;
            }
            
            
            in.close();
            
            
            new Gui(customerList, qCounter1, qCounter2, qCounter3, totCustomer, completedStack);
        } catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found");
        
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

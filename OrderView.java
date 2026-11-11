import java.util.ArrayList;

// VIEW: everything the user SEES. A View only displays data -
// it must never change the Model.
public class OrderView {

    public void printMenu(ArrayList<MenuItem> menu) {
        System.out.println("----- CAMPUS CANTEEN MENU -----");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rs." + (int) item.getPrice());
        }
        System.out.println("4. Finish and print receipt");
        System.out.print("Enter your choice: ");
    }

    // HINT (Bug 4): Something in this method breaks the MVC rules.
    // After the receipt prints, the Grand Total always shows Rs.0.
    // What is the View doing that it should never do?
    public void printReceipt(ArrayList<Order> orders) {
        System.out.println("----- RECEIPT -----");
        for (Order order : orders) {
            System.out.println(order.getItem().getName() + " x " + order.getQuantity()
                    + " = Rs." + (int) order.getTotal());
        }
        orders.clear(); // start fresh for the next customer
    }
}

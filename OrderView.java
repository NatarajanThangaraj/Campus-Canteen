import java.util.ArrayList;

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
    public void printReceipt(ArrayList<Order> orders) {
        System.out.println("----- RECEIPT -----");
        for (Order order : orders) {
            System.out.println(order.getItem().getName() + " x " + order.getQuantity()
                    + " = Rs." + (int) order.getTotal());
        }
        orders.clear(); // start fresh for the next customer
    }
}

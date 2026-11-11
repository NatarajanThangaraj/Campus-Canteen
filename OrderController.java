import java.util.ArrayList;
import java.util.Scanner;

// CONTROLLER: connects the Model and the View. It reads the user's
// choice, updates the Model, and asks the View to display results.
public class OrderController {
    private ArrayList<MenuItem> menu;
    private ArrayList<Order> orders;
    private OrderView view;
    private Scanner scanner;

    public OrderController(ArrayList<MenuItem> menu, OrderView view) {
        this.menu = menu;
        this.view = view;
        this.orders = new ArrayList<Order>();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        view.printMenu(menu);
    }

    public int readChoice() {
        return scanner.nextInt();
    }

    // HINT (Bug 6): The app quits after ONE item instead of running
    // until the user picks 4. Check what this method really says.
    public boolean isFinished(int choice) {
        return choice != 4;
    }

    public void takeOrder(int choice) {
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        // HINT (Bug 5): The user picked item number `choice`, but the
        // wrong item gets added (and one choice crashes the app).
        // Remember: menu option 1 is at index 0 of the ArrayList.
        MenuItem picked = menu.get(choice);
        // HINT (Bug 2): Every order seems to disappear - the receipt is
        // always empty. Look closely at WHICH list the next lines fill.
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(new Order(picked, quantity));
        System.out.println("Added: " + picked.getName() + " x " + quantity);
    }

    public double getGrandTotal() {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotal();
        }
        return total;
    }

    public void printReceipt() {
        view.printReceipt(orders);
        System.out.println("Grand Total: Rs." + (int) getGrandTotal());
    }
}

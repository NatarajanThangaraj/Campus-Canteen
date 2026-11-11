import java.util.ArrayList;
import java.util.Scanner;

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

    public boolean isFinished(int choice) {
        return choice != 4;
    }

    public void takeOrder(int choice) {
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        MenuItem picked = menu.get(choice);
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

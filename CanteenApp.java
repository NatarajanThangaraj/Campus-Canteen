import java.util.ArrayList;

// MAIN: wires the Model, View and Controller together and runs the loop.
public class CanteenApp {
    public static void main(String[] args) {
        // The Model: the canteen menu.
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem("Masala Dosa", 40));
        menu.add(new MenuItem("Idli", 20));
        menu.add(new MenuItem("Filter Coffee", 15));

        // The View.
        OrderView view = new OrderView();

        // HINT (Bug 1): The program does not even compile. Read the
        // OrderController constructor - what order does it expect
        // its arguments in?
        OrderController controller = new OrderController(view, menu);

        System.out.println("Welcome to Campus Canteen!");
        boolean running = true;
        while (running) {
            controller.showMenu();
            int choice = controller.readChoice();
            if (controller.isFinished(choice)) {
                controller.printReceipt();
                running = false;
            } else {
                controller.takeOrder(choice);
            }
        }
        System.out.println("Thank you! Visit again.");
    }
}

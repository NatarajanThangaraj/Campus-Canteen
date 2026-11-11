// MODEL: one line of the bill - an item and how many were ordered.
public class Order {
    private MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // HINT (Bug 3): This should give the line total for THIS order.
    // Ordering 2 Dosas at Rs.40 each should total Rs.80, not Rs.40.
    // What did this method forget?
    public double getTotal() {
        return item.getPrice();
    }
}

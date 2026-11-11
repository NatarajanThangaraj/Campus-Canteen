// MODEL: a single item on the canteen menu.
// The Model holds the data and the maths. It knows nothing about
// the View or the Controller.
public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

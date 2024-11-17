package entity;

public class Fruit {

    private String name, origin;
    private double price;
    private int id, quantity;

    public Fruit(int id, String name, String origin, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQunatity() {
        return quantity;
    }

    public void setQunatity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPriceChose() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %-10s", id, name, price, quantity, origin);
    }

}

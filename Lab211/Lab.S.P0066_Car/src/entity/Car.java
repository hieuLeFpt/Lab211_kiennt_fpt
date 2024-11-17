package entity;

public class Car {

    private String name;
    private String[] colors;
    private int[] prices;
    private String[] soldOnDays;

    public Car() {
    }   
    
    public Car(String name, String[] colors, int[] prices, String[] soldOnDays) {
        this.name = name;
        this.colors = colors;
        this.prices = prices;
        this.soldOnDays = soldOnDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public int[] getPrices() {
        return prices;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public String[] getSoldOnDays() {
        return soldOnDays;
    }

    public void setSoldOnDays(String[] soldOnDays) {
        this.soldOnDays = soldOnDays;
    }

    

}

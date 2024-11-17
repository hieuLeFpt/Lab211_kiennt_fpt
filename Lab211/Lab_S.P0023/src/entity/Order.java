package entity;

import java.util.ArrayList;

public class Order {

    private String nameCustomer;
    private ArrayList<Fruit> listFruitOrder = new ArrayList<>();
    
    public Order() {
    }
    
    public String getNameCustomer() {
        return nameCustomer;
    }
    
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    
    public ArrayList<Fruit> getListFruitOrder() {
        return listFruitOrder;
    }
    
    public void setListFruitOrder(ArrayList<Fruit> listFruitOrder) {
        this.listFruitOrder = listFruitOrder;
    }
    
    // add fruit order to list if not exit before then add to list if exit befor ++ quantity fruit exit
    public void addFruit(Fruit fruit) {
        Fruit fruitInList = getFruitOrderById(fruit.getId());
        if (fruitInList == null) {
            listFruitOrder.add(fruit);
        } else {
            fruitInList.setQunatity(fruitInList.getQunatity() + fruit.getQunatity());
        }
    }
    
    public double getAmount() {
        double total = 0;
        for (Fruit fruit : listFruitOrder) {
            total += fruit.getTotalPriceChose();
        }
        return total;
    }
    
    private Fruit getFruitOrderById(int id) {
        for (Fruit fruit : listFruitOrder) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }
}

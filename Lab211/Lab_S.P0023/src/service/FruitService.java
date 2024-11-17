package service;

import entity.Fruit;
import entity.Order;
import java.util.ArrayList;

public class FruitService {

    private final ArrayList<Fruit> listFruit = new ArrayList<>();
    private final ArrayList<Order> listOrder = new ArrayList<>();

    public FruitService() {
        listFruit.add(new Fruit(1, "Apple", "a", 1, 100));
        listFruit.add(new Fruit(2, "Banana", "b", 1, 100));
        listFruit.add(new Fruit(3, "Orange", "c", 1, 100));
        listFruit.add(new Fruit(4, "Mango", "d", 1, 100));
        listFruit.add(new Fruit(5, "Pineapple", "e", 1, 100));
        listFruit.add(new Fruit(6, "Strawberry", "f", 1, 100));
        listFruit.add(new Fruit(7, "Watermelon", "g", 1, 100));
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public boolean createFruit(Fruit newFruit) {
        if (checkDuplicate(newFruit)) {
            return false;
        }
        listFruit.add(newFruit);
        return true;
    }
    
    public void addOrder(Order newOrder){
        listOrder.add(newOrder);
    }

    public boolean checkDuplicate(Fruit checkFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId() == checkFruit.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public Fruit getFruitById(int id){
        for (Fruit fruit : listFruit) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }
    
    public void delete(Fruit fruit){
        listFruit.remove(fruit);
    }

}

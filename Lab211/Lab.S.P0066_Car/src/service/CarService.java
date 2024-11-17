package service;

import entity.Car;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final List<Car> listCar;

    public CarService() {

        listCar = new ArrayList<>();
        initializeCars();

    }

    // add data for listCar
    private void initializeCars() {

        String[] ListColorAudi = {"WHITE", "YELLOW", "ORANGE"};
        int listPriceAudi[] = {5500, 3000, 4500};
        String[] listSoldDayAudi = {"FRIDAY", "SUNDAY", "MONDAY"};
        listCar.add(new Car("AUDI", ListColorAudi, listPriceAudi, listSoldDayAudi));

        String[] ListColorMercedes = {"GREEN", "BLUE", "PURPLE"};
        int listPriceMerceders[] = {5000, 6000, 8500};
        String[] listSoldDayMerceders = {"TUESDAY", "SATURDAY", "WEDNESDAY"};
        listCar.add(new Car("Mercedes", ListColorMercedes, listPriceMerceders, listSoldDayMerceders));

        String[] ListColorBMW = {"PINK", "RED", "BROWN"};
        int listPriceBMW[] = {2500, 3000, 3500};
        String[] listSoldDayBMW = {"MONDAY", "SUNDAY", "THURSDAY"};
        listCar.add(new Car("BMW", ListColorBMW, listPriceBMW, listSoldDayBMW));

    }

    public boolean checkColor(String carName, String colorCheck) {
        Car car = findCarByMame(carName);
        if (car != null) {
            String[] listColors = car.getColors();
            if (colorCheck.equalsIgnoreCase("no color")) {
                return true;
            }
            for (String color : listColors) {
                if (colorCheck.equalsIgnoreCase(color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPrice(String carName, int priceCheck, String colorCheck) {
        Car car = findCarByMame(carName);
        if (car != null) {
            int[] listPrices = car.getPrices();
            if (colorCheck.equalsIgnoreCase("no color")) {
                for (int price : listPrices) {
                    if (priceCheck == price - 100) {
                        return true;
                    }
                }
            } else {
                for (int price : listPrices) {
                    if (priceCheck == price) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkSoldDay(String carName, String dayCheck) {
        Car car = findCarByMame(carName);
        if (car != null) {
            String[] listSoldOnDay = car.getSoldOnDays();
            for (String day : listSoldOnDay) {
                if (dayCheck.equalsIgnoreCase(day)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Car checkNameCar(String name) {
        return findCarByMame(name);  
    }
    
    private Car findCarByMame(String name) {
        for (Car car : listCar) {
            if (car.getName().equalsIgnoreCase(name)) {
                return car;
            }
        }
        return null;
    }

}

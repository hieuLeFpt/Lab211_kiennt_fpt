package controller;

import entity.Car;
import service.CarService;
import view.CarView;

public class CarController {

    private final CarService carService = new CarService();
    private final CarView carView = new CarView();

    public void run() {
        carView.printMessage("===== Showroom car program =====\n");
        while (true) {
            carView.printMessage("Input infomation of car\n");
            Car car = carView.inputCar();
            if (checkCarValid(car)) {
                carView.printMessage("Sell Car!\n");
            }

            if (!carView.inputYesOrNo("Do you want to find more? (Y/N): ")) {
                break;
            }
        }
    }

    private boolean checkCarValid(Car car) {
        if (carService.checkNameCar(car.getName()) == null) {
            carView.printError("Can't sell Car\nCar break");
            return false;
        }
        if (!carService.checkColor(car.getName(), car.getColors()[0])) {
            carView.printError("Can't sell Car\nColor Car does not exist");
            return false;
        }
        if (!carService.checkPrice(car.getName(), car.getPrices()[0], car.getColors()[0])) {
            carView.printError("Can't sell Car\nPrice Car is not true");
            return false;
        }
        if (!carService.checkSoldDay(car.getName(), car.getSoldOnDays()[0])) {
            carView.printError("Can't sell Car\nCar can't sell today");
            return false;
        }
        return true;
    }

}

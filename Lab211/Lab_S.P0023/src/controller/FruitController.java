package controller;

import view.FruitView;

public class FruitController {
        FruitView fruitView = new FruitView();

    public void run(){
         fruitView.printMessage("===== Wellcome to fruit shop =====\n");
        while (true) {
            fruitView.displayMenu();
            int choice = fruitView.inputInteger("Please choice one option: ", "Wrong format choice!", 1, 5);
            switch (choice) {
                case 1:
                    fruitView.inputFruit();
                    break;
                case 2:
                    fruitView.viewOrder();
                    break;
                case 3:
                    fruitView.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
}

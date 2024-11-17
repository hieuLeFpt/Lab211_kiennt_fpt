package main;

public class Main {

    public static void main(String[] args) {

        Utility utility = new Utility();
        ManagerEastAsiaCountry manage = new ManagerEastAsiaCountry();
        manage.takeData();
        
        while (true) {
            
            displayMenu();
            int option = utility.getInteger("Option: ", "Wrong", 1, 5);
            
            switch (option) {
                case 1:
                    //input country information
                    manage.inputCountry();
                    break;
                case 2:
                    // display just country input
                    manage.displayCountryJustInput();
                    break;
                case 3:
                    // display country by enter name
                    manage.displayByEnterName();
                    break;
                case 4:
                    // sort country by name
                    manage.sortCountry();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("MENU \n"
                + "========================================================================== \n"
                + "1. Input the information of 11 countries in East Asia \n"
                + "2. Display the information of country you've just input \n"
                + "3. Search the information of country by user-entered name \n"
                + "4. Display the information of countries sorted name in ascending order \n"
                + "5. Exit \n"
                + "==========================================================================");
    }

}

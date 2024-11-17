package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ManagerEastAsiaCountry {

    ArrayList<EastAsiaCountry> countryList = new ArrayList<>();

    void takeData() {
        countryList.add(new EastAsiaCountry("VN", "Viet Nam", 1, "A"));
        countryList.add(new EastAsiaCountry("IDN", "Indonesia", 2, "B"));
        countryList.add(new EastAsiaCountry("TL", "Thai Lan", 3, "C"));
        countryList.add(new EastAsiaCountry("PL", "Philipin", 4, "D"));

    }

    Utility utility = new Utility();

    void inputCountry() {

        String code, name, terrain;
        float area;

        if (countryList.size() == 11) {
            System.out.println("Enough country !");
            return;
        }

        while (true) {
            code = utility.getString("Enter code: ", "Wrong", utility.REGEX_CODE);
            if (checkDuplicateCode(code)) {
                System.out.println("Duplicate code !");
            } else {
                break;
            }
        }

        while (true) {
            name = utility.getString("Enter name: ", "Wrong", utility.REGEX_NAME);
            if (checkDuplicateName(name)) {
                System.out.println("Duplicate name !");
            } else {
                break;
            }
        }

        area = utility.getFloat("Enter area: ", "Wrong", 0, Float.MAX_VALUE);
        terrain = utility.getString("Enter terrain: ", "Wrong", utility.REGEX_NAME);

        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);
        countryList.add(country);

    }

    private boolean checkDuplicateCode(String code) {
        for (EastAsiaCountry e : countryList) {
            if (e.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicateName(String name) {
        for (EastAsiaCountry e : countryList) {
            if (e.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    void displayCountryJustInput() {
        if (countryList.isEmpty()) {
            System.out.println("Do not have any country inout!");
        } else {
            EastAsiaCountry e = countryList.get(countryList.size() - 1);
            System.out.println("ID \t" + "Name \t" + "Total area \t" + "Terrain \t");
            System.out.format("%-5s %-15s %-15.1f %-15s \n", e.getCountryCode(), e.getCountryName(), e.getTotalArea(), e.getTerrain());
        }
    }

    void displayByEnterName() {
        if (countryList.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String findName = utility.getString("Enter the name you want to search for: ", "Wrong", utility.REGEX_NAME);
        boolean flag = true;
        for (EastAsiaCountry e : countryList) {
            if (findName.equalsIgnoreCase(e.getCountryName())) {
                System.out.println("ID \t" + "Name \t" + "Total area \t" + "Terrain \t");
                System.out.format("%-5s %-15s %-15.1f %-15s \n", e.getCountryCode(), e.getCountryName(), e.getTotalArea(), e.getTerrain());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Do not have this country in system!");
        }
    }

    void sortCountry() {
        if (countryList.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        ArrayList<EastAsiaCountry> sortList = new ArrayList<>();
        sortList.addAll(countryList);

        Collections.sort(sortList, new Comparator<EastAsiaCountry>() {
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }

        });

        System.out.format("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Total area", "Terrain");
        for (EastAsiaCountry e : sortList) {
            e.display();
        }

    }
}

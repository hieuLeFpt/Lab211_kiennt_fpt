package controller;

import view.StudentView;

public class StudentController {

    StudentView studentView = new StudentView();

    public void run() {
        studentView.printMessage("===== Wellcome to student managemnet =====\n");
        while (true) {
            studentView.printMessage("==========================================\n");
            studentView.displayMenu();
            int choice = studentView.inputInteger("Please choice one option: ", "Wrong format choice!", 1, 5);
            switch (choice) {
                case 1:
                    studentView.inputStudent();
                    break;
                case 2:
                    studentView.searchAndSort();
                    break;
                case 3:
                    studentView.updateOrDelete();
                    break;
                case 4:
                    studentView.Report();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}

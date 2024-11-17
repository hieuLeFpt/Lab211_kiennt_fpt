package controller;

import view.TaskView;

public class TaskController {

    TaskView taskView = new TaskView();

    public void run() {
        while (true) {
            taskView.printMessage("====== Task program ======\n");
            taskView.displayMenu();
            int choice = taskView.inputInteger("Choice: ", "Wrong format input!", 1, 4);

            switch (choice) {
                case 1:
                    taskView.inputTask();
                    break;
                case 2:
                    taskView.deleteTask();
                    break;
                case 3:
                    taskView.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

}

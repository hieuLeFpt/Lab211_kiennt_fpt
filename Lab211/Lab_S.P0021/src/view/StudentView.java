package view;

import entity.Report;
import entity.Study;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import service.StudyService;

public class StudentView {

    private final Scanner scanner = new Scanner(System.in);
    private final StudyService studyService = new StudyService();

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void displayMenu() {
        printMessage("1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n");
    }

    public String inputString(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength) {
                    return input;
                } else {
                    printError(errorSpecialCharacter);
                }
            }
        }
    }

    public String inputId(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength && !input.contains(" ")) {
                    return input;
                } else {
                    printError(errorSpecialCharacter);
                }
            }
        }
    }

    public int inputInteger(String messageInput, String errorSpecialCharacter, int minValue, int maxValue) {
        while (true) {
            try {
                printMessage(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < minValue || number > maxValue) {
                        printError("Invalid input must be in " + minValue + " - " + maxValue);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
    }

    private boolean inputChoice(String message, String yesOption, String noOption, String errorMessage) {
        while (true) {
            printMessage(message);
            String result = scanner.nextLine().toLowerCase();
            if (result.equals(yesOption.toLowerCase())) {
                return true;
            } else if (result.equals(noOption.toLowerCase())) {
                return false;
            } else {
                printError(errorMessage);
            }
        }
    }

    public void inputStudent() {
        String name;
        int course, semester, id;
        if (studyService.getListStudy().size() >= 10) {
            if (!inputChoice("Do you want to continue (Y/N)?: ", "y", "n", "Please chose Yes(y) or No(n) to continue!!")) {
                return;
            }
        }
        id = inputInteger("Id: ", "Wrong format id!", 1, Integer.MAX_VALUE);
        Study exitStudy = studyService.getStudyById(id);
        if (exitStudy == null) {
            name = inputString("Name: ", "Wrong format name!", 2, 40);
        } else {
            name = exitStudy.getName();
            printMessage("Name: " + exitStudy.getName() + "\n");
        }
        semester = inputInteger("Semester: ", "Wrong format semester!", 1, 10);
        course = inputInteger("Course(1.Java 2.Net 3.C/C++): ", "Wrong format course!", 1, 3);

        Study newStudy = new Study(id, name, semester, course);
        if (studyService.create(newStudy)) {
            printMessage("Create successfully!\n");
        } else {
            printError("Duplicate study!");
        }
    }

    public void searchAndSort() {
        String name = inputString("Name: ", "Wrong format name!", 1, 40);
        ArrayList<Study> listFound = studyService.findByName(name);
        if (listFound == null) {
            printError("Not found!");
        } else {
            printMessage(String.format("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Semester", "Course"));
            for (Study study : listFound) {
                System.out.print(study);
            }
        }
    }

    private void displayListAll(List<Study> listFound) {
        System.out.format("%-10s %-10s %-15s %-10s %-10s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFound.size(); i++) {
            System.out.format("%-10s %-10s %-15s %-10d %-10s\n", i + 1, listFound.get(i).getId(),
                    listFound.get(i).getName(),
                    listFound.get(i).getSemester(),
                    listFound.get(i).getCourseString());
        }
    }

    public void updateOrDelete() {
        if (!inputChoice("Do you want to update(U) or delete(D) study?: ", "u", "d", "Please chose update(U) or delete(D) study!")) {
            deleteStudent();
        } else {
            updateStudent();
        }
    }

    private void deleteStudent() {
        displayListAll(studyService.getListStudy());

        int choseToDelete = inputInteger("Chose no: ", "Wrong format id!", 1, studyService.getListStudy().size());
        Study studyDelete = studyService.getListStudy().get(choseToDelete - 1);

        studyService.delete(studyDelete);
        printMessage("Delete successfully!\n");
    }

    private void updateStudent() {
        displayListAll(studyService.getListStudy());

        int choseToUpdate = inputInteger("Chose no: ", "Wrong format id!", 1, studyService.getListStudy().size());
        Study studyInList = studyService.getListStudy().get(choseToUpdate - 1);

        int idUpdate = studyInList.getId();
        String nameUpdate = studyInList.getName();
        int semesterUpdate = studyInList.getSemester();
        int courseUpdate = studyInList.getCourse();
        boolean statusChangeName = true;

        if (inputChoice("Do you want to update id ?(y/n): ", "y", "n", "Please chose Yes(y) or No(n) to update!!")) {
            idUpdate = inputInteger("Id: ", "Wrong format input!", 1, Integer.MAX_VALUE);
            Study exitStudy = studyService.getStudyById(idUpdate);
            if (exitStudy == null) {
                if (inputChoice("Do you want to update name ?(y/n): ", "y", "n", "Please chose Yes(y) or No(n) to update!!")) {
                    nameUpdate = inputString("Name: ", "Wrong format name!", 2, 40);
                    statusChangeName = false;
                }
            } else {
                nameUpdate = exitStudy.getName();
                printMessage("Name: " + exitStudy.getName() + "\n");
                statusChangeName = false;
            }
        }
        if (statusChangeName) {
            if (inputChoice("Do you want to update name ?(y/n): ", "y", "n", "Please chose Yes(y) or No(n) to update!!")) {
                nameUpdate = inputString("Name: ", "Wrong format name!", 2, 40);
            }
        }
        if (inputChoice("Do you want to update semester ?(y/n): ", "y", "n", "Please chose Yes(y) or No(n) to update!!")) {
            semesterUpdate = inputInteger("Semester: ", "Wrong format semester!", 1, 10);
        }
        if (inputChoice("Do you want to update course ?(y/n): ", "y", "n", "Please chose Yes(y) or No(n) to update!!")) {
            courseUpdate = inputInteger("Course(1.Java 2.Net 3.C/C++): ", "Wrong format course!", 1, 3);
        }

        Study updatedStudy = new Study(idUpdate, nameUpdate, semesterUpdate, courseUpdate);
        if (studyService.checkNotUpdate(idUpdate, nameUpdate, semesterUpdate, courseUpdate, studyInList)) {
            printMessage("You not update!!\n");
        } else if (studyService.checkDuplicate(updatedStudy)) {
            printError("Duplicate!!");
        } else {
            studyService.updateStudy(choseToUpdate - 1, idUpdate, nameUpdate, semesterUpdate, courseUpdate);
            printMessage("Update successfully!\n");
        }
    }

    public void Report() {
        List<Report> displayReport = studyService.report();
        System.out.format("%-10s %-15s %-10s\n", "Name", "Course", "Total course");
        for (Report report : displayReport) {
            System.out.print(report);
        }
    }

}

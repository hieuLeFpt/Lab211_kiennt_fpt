package view;

import entity.Student;
import java.util.HashMap;
import java.util.List;
import service.StudentService;
import java.util.Scanner;

public class StudentView {

    private final String errorWrongFormat = "Wrong format input!";
    private final int maxValInt = Integer.MAX_VALUE;
    private final StudentService studentService;
    Scanner scanner = new Scanner(System.in);

    public StudentView(StudentService studentService) {
        this.studentService = studentService;
    }
    
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public String getString(String message, String error, int minLength, int maxLength) {
        while (true) {
            printMessage(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength && isValidName(input)) {
                    return input;
                } else {
                    printError(error);
                }
            }
        }
    }

    public String getYesOrNo(String message) {
        while (true) {
            printMessage(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return "y";
            } else if (input.equals("n")) {
                return "n";
            } else {
                printError("Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }

    public double getDouble(String message, String error, String subject, double minValue, double maxValue) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Math is digit.");
                } else {
                    double number = Double.parseDouble(input);
                    if (number > maxValue) {
                        printError(subject + " is less than equal ten.");
                    } else if (number < minValue) {
                        printError(subject + " is greater than equal zero.");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(error);
            }
        }
    }

    private boolean isValidName(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    public void createNewStudent() {
        Student createStudent = new Student();
        createStudent.setStudentName(getString("Name: ", errorWrongFormat, 2, maxValInt));
        createStudent.setClassName(getString("Classes: ", errorWrongFormat, 2, maxValInt));
        createStudent.setMathMarks(getDouble("Maths: ", errorWrongFormat, "Maths", 0.0, 10.0));
        createStudent.setPhysicalMarks(getDouble("Physical: ", errorWrongFormat, "Physical", 0.0, 10.0));
        createStudent.setChemistryMarks(getDouble("Chemistry: ", errorWrongFormat, "Physical", 0.0, 10.0));
        studentService.createStudent(createStudent);
    }

    public void displayStudentInfo(List<Student> students) {
        int count = 1;
        for (Student student : students) {
            printMessage("------ Student " + count + " Info ------\n");
            printMessage("Name: " + student.getStudentName() + "\n");
            printMessage("Classes: " + student.getClassName() + "\n");
            printMessage("AVG: " + student.getAverageMarks() + "\n");
            printMessage("Type: " + student.getStudentType() + "\n");
            count++;
        }
    }

    public void displayClassificationStudent(List<Student> students) {
        printMessage("------ Classification Info ------\n");
        HashMap<String, Double> getPercentTypeMap = studentService.getPercentTypeStudent(students);
        for (String type : getPercentTypeMap.keySet()) {
            printMessage(String.format("%s: %.1f%%\n", type, getPercentTypeMap.get(type)));
        }
    }

    public void displayTitle() {
        printMessage("====== MANAGEMENT STUDENT PROGRAM  ======\n");
    }
}

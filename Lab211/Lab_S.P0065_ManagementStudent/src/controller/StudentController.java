package controller;

import entity.Student;
import java.util.List;
import service.StudentService;
import view.StudentView;

public class StudentController {

    StudentService studentService = new StudentService();
    StudentView studentView = new StudentView(studentService);

    public void run() {
        while (true) {
            studentView.displayTitle();
            studentView.createNewStudent();
            String input = studentView.getYesOrNo("Do you want to enter more student information? (Y/N): ");
            if (input.equalsIgnoreCase("N")) {
                List<Student> students = studentService.getListStudent();
                studentService.averageStudent(students);
                studentView.displayStudentInfo(students);
                studentView.displayClassificationStudent(students);
                break;
            }

        }
    }

}

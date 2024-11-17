package application.controllers;

import application.models.StudentModel;
import application.entities.Student;

public class StudentController {

    public StudentController() {

    }

    public void create(Student s) {
        if (StudentModel.getInstance().create(s)) {
            System.out.println("Create success!");
        } else {
            System.out.println("Create failed!");
        }
    }

    public void update(Student s) {
        if (StudentModel.getInstance().update(s)) {
            System.out.println("Update success!");
        } else {
            System.out.println("Update failed!");
        }
    }

    public void read(Student s) {
        Student exitedStudent = StudentModel.getInstance().read(s);
        if (exitedStudent != null) {
            System.out.println("Id " + exitedStudent.getId());
            System.out.println("Name " + exitedStudent.getName());
            System.out.println("Age " + exitedStudent.getAge());
        } else {
            System.out.println("Read failed!");
        }
    }

    public void delete(Student s) {
        if (StudentModel.getInstance().delete(s)) {
            System.out.println("Delete success!");
        } else {
            System.out.println("Delete failed!");
        }
    }

    public void showAll() {
        for (Student s : StudentModel.getInstance().getStudentList()) {
            System.out.println(s);
        }
    }
}

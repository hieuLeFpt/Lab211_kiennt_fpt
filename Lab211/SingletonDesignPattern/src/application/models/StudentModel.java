package application.models;

import java.util.ArrayList;
import application.entities.Student;

public class StudentModel {
    
    private static StudentModel instance;
    private ArrayList<Student> studentList;
    
    private StudentModel() {
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    public boolean create(Student s) {
        return false;
    }
    
    public boolean update(Student s) {
        return false;
    }
    
    public Student read(Student s) {
        return null;
    }
    
    public boolean delete(Student s) {
        return false;
    }
    
    public static StudentModel getInstance() {
        if(StudentModel.instance == null) {
            StudentModel.instance = new StudentModel();
        }
        return StudentModel.instance;
    }
}

package Main;

import java.util.ArrayList;

public class StudentManagement {
    
    private static StudentManagement instance;
    private ArrayList<Student> data;

    private StudentManagement() {
        this.data = new ArrayList<Student>();
    }

    public void create(Student s) {
        
        this.data.add(s);
    }
    
    public void update(Student s) {
        
    }
    
    public Student search(String id) {
        return null;
    }
    
    public void delete(String id) {
        
    }
    
    public void show() {
        for(Student s : this.data) {
            System.out.println(s);
        }
    }
    
    public static StudentManagement getInstance() {
        if(StudentManagement.instance == null) {
            StudentManagement.instance = new StudentManagement(); // chi duoc goi 1 lan duy nhat
        }
        return StudentManagement.instance; // return ve instance da co
    }

    
}

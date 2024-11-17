package entity;

public class Student {

    private String name;
    private int id, course;

    public Student(int id, String name, int course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getCourseString() {
        String result = null;
        switch (course) {
            case 1:
                result = "Java";
                break;
            case 2:
                result = ".Net";
                break;
            case 3:
                result = "C/C++";
                break;
        }
        return result;
    }

    
}

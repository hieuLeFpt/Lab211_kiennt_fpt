package entity;

public class Report extends Student{
    
    private int totalCourse;

    public Report(int id, String name, int course, int totalCourse) {
        super(id, name, course);
        this.totalCourse = totalCourse;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
  
     @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s\n", getName(), getCourseString(),totalCourse);
    }
}

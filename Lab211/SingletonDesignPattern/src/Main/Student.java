package Main;


public class Student {
  
    public String id;
    public String name;
    public double avg;

    public Student(String id, String name, double avg) {
        this.id = id;
        this.name = name;
        this.avg = avg;
    }

    
    
    
    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, avg=%f]", this.id, this.name, this.avg);
        
    }
    
    
    
}

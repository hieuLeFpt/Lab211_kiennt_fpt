package main;


public class Employee {
   
    public String id;
    public String name;
    public int salary;
    
    public Employee(String id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public double getSalary(){
        return this.salary;
    }
    
    public void print(){
        System.out.println(String.format("Employee [id=%s, name=%s, salary=%d]",
                this.id, this.name, this.salary));
    }
    
    
    
}

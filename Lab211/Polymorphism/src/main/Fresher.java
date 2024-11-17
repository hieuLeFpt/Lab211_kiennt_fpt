package main;


public class Fresher extends Employee{
    
    public String type;
    
    public Fresher(String id, String name, int salary, String type){
        super(id, name, salary);
        this.type = type;
    }
    
    @Override
    public double getSalary(){
        if(this.type.equals("B")){
            return super.getSalary() + super.getSalary() * 0.15;                
        } else if (this.type.equals("A")){
            return super.getSalary() + super.getSalary() * 0.25;
        } else if (this.type.equals("S")){
            return super.getSalary() + super.getSalary() * 0.4;
        } else {
            return 0;
        }
    }
    
    @Override
    public void print(){
        System.out.println(String.format("Fresher [id=%s, name=%s, salary=%d, type=%s]",
                super.id, super.name, super.salary, this.type));
    }
    
    
    }
    
    
    


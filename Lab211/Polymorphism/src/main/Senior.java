package main;

public class Senior extends Junior {
    
    public double coefficientsSalary;
    
    public Senior(String id, String name, int salary, int level, double coefficientsSalary){
        super(id, name, salary, level);
        this.coefficientsSalary = coefficientsSalary;
    }
    
    
    @Override
    public double getSalary(){
        return super.getSalary() + this.coefficientsSalary * super.getSalary();    
    }
    
    @Override
    public void print(){
        System.out.println(String.format("Senior [id=%s, name=%s, salary=%d, level=%s, coefficientsSalary=%f]",
                super.id, super.name, super.salary, super.level, this.coefficientsSalary));
    }



}       
    


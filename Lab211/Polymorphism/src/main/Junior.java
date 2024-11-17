package main;

public class Junior extends Employee {

    public int level;
    
    public Junior(String id, String name, int salary, int level){
        super(id, name, salary);
        this.level = level;
    }
    
    @Override
    public double getSalary(){
        return ((double)this.level / 150) * super.getSalary() + super.getSalary();
    }
    
    @Override
    public void print(){
        System.out.println(String.format("Junior [id=%s, name=%s, salary=%d, level=%s]",
                super.id, super.name, super.salary, this.level));
    }

    
    
    
}

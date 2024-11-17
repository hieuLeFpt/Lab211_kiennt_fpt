package Main;


public class Main {
    
    public static void main(String[] args) {
        
        // sử dụng Singleton để quản lý n instance của 1 lớp 
//        DatabaseConnection connection1 = DatabaseConnection.createNewInstance("PC_1");
//        DatabaseConnection connection2 = DatabaseConnection.createNewInstance("PC_2");
//        DatabaseConnection connection3 = DatabaseConnection.createNewInstance("PC_3");
//        DatabaseConnection connection4 = DatabaseConnection.createNewInstance("Laptop_1");
//        DatabaseConnection connection5 = DatabaseConnection.createNewInstance("Laptop_2");
//        connection5.close();
//        DatabaseConnection connection6 = DatabaseConnection.createNewInstance("PC_4");
//        DatabaseConnection connection7 = DatabaseConnection.createNewInstance("PC_5");
//
//        
//        System.out.println(DatabaseConnection.counter);
//        System.out.println();
//        
//        System.out.println(connection1);
//        System.out.println(connection2);
//        System.out.println(connection3);
//        System.out.println(connection4);
//        System.out.println(connection5);
//        System.out.println(connection6);
//        System.out.println(connection7);
//
//
//        connection6.createData();

          StudentManagement sm1 = StudentManagement.getInstance();
          sm1.create(new Student("s_1", "A", 20));
          sm1.create(new Student("s_2", "B", 19));
          
          StudentManagement sm2 = StudentManagement.getInstance();
          sm2.create(new Student("s_3", "C", 21));
          sm2.create(new Student("s_4", "G", 33));
          
          
          System.out.println("SM1: ");
          sm1.show();
          System.out.println("SM2: ");
          sm2.show(); //sm2 trỏ tới cùng 1 vị trí instance sm1 vì chỉ tạo 1 instance thôi các lần sau cũng tương tự chỉ trỏ tới instance của sm1
          
          





    }
    
}

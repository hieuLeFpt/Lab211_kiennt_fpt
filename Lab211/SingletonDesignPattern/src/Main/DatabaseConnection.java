package Main;

public class DatabaseConnection {

    public  static int counter = 0; // biến toàn cục sd thông qua tên class
    private String fromComputerId;
    private boolean alive;

    private DatabaseConnection(String fromComputerId){
        this.fromComputerId = fromComputerId;
        this.alive = true;
        DatabaseConnection.counter++;
    }

    public String getFromComputerId() {
        return fromComputerId;
    }

    public void setFromComputerId(String fromComputerId) {
        this.fromComputerId = fromComputerId;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean Alive) {
        this.alive = alive;
    }
    
    public void createData() {
        if(this.alive) {
            System.out.println("Action success!");
        } else {
            System.out.println("Connection is dead!");
        }
    }
    
    public void updateDate() {
        if(this.alive) {
            System.out.println("Action success!");
        } else {
            System.out.println("Connection is dead!");
        }
        
    }
    
    public void readData() {
        if(this.alive) {
            System.out.println("Action success!");
        } else {
            System.out.println("Connection is dead!");
        }
    }
    
    public void deleData() {
        if(this.alive) {
            System.out.println("Action success!");
        } else {
            System.out.println("Connection is dead!");
        }
    }
    
    public void close() {
        
        this.alive = false;
        DatabaseConnection.counter --;
        
    }

    
    @Override
    public String toString() {
        return String.format("Connection [fromComputerId= %s]", this.fromComputerId);
    }
    
    public static DatabaseConnection createNewInstance(String fromComputerId) {
        
        if(DatabaseConnection.counter < 5) {
            return new DatabaseConnection(fromComputerId);
        } else {
            return null;
        }
        
    }
    
}

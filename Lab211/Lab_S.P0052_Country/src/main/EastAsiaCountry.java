package main;


public class EastAsiaCountry extends Country{
    
    protected String terrain;

    public EastAsiaCountry() {
        super();
    }

    public EastAsiaCountry(String terrain) {
        this.terrain = terrain;
    }

    public EastAsiaCountry(String countryCode, String countryName, float totalArea, String terrain) {
        super(countryCode, countryName, totalArea);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

   
    public void display() {
        super.display();
        System.out.format("%-10s\n", this.terrain);
    }
    
    
    
}

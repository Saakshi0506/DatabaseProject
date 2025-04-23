package example.celestialDB.model;

// Exoplanets.java - Model class representing an Exoplanet entity
 
public class Exoplanets {
    private int exoplanet_id;
    private String name;
    private String type;
    private double mass;
    private double distance_AU;
    private double orbital_period;
    private int star_id;  // foreign key reference to Star

    public Exoplanets() {}
    public Exoplanets(int exoplanet_id, String name, String type,double mass,double distance_AU, double orbital_period, int star_id) {
        this.exoplanet_id = exoplanet_id; 
        this.name = name;
        this.mass = mass;
        this.distance_AU = distance_AU;
        this.type = type; 
        this.orbital_period = orbital_period;
        this.star_id = star_id;
       
    }
    public Exoplanets(String name, String type, double mass,double distance_AU, double orbital_period, int star_id ) 
    {
        this(0, name, type,mass, distance_AU, orbital_period, star_id);
    }
    // Getters and setters...
    public int getExoplanet_id() { return exoplanet_id; }
    public void setId(int exoplanet_id) { this.exoplanet_id = exoplanet_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getMass(){return mass;}
    public void setMass(double mass){this.mass = mass;}
    public double getDistance_AU(){ return distance_AU;}
    public void setDistance_AU(double distance_AU){this.distance_AU = distance_AU;}
    public double getOrbital_period() { return orbital_period; }
    public void setOrbital_period(double orbital_period) { this.orbital_period = orbital_period; }
    public int getStar_id() { return star_id; }
    public void setStar_id(int star_id) { this.star_id = star_id; }
    @Override public String toString() { return name; }
}

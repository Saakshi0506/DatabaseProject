package example.celestialDB.model;

// Stars.java - Model class representing a Star entity
 
public class Stars {
    private int star_id;
    private String name;
    private String type;
    private String constellation;
    private double distanceLY;
    private double mass;
    private int galaxy_id;  // foreign key reference to Galaxy

    public Stars() {}
    public Stars(int star_id, String name, String type,String constellation,double distanceLY, double mass, int galaxy_id) {
        this.star_id = star_id; 
        this.name = name;
        this.type = type; 
        this.mass = mass;
        this.constellation = constellation;
        this.distanceLY = distanceLY;
        this.galaxy_id = galaxy_id;
    }
    public Stars(String name, String type, String constellation,double distanceLY, double mass, int galaxy_id) {
        this(0, name, type, constellation, distanceLY, mass, galaxy_id);
    }
    // Getters and setters...
    public int getStar_id() { return star_id; }
    public void setStar_id(int star_id) { this.star_id = star_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getConstellation() { return constellation; }
    public void setConstellation(String constellation) { this.constellation = constellation; }
    public double getDistanceLY() { return distanceLY; }
    public void setDistanceLY(double distanceLY) { this.distanceLY = distanceLY; }
    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }
    public int getGalaxy_id() { return galaxy_id; }
    public void setGalaxy_id(int galaxy_id) { this.galaxy_id = galaxy_id; }
    @Override public String toString() { return name; }
}

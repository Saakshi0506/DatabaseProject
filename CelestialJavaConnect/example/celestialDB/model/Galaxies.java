package example.celestialDB.model;

// GalaxIES.java - Model class representing a Galaxy entity
 
public class Galaxies {
    private int galaxy_id;
    private String name;
    private String type;
    private int distanceLY;  // in light years

    public Galaxies() {}
    public Galaxies(int galaxy_id, String name, String type, int distanceLY) {
        this.galaxy_id = galaxy_id; this.name = name;
        this.type = type; this.distanceLY = distanceLY;
    }
    public Galaxies(String name, String type, int distanceLY) {
        this(0, name, type, distanceLY);
    }
    // Getters and setters...
    public int getGalaxy_id() { return galaxy_id; }
    public void setId(int galaxy_id) { this.galaxy_id = galaxy_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getDistanceLY() { return distanceLY; }
    public void setDistance(int distance) { this.distanceLY = distanceLY; }
    @Override public String toString() { return name; }
}





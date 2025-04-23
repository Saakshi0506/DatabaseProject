// GalaxyDAO.java - DAO for Galaxy table
package example.celestialDB.dao;
import example.celestialDB.model.Galaxies;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GalaxyDAO {
    // Retrieve all galaxies from the database
    public List<Galaxies> getAllGalaxies() throws SQLException {
        List<Galaxies> galaxies = new ArrayList<>();
        String sql = "SELECT * FROM Galaxies";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Galaxies galaxy = new Galaxies(
                    rs.getInt("galaxy_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("distanceLY")
                );
                galaxies.add(galaxy);
            }
        }
        return galaxies;
    }
    // Retrieve a single galaxy by its ID
    public Galaxies getGalaxyById(int id) throws SQLException {
        Galaxies galaxy = null;
        String sql = "SELECT * FROM Galaxies WHERE galaxy_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                galaxy = new Galaxies(
                    rs.getInt("galaxy_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("distanceLY")
                );
            }
        }
        return galaxy;
    }
    // Insert a new galaxy (auto-generates an ID)
    public boolean addGalaxies(Galaxies galaxy) throws SQLException {
        String sql = "INSERT INTO Galaxies(name, type, distanceLY) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, galaxy.getName());
            stmt.setString(2, galaxy.getType());
            stmt.setInt(3, galaxy.getDistanceLY());
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                // Get generated key (new galaxy_id) and set it
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    galaxy.setId(keys.getInt(1));
                }
                return true;
            }
            return false;
        }
    }
    // Update an existing galaxy
    public boolean updateGalaxy(Galaxies galaxy) throws SQLException {
        String sql = "UPDATE Galaxies SET name = ?, type = ?, distanceLY = ? WHERE galaxy_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, galaxy.getName());
            stmt.setString(2, galaxy.getType());
            stmt.setInt(3, galaxy.getDistanceLY());
            stmt.setInt(4, galaxy.getGalaxy_id());
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    // Delete a galaxy by ID
    public boolean deleteGalaxy(int id) throws SQLException {
        String sql = "DELETE FROM Galaxies WHERE galaxy_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    // Search galaxies by name (case-insensitive substring match)
    public List<Galaxies> searchGalaxiesByName(String nameQuery) throws SQLException {
        List<Galaxies> resultList = new ArrayList<>();
        String sql = "SELECT * FROM Galaxies WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nameQuery + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Galaxies galaxy = new Galaxies(
                    rs.getInt("galaxy_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("distanceLY")
                );
                resultList.add(galaxy);
            }
        }
        return resultList;
    }
}

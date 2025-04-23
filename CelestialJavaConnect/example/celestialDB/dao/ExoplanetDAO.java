
// ExoplanetDAO.java - DAO for Exoplanet table
package example.celestialDB.dao;
import example.celestialDB.model.Exoplanets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExoplanetDAO {
    public List<Exoplanets> getAllExoplanets() throws SQLException {
        List<Exoplanets> exoplanets = new ArrayList<>();
        String sql = "SELECT * FROM Exoplanets";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Exoplanets exo = new Exoplanets(
                    rs.getInt("exoplanet_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("mass"),
                    rs.getDouble("distance_AU"),
                    rs.getDouble("orbital_period"),
                    rs.getInt("star_id")
                );
                exoplanets.add(exo);
            }
        }
        return exoplanets;
    }
    public Exoplanets getExoplanetById(int exoplanet_id) throws SQLException {
        Exoplanets exo = null;
        String sql = "SELECT * FROM Exoplanets WHERE exoplanet_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, exoplanet_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exo = new Exoplanets(
                    rs.getInt("exoplanet_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("mass"),
                    rs.getDouble("distance_AU"),
                    rs.getDouble("orbital_period"),
                    rs.getInt("star_id")
                );
            }
        }
        return exo;
    }
    public boolean addExoplanet(Exoplanets exoplanet) throws SQLException {
        String sql = "INSERT INTO Exoplanets(name, type, mass, distance_AU, orbital_period, star_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, exoplanet.getName());
            stmt.setString(2, exoplanet.getType());
            stmt.setDouble(3, exoplanet.getMass());
            stmt.setDouble(4, exoplanet.getDistance_AU());
            stmt.setDouble(5, exoplanet.getOrbital_period());
            stmt.setInt(6, exoplanet.getStar_id());
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    exoplanet.setId(keys.getInt(1));
                }
                return true;
            }
            return false;
        }
    }
    public boolean updateExoplanet(Exoplanets exoplanet) throws SQLException {
        String sql = "UPDATE Exoplanets SET name = ?, type = ?, mass = ?, distance_AU = ?, orbital_period = ?, star_id = ? WHERE exoplanet_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exoplanet.getName());
            stmt.setString(2, exoplanet.getType());
            stmt.setDouble(3, exoplanet.getMass());
            stmt.setDouble(4, exoplanet.getDistance_AU());
            stmt.setDouble(5, exoplanet.getOrbital_period());
            stmt.setInt(6, exoplanet.getStar_id());
            stmt.setInt(7, exoplanet.getExoplanet_id());
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    public boolean deleteExoplanet(int id) throws SQLException {
        String sql = "DELETE FROM Exoplanet WHERE exoplanet_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    public List<Exoplanets> searchExoplanetsByName(String nameQuery) throws SQLException {
        List<Exoplanets> resultList = new ArrayList<>();
        String sql = "SELECT * FROM Exoplanets WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nameQuery + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Exoplanets exo = new Exoplanets(
                    rs.getInt("exoplanet_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("mass"),
                    rs.getDouble("distance_AU"),
                    rs.getDouble("orbital_period"),
                    rs.getInt("star_id")
                );
                resultList.add(exo);
            }
        }
        return resultList;
    }
}


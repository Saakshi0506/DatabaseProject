// StarDAO.java - DAO for Star table
package example.celestialDB.dao;
import example.celestialDB.model.Stars;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StarDAO {
    public List<Stars> getAllStars() throws SQLException {
        List<Stars> stars = new ArrayList<>();
        String sql = "SELECT * FROM Stars";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Stars star = new Stars(
                    rs.getInt("star_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("constellation"),
                    rs.getDouble("distanceLY"),
                    rs.getDouble("mass"),
                    rs.getInt("galaxy_id")
                );
                stars.add(star);
            }
        }
        return stars;
    }
    public Stars getStarById(int id) throws SQLException {
        Stars star = null;
        String sql = "SELECT * FROM Stars WHERE star_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                star = new Stars(
                    rs.getInt("star_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("constellation"),
                    rs.getDouble("distanceLY"),
                    rs.getDouble("mass"),
                    rs.getInt("galaxy_id")
                );
            }
        }
        return star;
    }
    public boolean addStar(Stars star) throws SQLException {
        String sql = "INSERT INTO Stars(name, type, constellation, distanceLY, mass, galaxy_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, star.getName());
            stmt.setString(2, star.getType());
            stmt.setString(3, star.getConstellation());
            stmt.setDouble(4, star.getDistanceLY());
            stmt.setDouble(5, star.getMass());
            stmt.setInt(6, star.getGalaxy_id());
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    star.setGalaxy_id(keys.getInt(1));
                }
                return true;
            }
            return false;
        }
    }
    public boolean updateStar(Stars star) throws SQLException {
        String sql = "UPDATE Stars SET name = ?, type = ?, constellation = ?, distanceLY = ?, mass = ?, galaxy_id = ? WHERE star_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, star.getName());
            stmt.setString(2, star.getType());
            stmt.setString(3, star.getConstellation());
            stmt.setDouble(4, star.getDistanceLY());
            stmt.setDouble(5, star.getMass());
            stmt.setInt(6, star.getGalaxy_id());
            stmt.setInt(7, star.getStar_id());
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    public boolean deleteStar(int id) throws SQLException {
        String sql = "DELETE FROM Stars WHERE star_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            return (affected > 0);
        }
    }
    public List<Stars> searchStarsByName(String nameQuery) throws SQLException {
        List<Stars> resultList = new ArrayList<>();
        String sql = "SELECT * FROM Stars WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nameQuery + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Stars star = new Stars(
                    rs.getInt("star_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("constellation"),
                    rs.getDouble("distanceLY"),
                    rs.getDouble("mass"),
                    rs.getInt("galaxy_id")
                );
                resultList.add(star);
            }
        }
        return resultList;
    }
}

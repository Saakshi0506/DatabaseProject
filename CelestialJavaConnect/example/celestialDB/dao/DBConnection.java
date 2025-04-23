// DBConnection.java - Utility class for managing the JDBC connection
package example.celestialDB.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/CelestialDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "22_22_22";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Driver not found
        }
    }
    public static Connection getConnection() throws SQLException {
        // Establish and return a new database connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}  
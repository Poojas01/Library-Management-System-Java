import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String USER = "root"; // Change based on your MySQL credentials
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

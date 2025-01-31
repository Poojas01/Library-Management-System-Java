import java.sql.*;

public class UserManager {
    public static void addUser(String name, String email) {
        try (Connection con = DBConnection.connect();
             PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

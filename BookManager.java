import java.sql.*;

public class BookManager {
    public static void addBook(String title, String author) {
        try (Connection con = DBConnection.connect();
             PreparedStatement ps = con.prepareStatement("INSERT INTO books (title, author, available) VALUES (?, ?, TRUE)")) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listBooks() {
        try (Connection con = DBConnection.connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
            System.out.println("ID | Title | Author | Available");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s%n",
                        rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

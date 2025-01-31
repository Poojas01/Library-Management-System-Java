import java.sql.*;

public class TransactionManager {
    public static void issueBook(int userId, int bookId) {
        try (Connection con = DBConnection.connect()) {
            String checkAvailability = "SELECT available FROM books WHERE id=?";
            PreparedStatement checkStmt = con.prepareStatement(checkAvailability);
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getBoolean("available")) {
                String issueSQL = "INSERT INTO transactions (user_id, book_id, issue_date) VALUES (?, ?, CURDATE())";
                PreparedStatement issueStmt = con.prepareStatement(issueSQL);
                issueStmt.setInt(1, userId);
                issueStmt.setInt(2, bookId);
                issueStmt.executeUpdate();

                String updateBook = "UPDATE books SET available=FALSE WHERE id=?";
                PreparedStatement updateStmt = con.prepareStatement(updateBook);
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int bookId) {
        try (Connection con = DBConnection.connect()) {
            String updateSQL = "UPDATE books SET available=TRUE WHERE id=?";
            PreparedStatement updateStmt = con.prepareStatement(updateSQL);
            updateStmt.setInt(1, bookId);
            updateStmt.executeUpdate();
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

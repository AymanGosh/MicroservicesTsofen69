import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExceptionExample {
    public static void main(String[] args) {
        try {
            // Attempting to connect to a database with invalid credentials
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentDB", "user", "password");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}

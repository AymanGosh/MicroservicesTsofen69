Connection connection = null;
try {
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "user", "password");
    // Code that may throw exceptions
} catch (SQLException e) {
    // Handle the exception
} finally {
    // Ensure database connection closure
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            // Handle close exception if needed
        }
    }
}

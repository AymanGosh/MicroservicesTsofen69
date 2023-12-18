import java.sql.Connection;

public class SQLExcept {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";

	public static final String USERNAME = "SomeUser";
	public static final String PASSWORD = "SomeP@ss";


	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		Class.forName(JDBC_DRIVER);
		return connection;
	}

	static class Runner {
		public static void main(String[] args) {

			SQLExcept sqlExcept = new SQLExcept();
			try {
				Connection connection = sqlExcept.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

}
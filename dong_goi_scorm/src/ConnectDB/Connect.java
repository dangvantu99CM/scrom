package ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
	public static Connection connectDB() {
		Connection conn1 = null;
		try {
			String url1 = "jdbc:mysql://localhost/dong_goi_scorm";
            String user = "root";
            String password = "";	
            conn1 = DriverManager.getConnection(url1, user, password);
		}catch(Exception ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
		}
		return conn1;
	}
	public static void main(String []args) {
		Connect.connectDB();
	}
}

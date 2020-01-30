package login.FrameLogin.da;

import Account.User;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDA {
    public boolean checkLogin(String name, String password) throws SQLException{
        Connection con = ConnectDB.Connect.connectDB();
        String sql = "SELECT * FROM account WHERE ac_name = ? AND ac_password = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next())
                return true;
        return false;
    }
}

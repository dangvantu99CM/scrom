package login.FrameLogin.da;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Account.*;
import ConnectDB.Connect;

public class ItemDA {
	private Connection con=Connect.connectDB();
	
	public ItemDA() {}
	
	public ArrayList<User> getAll() throws SQLException{
            ArrayList<User> listUser = new ArrayList<User>();

            String sql = "SELECT * FROM account";
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10));
                listUser.add(user);
            }
            return listUser;
	}
	
	public boolean deleteUser(int id) throws SQLException{
            String sql = "DELETE FROM account WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();	
            return result>0;
	}
	
	public boolean updateUser(User user) throws SQLException {
            String sql = "update account set ac_name = ?,ac_password=? where id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getPassword());
            stmt.setInt(3,user.getId());
            int result = stmt.executeUpdate();	
            return result>0;
	}
	
	public boolean addUser(User user) throws SQLException{
            String sql =  "INSERT INTO account (ac_name,ac_password,ac_address,ac_phone,ac_email,ac_gioi_tinh,ac_name_login) "
                        +  "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getAddress());
            stmt.setInt(4, user.getPhone());
            stmt.setString(5, user.getEmail());
            stmt.setInt(6, user.getGender());
            stmt.setString(7, user.getNameLogin());
            int result = stmt.executeUpdate();	
            return result>0;
	}
	
	public static void main(String[] args) throws SQLException {
            ItemDA qe = new ItemDA();
            ArrayList<User> listUser = qe.getAll();
            for(User u : listUser) {
                System.out.println("user=============="+u.getName());
            }
	}
	
}

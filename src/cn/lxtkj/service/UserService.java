package cn.lxtkj.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import cn.lxtkj.conn.Conn;
import cn.lxtkj.model.UserTable;

public class UserService {

	private Connection conn;
	private PreparedStatement pstmt;

	public UserService() {
		Conn con = new Conn();
		conn = con.getCon();
	}
	
	public boolean valiUser(UserTable user) {
		
		try {
			pstmt=(PreparedStatement) conn.prepareStatement("select * from usertable where username=? and password=?");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

package cn.ch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.ch.bean.*;
import cn.ch.util.DBCPUtils;

public class UserDao {
	//列出全部的用户
	public static List<User> getAllUsers() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<User> users = new ArrayList<User>();
		String sql = "select * from users";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			//int userid, String name, String phone, String address, String idcard
			while(rst.next()) {
				User user = new User(rst.getInt("userid"), rst.getString("name"),
						rst.getString("phone"), rst.getString("address"), rst.getString("idcard"),rst.getString("qmail"));
				users.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return users;
		
	}
	//根据用户ID查询某个用户信息
	public static User getByID(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		User user = null;
		String sql = "select * from users where userid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rst = stmt.executeQuery();
			
			//int userid, String name, String phone, String address, String idcard
			while(rst.next()) {
				user = new User(id, rst.getString("name"),
						rst.getString("phone"), rst.getString("address"), rst.getString("idcard"),rst.getString("qmail"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return user;
		
	}
	public static boolean changePwd(String qmail, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		User user = null;
		String sql = "update userpwd set password = ? where qmail = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pwd);
			stmt.setString(2, qmail);
			int x = stmt.executeUpdate();
			if(x < 0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static User getByMail(String qmail) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		User user = null;
		String sql = "select * from users where qmail = ? limit 1";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qmail);
			rst = stmt.executeQuery();
			
			while(rst.next()) {
				user = new User(rst.getInt("userid"), rst.getString("name"),
						rst.getString("phone"), rst.getString("address"), rst.getString("idcard"),qmail);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return user;
		
	}
	//增加一个用户
	public static boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into users (name,idcard,address,phone,qmail) values(?,?,?,?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getIdcard());
			stmt.setString(3, user.getAddress());
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getQmail());
			int x = stmt.executeUpdate();
			if(x < 0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	public static boolean addUserPwd(String qmail, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into userpwd (qmail, password) values(?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, qmail);
			stmt.setString(2, pwd);
			
			int x = stmt.executeUpdate();
			if(x < 0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	//删除一个用户
	public static boolean deleteUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "delete from users where userid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改用户信息
	public static boolean changeInfo(int id, String address,String phone,String mail) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "UPDATE users set address = ?, phone = ?,qmail = ? WHERE userid = ?";
		try {
			conn = DBCPUtils.getConnection();  
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, address);
			stmt.setString(2, phone);
			stmt.setString(3, mail);
			stmt.setInt(4, id);
			int x = stmt.executeUpdate();
			if(x < 0) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	public static String getpwd(String qmail) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		User user = null;
		String sql = "select * from userpwd where qmail = ?";
		String pwd = "";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qmail);
			rst = stmt.executeQuery();
			pwd = rst.getString("password");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pwd;
	}
	public static boolean isExist(String qmail, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try {
			String sql = "select * from userpwd where qmail=? and password=? limit 1";
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qmail);
			stmt.setString(2, password);
			rst = stmt.executeQuery();
			int count = 0;
			rst.last();
			count=rst.getRow();
			System.out.println(count);
			if(count == 1) {
				System.out.println("isexist true");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//stmt.close();
			
		}
		return false;
	}
}

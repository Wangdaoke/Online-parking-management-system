package cn.ch.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ch.bean.Manager;
import cn.ch.bean.User;
import cn.ch.util.DBCPUtils;

public class ManagerDao {
	
	public static boolean isExist(Manager manager) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try {
			String sql = "select * from manager where username=? and password=? limit 1";
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, manager.getUsername());
			stmt.setString(2, manager.getPassword());
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
	public static List<Manager> getAllManagers() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Manager> managers = new ArrayList<Manager>();
		String sql = "select * from manager";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			//int userid, String name, String phone, String address, String idcard
			while(rst.next()) {
				Manager manager = new Manager(rst.getString("username"),rst.getString("password"));
				managers.add(manager);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return managers;
		
	}
	public static boolean addAdmin(Manager manager) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into manager values(?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, manager.getUsername());
			stmt.setString(2, manager.getPassword());
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
	public static boolean changePwd(String username, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		User user = null;
		String sql = "update manager set password = ? where username = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pwd);
			stmt.setString(2, username);
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
}

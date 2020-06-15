package cn.ch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.ch.bean.Log;
import cn.ch.bean.User;
import cn.ch.util.DBCPUtils;

public class LogDao {
	public static List<Log> getAllLogs() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Log> logs = new ArrayList<Log>();
		String sql = "select * from logs";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			//int userid, String name, String phone, String address, String idcard
			while(rst.next()) {
				Log log = new Log(rst.getInt("logid"),rst.getString("manager"),rst.getString("ltable"),rst.getString("action"),
						rst.getDate("actiontime"));
				logs.add(log);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return logs;
		
	}
	//增加一条日志
	public static boolean addLog(Log log) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into logs (logid,manager,ltable,action,actiontime) values(?,?,?,?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, log.getManager());
			stmt.setString(3, log.getTable());
			stmt.setString(4, log.getAction());
			stmt.setTimestamp(5, new java.sql.Timestamp(log.getTime().getTime()));
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
	public static List<Log> getPageList(int currpage, int limit){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Log> loglist = new ArrayList<Log>();
		String sql = "select * from logs limit ?,?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, currpage);
			stmt.setInt(2, limit);
			rst = stmt.executeQuery();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//int logid, String manager, String table, String action, Date time
			while(rst.next()) {
				Log log = new Log(rst.getInt("logid"),rst.getString("manager"),rst.getString("ltable"),
						rst.getString("action"),ft.format(rst.getTimestamp("actiontime")));
				loglist.add(log);
			}
			return loglist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int getcount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		int count=0;
		String sql = "select count(*) from logs";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			if(rst.next()) {
				count = rst.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}

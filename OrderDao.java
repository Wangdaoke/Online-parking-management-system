package cn.ch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.ch.bean.*;
import cn.ch.util.DBCPUtils;

public class OrderDao {
	public static List<Order> getAllOrders() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from orders";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			// int orderid, int carid, int userid, Date starttime, Date returntime, double
			// price, int state
			while (rst.next()) {
				Order order = new Order(rst.getInt("orderid"), rst.getInt("carid"), rst.getInt("userid"),
						rst.getTimestamp("starttime"), rst.getTimestamp("returntime"), rst.getDouble("price"),
						rst.getInt("state"));
				orders.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return orders;

	}

	public static boolean addOrder(Order order) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into orders (orderid,carid,userid,starttime,returntime,price,state) values(?,?,?,?,?,?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, order.getOrderid());
			stmt.setInt(2, order.getCarid());
			stmt.setInt(3, order.getUserid());
			stmt.setTimestamp(4, new java.sql.Timestamp(order.getStarttime().getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(order.getReturntime().getTime()));
			stmt.setDouble(6, order.getPrice());
			stmt.setInt(7, order.getState());
			int x = stmt.executeUpdate();
			if (x < 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	public static boolean changeStatus(int orderid, int carid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "update orders set returntime=?,price=?,state=1 where orderid = ?";
		Date date = new Date();
		Date date1;
		
		try {
			date1 = OrderDao.getStarttime(orderid);
			long days = (date.getTime()-date1.getTime()) / (1000 * 60 * 60 * 24); 
			days = days == 0?1:days;
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
			stmt.setDouble(2, CarDao.getCarPrice(carid)*days);
			stmt.setInt(3, orderid);
			int result = stmt.executeUpdate();
			if(result < 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static Date getStarttime(int orderid) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Date date = null;
		
		String sql = "select starttime from orders where orderid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderid);
			rst = stmt.executeQuery();
			
			if(rst.next()) {
				date = rst.getDate("starttime");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return date;
		
	}
	public static Order getByCarid(int carid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Order order = new Order();
		//order = null;
		String sql = "select * from orders where carid = ? and state = 0 limit 1";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, carid);
			rst = stmt.executeQuery();
			if(rst.next()) {
				order.setOrderid(rst.getInt("orderid"));
				order.setUserid(Integer.parseInt(rst.getString("userid")));
				order.setStarttime(rst.getDate("starttime"));
				order.setReturntime(rst.getDate("returntime"));
				return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static List<Order> getbyUserid(int userid){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from orders where userid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userid);
			rst = stmt.executeQuery();
			// int orderid, int carid, int userid, Date starttime, Date returntime, double
			// price, int state
			while (rst.next()) {
				Order order = new Order(rst.getInt("orderid"), rst.getInt("carid"), rst.getInt("userid"),
						rst.getTimestamp("starttime"), rst.getTimestamp("returntime"), rst.getDouble("price"),
						rst.getInt("state"));
				orders.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return orders;
	}
}

package cn.ch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.ch.bean.Car;
import cn.ch.bean.User;
import cn.ch.util.DBCPUtils;

public class CarDao {
	public static List<Car> getAllCars() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		List<Car> cars = new ArrayList<Car>();
		String sql = "select * from car";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			
			while(rst.next()) {
				Car car = new Car(rst.getInt("carid"), rst.getString("carnumber"),rst.getString("describe"), 
						rst.getDouble("price"), rst.getString("model"),rst.getString("image"),rst.getInt("state"));
				cars.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return cars;
		
	}
	public static Double getCarPrice(int carid) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		double price = 0;
		
		String sql = "select price from car where carid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, carid);
			rst = stmt.executeQuery();
			
			if(rst.next()) {
				price = rst.getDouble("price");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//stmt.close();
		}
		return price;
	}
	public static boolean delCar(int carid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "delete from car where carid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, carid);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean changeCarinfo(int carid, String desc, double price) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		String sql = "update car set `describe` = ?,price = ? where carid = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, desc);
			stmt.setDouble(2, price);
			stmt.setInt(3, carid);
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
	public static boolean changeCarStatus(int carid, int status) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "update car set state=? where carid = ?";
		Date date = new Date();
		Date date1;
		
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setInt(2, carid);
			int result = stmt.executeUpdate();
			if(result < 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean addACar(Car car) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "insert into car (carid,carnumber,`describe`,price,model,`image`,state) values(?,?,?,?,?,?,?)";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2,car.getCarNumber());
			stmt.setString(3, car.getDescribe());
			stmt.setDouble(4, car.getPrice());
			stmt.setString(5, car.getModel());
			stmt.setString(6, "");
			stmt.setInt(7, 1);
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
	public static boolean addCarImage(String carnumber, String image) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		String sql = "update car set `image`=? where carnumber = ?";
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, image);
			stmt.setString(2, carnumber);
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

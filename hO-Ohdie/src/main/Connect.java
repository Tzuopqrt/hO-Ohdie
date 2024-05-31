package main;

import main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;



public class Connect {
	/*
	 * Database name: binus
	 * Table name: students
	 * Attribute:
	 * Id int primary key NOT NULL
	 * name VARCHAR(100) NOT NULL
	 * Age INT NOT NULL
	 * Major VARCHAR(100) NOT NULL
	 * IPK DOUBLE  NOT NULL
	 */
	
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE_NAME = "ho-ohdie";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE_NAME);
	
	public ResultSet rs; // nampung hasil query dalam bentuk set
	public ResultSetMetaData rsm; // buat lihat detailnya
	
	public Statement st; //statement dari query
	public Connection con; //untuk koneksi ke db
	
	private static Connect connect;
	
	// Singleton -> memastikan object hanya dibuat satu kali
	public static Connect getInstance() {
		if (connect == null)return new Connect();
		return connect;
	}
	Connect() {
		try {
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// method untuk mengecek username yang sama
	public boolean usernameExist(String UserName) {
	try {
		con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE Username = ?"); 
			st.setString(1, UserName);
			rs = st.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}	
	
	// method untuk mengecek apakah username dan password benar
	public String LoginValidation(String username, String password) {
		try {
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE Username = ? AND Password = ?");
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString("Role");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	// Method untuk mengembalikan hasil query kita
	public ResultSet execQuery(String query) {
		try {
			rs = st.executeQuery(query);
			rsm = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void execInsert(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execUpdate(String query) {
	    try {
	        Connection connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
	        Statement statement = connection.createStatement();
	        statement.executeUpdate(query);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public double getTotalPrice() {
		try {
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			rs = st.executeQuery(CONNECTION);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
		
	}
	
	public String getUserID(String username, String password) {
		String userIDLogin = null;
		
		try {
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			String query = "SELECT UserID From user WHERE Username = ? AND Password = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				userIDLogin = rs.getString("UserID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userIDLogin;
	}

	public void getCartData(String UserID, String HoodieID, int quantity) {
		try {
			String HoodieName = null;
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			String query = "INSERT INTO cart VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, UserID);
			ps.setString(2, HoodieID);
			ps.setInt(3, quantity);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Message");
				alert.setContentText(UserID + " - " + HoodieName + " - " + quantity + "x added!");
				Button okbtn = new Button("OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getCartData(String userID) {
		List<String> cart = new ArrayList<>();
		String query = "SELECT c.HoodieID, h.HoodieName, c.Quantity, (h.HoodiePrice * c.Quantity) as TotalPrice FROM cart c JOIN hoodie h ON c.HoodieID = h.HoodieID WHERE c.UserID = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String cartdata = rs.getString("HoodieID") + rs.getInt("Quantity") + rs.getDouble("TotalPrice");
				cart.add(cartdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	public ResultSet execQuery(String query, String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public double getHoodiePrice(String hoodieID) {
//		double HoodiePrice = 0;
//		String query = "SELECT HoodiePrice FROM hoodie WHERE HoodieID = ?";
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setString(1, hoodieID);
//		rs = ps.executeQuery();
//		
//			
//		}
//	}
	
//	public List<Hoodie> getCart(String userID) {
//		String query = "SELECT * FROM cart WHERE UserID = ?";
//		try {
//			PreparedStatement ps  = con.prepareStatement(query);
//			ps.setString(1, userID);
//			rs = ps.executeQuery();
//			List<Hoodie> cartitem = new ArrayList<>();
//			while (rs.next()) {
//				Hoodie hoodies = new Hoodie(rs.getString(0), query)
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
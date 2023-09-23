import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class CarCRUD {

	Connection con = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_002", "root", "6361264809");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveCar(String name, double price, String color) {

		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO car(name,price,color) VALUES('"+name+"',"+price+",'"+color+"')";
              st.execute(sql);
              con.close();
              return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void viewCar(){
		try {
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql="SELECT * FROM car";
			st.execute(sql);
			ResultSet rs=st.getResultSet();
			
			System.out.printf("%-5s %-10s %-10s %-10s ","id","name","price","color");
			System.out.println();
			while (rs.next()) {
				System.out.printf("%-5s %-10s %-10s %-10s ",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
				System.out.println();
				/*
				 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
				 * System.out.println(rs.getDouble(3)); System.out.println(rs.getString(4));
				 */
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

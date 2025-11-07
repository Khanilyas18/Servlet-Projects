package jdbc_update_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Updatedemo {
	public static void main(String[] args) throws Exception {
		String name = "Haseem";
		String city1 = "mumbai";
		String email1 = "anit@gmail.com";
		String pass1 = "admin123";
		String gender = "male";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Khanilyas08");

		PreparedStatement ps = con
				.prepareStatement("update register set name= ?,email = ?,password = ?, gender = ?,city = ? ");

		ps.setString(1, city1);
		ps.setString(2, email1);
		ps.setString(3, pass1);
		ps.setString(4, gender);
		ps.setString(5, name);
		

		int count = ps.executeUpdate();
		
		if (count > 0) {
			System.out.println("Success");
		} else {
			System.out.println("failed");
		}
	
	}
}

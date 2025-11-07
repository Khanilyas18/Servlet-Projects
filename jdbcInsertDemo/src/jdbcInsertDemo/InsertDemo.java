package jdbcInsertDemo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class InsertDemo {

	public static void main(String[] args) throws Exception {
		//-------User value-----------
		String name1 = "anita";
		String email1 = "anit@gmail.com";
		String pass1 = "anita123";
		String gen1 = "female";
		String city1 = "dehradun";




		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Khanilyas08");
//	System.out.println("Success");
		PreparedStatement ps = con.prepareStatement("insert into register values (?,?,?,?,?)");
		ps.setString(1, name1);
		ps.setString(2, email1);
		ps.setString(3, pass1);
		ps.setString(4, gen1);
		ps.setString(5, city1);
		
		int i = ps.executeUpdate();	
		
		
		if (i>0) {
			System.out.println("Success");
		}
		else {
			System.out.println("fail");
		}
	}
}


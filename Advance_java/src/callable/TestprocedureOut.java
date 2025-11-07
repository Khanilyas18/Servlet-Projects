package callable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.CallableStatement;

public class TestprocedureOut {
public static void main(String[] args) throws Exception {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root","Khanilyas08");
	
	CallableStatement callStmt =  conn.prepareCall("{CALL userOut(?)}");
	
	callStmt.registerOutParameter(1, Types.VARCHAR);
	
	callStmt.execute();
	
	String resultValue = callStmt.getString(1);
	
	System.out.println("Result from userOut stored procedure:"+resultValue);
	
	} catch(Exception e) {
		e.printStackTrace();
	}
}
}

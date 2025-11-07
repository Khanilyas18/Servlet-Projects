package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.bean.StudentBean;

import util.JDBCDataSource;

public class MM0del {
 
	public Integer nextpk(){
		Connection conn = null;
		int pk =0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_student");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			
			rs.getInt(pk);
			conn.commit();
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk+1;
		
	}
	public long add( StudentBean bean) {
		int pk=0;
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_students values(?,?,?,?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2,bean.getCollegeName());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("data added"+i);
		} catch (Exception e) {
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk;
		
	}
}

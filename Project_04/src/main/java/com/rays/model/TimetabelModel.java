package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.bean.TimetableBean;

import util.JDBCDataSource;

public class TimetabelModel {

	public Integer nextpk() {
		
		int pk =0;
		Connection conn = null;
		try {
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareCall("select max(ID) from st_timetable");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			rs.getInt(1);
			conn.commit();
		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk+1;
		
	}
	
	public long add(TimetableBean bean) {
		
		int pk =0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (Exception e) {
		
		}
		
		return 0;
		
	}
	
	
}

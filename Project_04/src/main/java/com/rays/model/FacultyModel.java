package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.FacultyBean;
import util.JDBCDataSource;

public class FacultyModel {

	public int nextPk() {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM st_faculty");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(FacultyBean bean) {

		int pk = 0;
		Connection conn = null;
		try {

			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into st_faculty values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFisrtName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getCollegeId());
			pstmt.setString(9, bean.getCollegeName());
			pstmt.setLong(10, bean.getCourseId());
			pstmt.setString(11, bean.getCourseName());
			pstmt.setLong(12, bean.getSubjectId());
			pstmt.setString(13, bean.getSubjectName());
			pstmt.setString(14, bean.getCreatedby());
			pstmt.setString(15, bean.getModifiedBy());
			pstmt.setTimestamp(16, bean.getCreatedDatetime());
			pstmt.setTimestamp(17, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			System.out.println("Data added" + i);
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;

	}

	public long update(FacultyBean bean) {
		int i = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE st_faculty SET first_name=?, last_name=?, dob=?, gender=?, mobile_no=?, email=?, college_id=?, college_name=?, course_id=?, course_name=?, subject_id=?, subject_name=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? WHERE id=?");

			pstmt.setString(1, bean.getFisrtName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getMobileNo());
			pstmt.setString(6, bean.getEmail());
			pstmt.setLong(7, bean.getCollegeId());
			pstmt.setString(8, bean.getCollegeName());
			pstmt.setLong(9, bean.getCourseId());
			pstmt.setString(10, bean.getCourseName());
			pstmt.setLong(11, bean.getSubjectId());
			pstmt.setString(12, bean.getSubjectName());
			pstmt.setString(13, bean.getCreatedby());
			pstmt.setString(14, bean.getModifiedBy());
			pstmt.setTimestamp(15, bean.getCreatedDatetime());
			pstmt.setTimestamp(16, bean.getModifiedDatetime());
			pstmt.setLong(17, bean.getId());

			i = pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

			System.out.println("Data updated: " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return i; // return rows updated
	}

	public void delete(long id) {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_faculty where id = ?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data deleted" + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public FacultyBean findByPk(long id) {

		Connection conn = null;
		FacultyBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_faculty where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new FacultyBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollegeId(rs.getLong(8));
				bean.setCollegeName(rs.getString(9));
				bean.setCourseId(rs.getLong(10));
				bean.setCourseName(rs.getString(11));
				bean.setSubjectId(rs.getLong(12));
				bean.setSubjectName(rs.getString(13));
				bean.setCreatedBy(rs.getString(14));
				bean.setModifiedBy(rs.getString(15));
				bean.setCreatedDatetime(rs.getTimestamp(16));
				bean.setModifiedDatetime(rs.getTimestamp(17));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}
public FacultyBean findbyEmail(String email ) {
		
		Connection conn = null;
		FacultyBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt  = conn.prepareStatement("select * from st_faculty where email = ?");
            pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
             
             while (rs.next()) {
				bean = new FacultyBean();
				
				bean = new FacultyBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollegeId(rs.getLong(8));
				bean.setCollegeName(rs.getString(9));
				bean.setCourseId(rs.getLong(10));
				bean.setCourseName(rs.getString(11));
				bean.setSubjectId(rs.getLong(12));
				bean.setSubjectName(rs.getString(13));
				bean.setCreatedBy(rs.getString(14));
				bean.setModifiedBy(rs.getString(15));
				bean.setCreatedDatetime(rs.getTimestamp(16));
				bean.setModifiedDatetime(rs.getTimestamp(17));
			}
             
             
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
			
		}
		
		return bean;
		
	}
public List search(FacultyBean bean, int pageNo, int pageSize) {
	
	
	Connection conn = null;
	List list = new ArrayList();
	
	try {
		conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from st_faculty where 1=1");

		if (bean != null) {
			if (bean.getFisrtName() != null && bean.getFisrtName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFisrtName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and last_name like '" + bean.getLastName() + "%'");
			}
			if (bean.getEmail() != null && bean.getEmail().length() > 0) {
				sql.append(" and email like '" + bean.getEmail() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCourseId(rs.getLong(10));
			bean.setCourseName(rs.getString(11));
			bean.setSubjectId(rs.getLong(12));
			bean.setSubjectName(rs.getString(13));
			bean.setCreatedBy(rs.getString(14));
			bean.setModifiedBy(rs.getString(15));
			bean.setCreatedDatetime(rs.getTimestamp(16));
			bean.setModifiedDatetime(rs.getTimestamp(17));
			list.add(bean);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCDataSource.closeConnection(conn);
	}
	
	
	return list;
	
}


}



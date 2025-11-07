package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.StudentBean;

import util.JDBCDataSource;

public class StudentModel {

	public Integer nextPk() {

		int pk = 0;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_student");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk + 1;

	}

	public void add(StudentBean bean) {
		int pk = 0;
		Connection conn = null;
		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into st_student values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getCollegeId());
			pstmt.setString(9, bean.getCollegeName());
			pstmt.setString(10, bean.getCreatedby());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			System.out.println("Data added" + i);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void update(StudentBean bean) {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update st_student set first_name = ?, lastname = ?, dob = ?, gender = ?, mobile_no = ?, email = ?, college_id = ?, college_name = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getMobileNo());
			pstmt.setString(6, bean.getEmail());
			pstmt.setLong(7, bean.getCollegeId());
			pstmt.setString(8, bean.getCollegeName());
			pstmt.setString(9, bean.getCreatedby());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data updated" + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public void delete(long id) {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id = ?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			System.out.println("Data deleted" + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public StudentBean findByPk(long id) {

		Connection conn = null;
		StudentBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_student where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollegeId(rs.getLong(8));
				bean.setCollegeName(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

	public StudentBean findByEmail(String email) {
		Connection conn = null;
		StudentBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_student where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new StudentBean();

				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollegeId(rs.getLong(8));
				bean.setCollegeName(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

	public List<StudentBean> search(StudentBean bean, int pageSize, int pageNo) {
		Connection conn = null;
		List<StudentBean> list = new ArrayList<>();
		try {
			conn=JDBCDataSource.getConnection();
			
			StringBuffer sql = new StringBuffer("SELECT * FROM st_student WHERE 1=1");
			if (bean != null) {
				if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
					sql.append(" and first_name like '" + bean.getFirstName() + "%'");
				}
				if (bean.getLastName() != null && bean.getLastName().length() > 0) {
					sql.append(" and last_name like '" + bean.getLastName() + "%'");
				}
				if (bean.getEmail() != null && bean.getEmail().length() > 0) {
					sql.append(" and email like '" + bean.getEmail() + "%'");
				}
				if (pageSize > 0) {
					pageNo = (pageNo - 1) * pageSize;
					sql.append(" limit " + pageNo + ", " + pageSize);
				}
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					StudentBean sbean = new StudentBean();
					sbean.setId(rs.getLong(1));
					sbean.setFirstName(rs.getString(2));
					sbean.setLastName(rs.getString(3));
					sbean.setDob(rs.getDate(4));
					sbean.setGender(rs.getString(5));
					sbean.setMobileNo(rs.getString(6));
					sbean.setEmail(rs.getString(7));
					sbean.setCollegeId(rs.getLong(8));
					sbean.setCollegeName(rs.getString(9));
					sbean.setCreatedBy(rs.getString(10));
					sbean.setModifiedBy(rs.getString(11));
					sbean.setCreatedDatetime(rs.getTimestamp(12));
					sbean.setModifiedDatetime(rs.getTimestamp(13));
					list.add(sbean);
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;

	}

}

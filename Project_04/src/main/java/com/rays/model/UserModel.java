package com.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.bean.UserBean;

import util.JDBCDataSource;

public class UserModel {

	public int nextPk() {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_USER");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);

			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(UserBean bean) {
		int pk = 0;
		Connection conn = null;
		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileno());
			pstmt.setLong(8, bean.getRollId());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getCreatedby());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			int i = pstmt.executeUpdate();
			System.out.println("Data added" + i);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public void update(UserBean bean) {
		Connection conn1 = null;
		try {
			conn1 = JDBCDataSource.getConnection();
			conn1.setAutoCommit(false);
			PreparedStatement pstmt = conn1
					.prepareStatement("UPDATE st_user SET first_name=?,lastname=?,login=?,password=?,"
							+ "dob=?,mobile_no=?,roll_id=?,gender=?,created_by=?,modified_by=?,craeted_datetime=?,modified=?WHERE id=?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getMobileno());
			pstmt.setLong(7, bean.getRollId());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getCreatedby());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());
			int i = pstmt.executeUpdate();
			conn1.commit();
			System.out.println("data updated" + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn1);
		}
	}

	public void delete(long id) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
			pstmt.setLong(1,id);
			int i = pstmt.executeUpdate();
			System.out.println("Data deleted" + i);

			conn.commit();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
		
		public UserBean finByPk(long id) {
			Connection conn = null;
			UserBean bean = null;
			try {
				conn = JDBCDataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");
				pstmt.setLong(1, id);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					
					bean = new UserBean();
					bean.setId(rs.getLong(1));
					bean.setFirstName(rs.getString(2));
					bean.setLastName(rs.getString(3));
					bean.setLogin(rs.getString(4));
					bean.setPassword(rs.getString(5));
					bean.setDob(rs.getDate(6));
					bean.setMobileno(rs.getString(7));
					bean.setRollId(rs.getLong(8));
					bean.setGender(rs.getString(9));
					bean.setCreatedBy(rs.getString(10));
					bean.setModifiedBy(rs.getString(11));
					bean.setCreatedDatetime(rs.getTimestamp(12));
					bean.setModifiedDatetime(rs.getTimestamp(13));
					conn.commit();
					conn.close();
					System.out.println("data find by pk"+rs);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
			
		}
		public UserBean findByLogin(String login) {
			
			Connection conn = null;
			UserBean bean = null;
			
			try {
				conn = JDBCDataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login=?");
				pstmt.setString(1, login);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new UserBean();
					bean.setId(rs.getLong(1));
					bean.setFirstName(rs.getString(2));
					bean.setLastName(rs.getString(3));
					bean.setLogin(rs.getString(4));
					bean.setPassword(rs.getString(5));
					bean.setDob(rs.getDate(6));
					bean.setMobileno(rs.getString(7));
					bean.setRollId(rs.getLong(8));
					bean.setGender(rs.getString(9));
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
	
}

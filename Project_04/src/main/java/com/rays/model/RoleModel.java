package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.bean.Rolebean;

import util.JDBCDataSource;

public class RoleModel {

	public Integer nextPk() {

		int pk = 0;

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id)from st_role");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				pk = rs.getInt(1);

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(Rolebean bean) {

		int pk = 0;
		Connection conn = null;

		try {

			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_role values(?,?,?,?,?,?,?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedby());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted " + i);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JDBCDataSource.closeConnection(conn);

		}
	}

	public void update(Rolebean bean) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE st_role SET name =?,description=?,createdby=?,"
					+ "modifiedby=?,createddatetime=?,modifieddatetime=?WHERE id=?");
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setString(3, bean.getCreatedby());
			pstmt.setString(4, bean.getModifiedBy());
			pstmt.setTimestamp(5, bean.getCreatedDatetime());
			pstmt.setTimestamp(6, bean.getModifiedDatetime());
			pstmt.setLong(7, bean.getId());
			int i = pstmt.executeUpdate();
			System.out.println("Data Updated : " + i);
			conn.commit();
			pstmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public void delete(long id) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_role where ID=?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			System.out.println("Data delete" + i);
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public Rolebean findBypk(long id) {
		Connection conn = null;
		Rolebean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_role where ID=?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new Rolebean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCreatedBy(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	public Rolebean findbyName(String name) {

		Connection conn = null;
		Rolebean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_role where NAME=?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				bean = new Rolebean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				rs.close();
				pstmt.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

}

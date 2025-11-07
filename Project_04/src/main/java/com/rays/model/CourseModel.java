package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.CourseBean;

import util.JDBCDataSource;

public class CourseModel {
	public Integer nextPk() {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_course");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;

	}

	public long add(CourseBean bean) {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDuration());
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getCreatedby());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			System.out.println("Data added" + i);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;

	}

	public void update(CourseBean bean) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update st_course set NAME=?,DURATION=?,DESCRIPTION=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED=? where ID=?");
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDuration());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedby());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println("Data Updated" + i);
			conn.commit();
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
			PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id = ?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			System.out.println("Data deleted" + i);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public CourseBean findBypk(long id) {

		Connection conn = null;
		CourseBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_course where id =?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDuration(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;

	}

	public CourseBean findByName(String name) {
		Connection conn = null;
		CourseBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_course where NAME = ?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDuration(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;

	}
	
	public List<CourseBean> search(CourseBean bean,int pageNo,int pageSize) {
		StringBuffer sql = new StringBuffer("select * from st_course where 1=1");
		
		
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		
		Connection conn = null;
		List<CourseBean> list = new ArrayList<CourseBean>();

		try {

				conn = JDBCDataSource.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new CourseBean();

					bean.setId(rs.getLong(1));
					bean.setName(rs.getString(2));
					bean.setDuration(rs.getString(3));
					bean.setDescription(rs.getString(4));
					bean.setCreatedBy(rs.getString(5));
					bean.setModifiedBy(rs.getString(6));
					bean.setCreatedDatetime(rs.getTimestamp(7));
					bean.setModifiedDatetime(rs.getTimestamp(8));
					list.add(bean);

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}

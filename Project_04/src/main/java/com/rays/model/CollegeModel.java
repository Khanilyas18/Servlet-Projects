package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.CollegeBean;
import com.rays.bean.CourseBean;

import util.JDBCDataSource;

public class CollegeModel {
	public Integer nextPk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_college");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	public long add(CollegeBean bean) {
		int pk = 0;
		Connection conn = null;
		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_college values(?,?,?,?,?,?,?,?,?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedby());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("data added");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	public void update(CollegeBean bean) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update st_college \r\n"
					+ "set name=?, address=?, state=?, city=?, phone_no=?, created_by=?, created_datetime=?, modified_datetime=? \r\n"
					+ "where id=?");
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setString(3, bean.getState());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getCreatedby());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("data updated");
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
			PreparedStatement pstmt = conn.prepareStatement("delete from st_college where id = ?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			System.out.println("Data Deleted" + i);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public CollegeBean findBypk(long id) {
		Connection conn = null;
		CollegeBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from st_college where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new CollegeBean();
				bean.setId(rs.getLong("id"));
				bean.setName(rs.getString("name"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setCity(rs.getString("city"));
				bean.setPhoneNo(rs.getString("phone_no"));
				bean.setCreatedBy(rs.getString("created_by"));
				bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
				bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
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
	public List<CollegeBean> search(CollegeBean bean,int pageNo,int pageSize){
		Connection conn = null;
		ArrayList<CollegeBean> list = new ArrayList<CollegeBean>();
		try {
			conn = JDBCDataSource.getConnection();
			StringBuffer sql = new StringBuffer("select * from st_college where 1=1");
			if (bean != null) {
				if (bean.getId() > 0) {
					sql.append(" and id = " + bean.getId());
				}
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" and name like '" + bean.getName() + "%'");

				}
				if (bean.getCity() != null && bean.getCity().length() > 0) {
					sql.append(" and city like '" + bean.getCity() + "%'");
				}
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append(" limit " + pageNo + "," + pageSize);
			}
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				 bean = new CollegeBean();
				bean.setId(rs.getLong("id"));
				  bean.setName(rs.getString("name"));
		            bean.setAddress(rs.getString("address"));
		            bean.setState(rs.getString("state"));
		            bean.setCity(rs.getString("city"));
		            bean.setPhoneNo(rs.getString("phone_no"));
		            bean.setCreatedBy(rs.getString("created_by"));
		            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
		            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
		            list.add(bean);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
		
	}
	
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Order1;

public class Order1Dao {
	
	private static Order1Dao instance = new Order1Dao();
	
	private Order1Dao() {}

	public static Order1Dao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection con, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public int getTotalCnt() throws SQLException {
		int tot = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from order1";

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next())
				tot = rs.getInt(1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}

	public List<Order1> orderList() throws SQLException {
		List<Order1> list = new ArrayList<Order1>(); // ﻿DTO에 있는 모든 컬럼을 select 한 것

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT  o.order_date , o.custcode , o.order_desc , o.sabun , o.order_status"
				+ " ,c.custname   , s.sawon_name" + " FROM   order1 o, custom c, sawon s"
				+ " WHERE  o.custcode = c.custcode      " + " AND    o.sabun = s.sabun(+)         ";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order1 order1 = new Order1();
				order1.setOrder_date(rs.getString("order_date"));
				order1.setCustcode(rs.getInt("custcode"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setSabun(rs.getInt("sabun"));
				order1.setOrder_status(rs.getString("order_status"));
				order1.setCustname(rs.getString("custname"));
				order1.setSawon_name(rs.getString("sawon_name"));
				list.add(order1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	

	public Order1 select(String order_date, int custcode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT o.order_date, o.custcode, o.order_desc, o.sabun, o.order_status, c.custname, s.sawon_name "
				+ "FROM order1 o, custom c, sawon s " + "WHERE o.order_date=? and o.custcode=? " // ***
				+ "AND o.custcode = c.custcode     " + "AND o.sabun = s.sabun(+)     ";
		System.out.println("Order1 select sql-> " + sql);
		Order1 order1 = new Order1();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_date);
			pstmt.setInt(2, custcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				order1.setOrder_date(rs.getString("order_date"));
				order1.setCustcode(rs.getInt("custcode"));
				order1.setCustname(rs.getString("custname"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setSabun(rs.getInt("sabun"));
				order1.setSawon_name(rs.getString("sawon_name"));
				order1.setOrder_status(rs.getString("order_status"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return order1;
	}
}

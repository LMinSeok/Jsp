package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;
import order.dto.OrderVO;
import order.dto.UsersVO;

@Setter
@Getter
public class OrderDAO {
	

	private static OrderDAO instance = new OrderDAO();

	private OrderDAO() {
	}

	public static OrderDAO getInstance() {
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
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//

	// 전체 데이터 DB에서 주문한 상품 가져오기

	public List<OrderVO> selectAllBoards() {
		List<OrderVO> list = new ArrayList<>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select * from product";

		try {

			con = getConnection();

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("rs>>" + rs);
			while (rs.next()) {
				
				OrderVO vo = new OrderVO();
				
				vo.setOrderId(rs.getString("orderid"));
				vo.setProduct(rs.getString("product"));
				vo.setCustomerName(rs.getString("customerName"));
				vo.setOrderDate(rs.getTimestamp("orderDate"));
				vo.setPrice(rs.getInt("price"));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return list;
	}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 장바구니 삭제

	public int deleteSelectedOrders(List<String> orderIdList) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = getConnection();

			String sql = "DELETE FROM product WHERE orderId = ?";
			pstmt = con.prepareStatement(sql);

			for (String orderId : orderIdList) {
				System.out.println(orderId);
				pstmt.setString(1, orderId);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return result;
	}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	public UsersVO selectOrderByNum(int num) {

		UsersVO vo = new UsersVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from users where num = ?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setAddr(rs.getString("addr"));
				vo.setAddr2(rs.getString("addr2"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return vo;
	}

}
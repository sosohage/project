package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBuse {

	Connection conn = null;
	
	Statement st = null;
	
	ResultSet rs = null;
	
	PreparedStatement pstmt = null;

	private String result;
	
	public Connection getDBConn() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //com.mysql.cj.jdbc.Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "cban", "root", "1234");
			st = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		return conn;
	}
	public List<DBdata> readData() {
		
		List<DBdata> list = new ArrayList<>();
		
		try {
			conn = new DBuse().getDBConn();
			st = conn.createStatement();
			String sql = "Select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				
				DBdata dd = new DBdata();
				
				dd.setCallnumber(rs.getString("callnumber"));
				dd.setTitle(rs.getString("title"));
				dd.setPrice(rs.getInt("price"));
				dd.setAuthor(rs.getString("author"));
				dd.setPublisher(rs.getString("publisher"));
				dd.setField(rs.getString("field"));
				dd.setDate(rs.getDate("date"));
				list.add(dd);
				
			}
			
		} catch (SQLException e) {
			System.out.println("DB 연결 오류1");
		}
		return list;
		
	}
	
	public String image_data(String callnumber) throws SQLException {
		
		conn = new DBuse().getDBConn();
		st = conn.createStatement();
		String sql = "Select image from book where callnumber = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,callnumber );
		rs = pstmt.executeQuery(sql);
		
		try {

			while(rs.next()){
				
				result = rs.getString("image");
				
			}
			
		} catch (SQLException e) {
			System.out.println("DB 연결 오류1");
		}
		return result;
		
	} 
	

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
	
}

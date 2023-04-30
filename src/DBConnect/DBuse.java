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

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public Connection getDBConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cban", "root", "1234");
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
            conn = getDBConn();
            String sql = "SELECT * FROM book";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                DBdata dd = new DBdata();
                dd.setBook_id(rs.getInt("book_id"));
                dd.setCallnumber(rs.getString("callnumber"));
                dd.setTitle(rs.getString("title"));
                dd.setPrice(rs.getInt("price"));
                dd.setAuthor(rs.getString("author"));
                dd.setPublisher(rs.getString("publisher"));
                dd.setDate(rs.getString("date"));
                dd.setField(rs.getString("field"));
                dd.setSearch(rs.getInt("search"));
                dd.setCheckout(rs.getInt("checkout"));
                dd.setImage(rs.getString("image"));
                list.add(dd);
            }
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        } finally {
            dbClose();
        }
        return list;
    }

    public List<DBdata> searchData(String title, String author, String publisher, String field) {
        List<DBdata> result = new ArrayList<>();
        try {
            conn = getDBConn();
            String sql = "SELECT * FROM book WHERE title LIKE '%" + title + "%' OR author LIKE '%" + author
                    + "%' OR publisher LIKE '%" + publisher + "%' OR field LIKE '%" + field + "%'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	int book_id = rs.getInt("book_id");
                String callnumber = rs.getString("callnumber");
                String booktitle = rs.getString("title");
                int price = rs.getInt("price");
                String authorName = rs.getString("author");
                String publisherName = rs.getString("publisher");
                String date = rs.getString("date");
                String fieldInfo = rs.getString("field");
                String image = rs.getString("image");
                result.add(new DBdata(callnumber, booktitle, price, authorName, publisherName, fieldInfo, date, image));
            }
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        } finally {
        	dbClose();
        }

    
    return result;
}


	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}

	
}

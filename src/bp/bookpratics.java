package bp;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DBConnect.*;

public class bookpratics extends JFrame {
	
	List<DBdata> books;
	String bookimage;
	DefaultTableModel model;

	public bookpratics() {
		

		setTitle("도서 검색");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JTextField searchtxt = new JTextField();
		JButton searchbtn = new JButton("검색");
		
		String[] header = {"기호","제목","가격","저자","출판사","분야","출시일"};
		 model = new DefaultTableModel(header,0);

		JTable sr = new JTable(model);
		JScrollPane jsp = new JScrollPane(sr);
		
		searchtxt.setLocation(100, 50);
		searchtxt.setSize(900, 50);
		
		searchbtn.setLocation(1000, 50);
		searchbtn.setSize(90, 50);
		
		sr.setLocation(400, 120);
		sr.setSize(600, 400);
		
		sr.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int row = sr.rowAtPoint(e.getPoint());
				int col = sr.columnAtPoint(e.getPoint());
				
				if(sr.getColumnName(col).equalsIgnoreCase("image")) {
					
					DBdata tmp = books.get(row);
					
					try {
						bookimage = new DBuse().image_data(tmp.getCallnumber());
						
						ImageIcon icon = new ImageIcon(bookimage);
						JLabel image = new JLabel(icon);
						
						image.setBounds(10, 120, 300, 500);
						c.add(image);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
		});
		
		jsp.setBounds(400, 120, 700, 500);
		
		showBook();
		
		
		c.add(searchbtn);
		c.add(searchtxt);
		c.add(jsp);
		
		
		setSize(1200, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void showBook() {
		
		books = new DBuse().readData();
		for(DBdata tmp:books) {
			Object[] row = {tmp.getCallnumber(),tmp.getTitle(),tmp.getPrice(),tmp.getAuthor(),tmp.getPublisher(),tmp.getField(),tmp.getDate()};
			model.addRow(row);
			
		}
		
	}
}

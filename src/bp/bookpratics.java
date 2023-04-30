package bp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBConnect.DBdata;
import DBConnect.DBuse;

public class bookpratics extends JFrame {
    List<DBdata> list;
    DefaultTableModel model;
    JLabel imageLabel = null;

    @SuppressWarnings("serial")
	public bookpratics() {
        setTitle("도서 검색");
        Container c = getContentPane();
        c.setLayout(null);

        JTextField searchtxt = new JTextField();
        JButton searchbtn = new JButton("검색");

        String[] header = {"기호", "제목", "가격", "저자", "출판사", "분야", "출시일","경로"};
        model = new DefaultTableModel(header, 0) {
            public boolean isCellEditable(int rowIndex, int mColindex) {
                return false;
            }// 값 수정 불가
        };
        
        JTable sr = new JTable(model);
        JScrollPane jsp = new JScrollPane(sr);

        searchtxt.setLocation(100, 50);
        searchtxt.setSize(900, 50);

        searchbtn.setLocation(1000, 50);
        searchbtn.setSize(90, 50);

        jsp.setBounds(400, 120, 700, 500);
        
        sr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = sr.getSelectedRow();

                String imageurl = (String) sr.getModel().getValueAt(row, 7);
                ImageIcon imageIcon = null;
                if (imageurl != null) {
                    try {
                        imageIcon = new ImageIcon(new URL(imageurl));
                        imageLabel.setIcon(imageIcon); // JLabel에 이미지 설정
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // JLabel 위치와 크기 설정
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 120, 300, 500);
        c.add(imageLabel);

        searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == searchbtn) {
                    String keyword = searchtxt.getText();

                    list = new DBuse().searchData(keyword, keyword, keyword, keyword);
                    model.setRowCount(0);
                    for (DBdata tmp : list) {
                        Object[] row = {tmp.getCallnumber(), tmp.getTitle(), tmp.getPrice(),
                                tmp.getAuthor(), tmp.getPublisher(), tmp.getField(), tmp.getDate(),tmp.getImage()};
                        model.addRow(row);
                    }
                    imageLabel.setIcon(null); // 검색 결과가 변경되면 JLabel의 이미지 초기화
                }
            }
        });
        
        imageLabel = new JLabel();
        imageLabel.setBounds(10, 120, 300, 500);
        c.add(imageLabel);
        
        showbook(); //DB값들 출력

        c.add(searchbtn);
        c.add(searchtxt);
        c.add(jsp);
        
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void showbook() {
    	
        list = new DBuse().readData();
    	model.setRowCount(0);
    	for (DBdata tmp : list) {
    	    Object[] row = {tmp.getCallnumber(), tmp.getTitle(), tmp.getPrice(),
    	            tmp.getAuthor(), tmp.getPublisher(), tmp.getField(), tmp.getDate(), tmp.getImage()};
    	    model.addRow(row); //결과 출력
    	}
    	
    }

    
}


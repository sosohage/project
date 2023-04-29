package DBConnect;

import java.util.Date;

public class DBdata {
	private String callnumber;
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String field;
	private Date date;
	private String image;
	public DBdata() {
		super();
	}
	
	public DBdata(String callnumber,String title,int price,String author,String publisher,String field,Date date) {
		
		this.callnumber = callnumber;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.field = field;
		this.date = date;
	}
	
	public String getCallnumber() {
		
		return callnumber;
		
	}	
	
	public void setCallnumber(String callnumber) {
		
		this.callnumber = callnumber;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}

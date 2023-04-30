package DBConnect;

import java.util.Date;

public class DBdata {
private int book_id;
private String callnumber;
private String title;
private int price;
private String author;
private String publisher;
private String date;
private String field;
private int search;
private int checkout;
private String image;

public DBdata() {}

public DBdata(String callnumber, String title, int price, String author, String publisher, String field, String date,String image) {
    this.callnumber = callnumber;
    this.title = title;
    this.price = price;
    this.author = author;
    this.publisher = publisher;
    this.field = field;
    this.date = date;
    this.image = image;
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

public void setPrice(int price) {
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

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

public int getBook_id() {
	return book_id;
}

public void setBook_id(int book_id) {
	this.book_id = book_id;
}

public int getSearch() {
	return search;
}

public void setSearch(int search) {
	this.search = search;
}

public int getCheckout() {
	return checkout;
}

public void setCheckout(int checkout) {
	this.checkout = checkout;
}

}
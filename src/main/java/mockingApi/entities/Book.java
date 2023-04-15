package mockingApi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="books")
public class Book {
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBooPrice(int bookPrice) {
		this.bookPrice=bookPrice;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="book_name",nullable=false)
	private String bookName;
	@Column(name="book_price",nullable=false)
	private int bookPrice;

}

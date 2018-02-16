package org.vo;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private String bookId;
	private String bookname;
	private String author;
	private Integer restnum;
	private Double price;

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(String bookId) {
		this.bookId = bookId;
	}

	/** full constructor */
	public Books(String bookId, String bookname, String author,
			Integer restnum, Double price) {
		this.bookId = bookId;
		this.bookname = bookname;
		this.author = author;
		this.restnum = restnum;
		this.price = price;
	}

	// Property accessors

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRestnum() {
		return this.restnum;
	}

	public void setRestnum(Integer restnum) {
		this.restnum = restnum;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
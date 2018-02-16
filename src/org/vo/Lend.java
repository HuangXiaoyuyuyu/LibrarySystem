package org.vo;

import java.util.Date;

/**
 * Lend entity. @author MyEclipse Persistence Tools
 */

public class Lend implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bookId;
	private String readerId;
	private Integer num;
	private Date lendtime;

	// Constructors

	/** default constructor */
	public Lend() {
	}

	/** minimal constructor */
	public Lend(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Lend(Integer id, String bookId, String readerId, Integer num,
			Date lendtime) {
		this.id = id;
		this.bookId = bookId;
		this.readerId = readerId;
		this.num = num;
		this.lendtime = lendtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getReaderId() {
		return this.readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Date getLendtime() {
		return this.lendtime;
	}

	public void setLendtime(Date lendtime) {
		this.lendtime = lendtime;
	}

}
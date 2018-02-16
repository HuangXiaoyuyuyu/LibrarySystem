package org.vo;

import java.util.Date;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private String readerId;
	private String name;
	private String spec;
	private Integer sex;
	private Date born;
	private Integer num;

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** minimal constructor */
	public Students(String readerId) {
		this.readerId = readerId;
	}

	/** full constructor */
	public Students(String readerId, String name, String spec, Integer sex,
			Date born, Integer num) {
		this.readerId = readerId;
		this.name = name;
		this.spec = spec;
		this.sex = sex;
		this.born = born;
		this.num = num;
	}

	// Property accessors

	public String getReaderId() {
		return this.readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return this.born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
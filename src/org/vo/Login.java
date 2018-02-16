package org.vo;

/**
 * Login entity. @author MyEclipse Persistence Tools
 */

public class Login implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Integer role;

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** minimal constructor */
	public Login(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Login(Integer id, String name, String password, Integer role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
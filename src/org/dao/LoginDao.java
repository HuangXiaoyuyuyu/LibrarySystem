package org.dao;

import org.vo.Login;

public interface LoginDao {
	public Login checkLogin(String name,String password);
}

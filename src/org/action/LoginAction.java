package org.action;

import java.util.Map;

import org.dao.LoginDao;
import org.dao.imp1.LoginDaoImp1;
import org.vo.Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Login>{
	private Login login;
	private LoginDao loginDao;
	@Override
	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

	public LoginAction( ) {
		super();
		this.login =new Login();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public String login(){
		
		Login login1 = loginDao.checkLogin(login.getName(),login.getPassword());
		 if(login1.getRole()==0){
				return "studentSuccess";
				}else if(login1.getRole()==1){
				return "managerSuccess";
				}else{
			     return ERROR;
			}
		}
		/*try {
			Login login1 = loginDao.checkLogin(login.getName(),login.getPassword());
			if(login1!=null){
				Map session = ActionContext.getContext().getSession();
				session.put("login",login1);
				return SUCCESS;
			}
			return ERROR;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return ERROR;
		}	
	}*/
	@Override
	public void validate(){
		if(login.getName()==null||login.getName().equals("")){
			this.addFieldError("name","用户名不能为空！");
		}
		 if(login.getPassword()==null||login.getPassword().equals("")){
			this.addFieldError("password", "密码不能为空！");
		} 
	} 	
}

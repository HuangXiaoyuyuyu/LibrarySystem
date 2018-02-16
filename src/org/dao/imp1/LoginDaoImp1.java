package org.dao.imp1;

import org.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import org.vo.Login;

public class LoginDaoImp1 implements LoginDao{
SessionFactory hibernateSessionFactory;
	
	public void setHibernateSessionFactory(
			SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
	}
	@Override
	public Login checkLogin(String name, String password) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Login login = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Login where name='"+ name +"' and password='"+ password +"'");
//			query.setParameter(0, name);
//			query.setParameter(1, password);
//			query.setMaxResults(1);
			login=(Login) query.uniqueResult();
			tx.commit();
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println("12313213");
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
		}
		
		return login;
	}

}

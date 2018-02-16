package org.dao.imp1;

import org.dao.StudentsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import org.vo.Students;

public class StudentsDaoImp1 implements StudentsDao{
SessionFactory hibernateSessionFactory;
	
	public void setHibernateSessionFactory(
			SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
		System.out.println("chu fa le set fang fa");
	}
	@Override
	public Students selectStudent(String readerId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Students students = null;
		try {
			session =hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			students = (Students) session.get(Students.class,readerId);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
//			session.close();
		}
		
		
		return students;
	}

}

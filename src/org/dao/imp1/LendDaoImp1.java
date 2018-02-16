package org.dao.imp1;

import java.util.List;

import org.dao.LendDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import org.vo.Books;
import org.vo.Lend;
import org.vo.Students;

public class LendDaoImp1 implements LendDao{
	SessionFactory hibernateSessionFactory;
	
	public void setHibernateSessionFactory(
			SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
	}
	@Override
	public List selectBook(String readerId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List list = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("select 1.Id,l.bookId,b.bookname,b.author,b.price,l.lendtime from Lend as l,Books as b where l.bookId=b.bookId and l.readerId='"+readerId+"' ");
			//query.setParameter(0, readerId);
			list = query.list();
			tx.commit();
		//	System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			//session.close();
		}
		
		return list;
	}

	@Override
	public int selectBookSize(String readerId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		int size = 0;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Lend where readerId='"+readerId+"'");
//			query.setParameter(0, readerId);
			size = query.list().size();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			//session.close();
		}
		
		return size;
	}

	@Override
	public void addLend(Lend lend, Books books, Students students) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
 			tx = session.beginTransaction();
 			lend.setId(1);
			session.save(lend);
			session.update(books);
			session.update(students);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
		//	session.close();
		}
		
	}

	@Override
	public Lend selcetByBookId(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			lend = (Lend) session.get(Lend.class, id);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
		//	session.close();
		}
		
		return lend;
	}

}

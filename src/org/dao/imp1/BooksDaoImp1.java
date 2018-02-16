package org.dao.imp1;

import java.util.List;

import org.dao.BooksDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import org.vo.Books;

public class BooksDaoImp1 implements BooksDao{
	SessionFactory hibernateSessionFactory;
	
	public void setHibernateSessionFactory(
			SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
	}

	@Override
	public void addBook(Books books) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.save(books);
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
		
	}

	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			Books books = (Books) this.selectBook(bookId);
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(books);
			tx.commit();			
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			//session.close();
		}
		
	}

	@Override
	public void updateBook(Books books) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.update(books);
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
		
	}

	
	@Override
	public Books selectBook(String bookId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Books books = null;
		try {
			session=hibernateSessionFactory.getCurrentSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("from Books where bookId='"+bookId+"'");
//			query.setParameter(0, bookId);
//			query.setMaxResults(1);
			books=(Books) query.uniqueResult();
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
		
		return books;
	}

	@Override
	public List queryAllBooks() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List list = null;
		try {
			session = hibernateSessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Books");
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
				e.printStackTrace();
			}
		}
		return list;
	}

	 
	
}

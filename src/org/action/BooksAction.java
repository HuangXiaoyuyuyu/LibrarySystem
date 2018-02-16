package org.action;

import java.util.List;
import java.util.Map;

import org.dao.BooksDao;
import org.dao.imp1.BooksDaoImp1;
import org.dao.imp1.LendDaoImp1;
import org.vo.Books;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BooksAction extends ActionSupport{
	private String message;
	private Books books;
	private BooksDao booksDao;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	
	
	public BooksDao getBooksDao() {
		return booksDao;
	}
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	public String addBook() throws Exception{
		 
		Books b = new Books();
		b.setBookId(books.getBookId());
		b.setBookname(books.getBookname());
		b.setAuthor(books.getAuthor());
		b.setRestnum(books.getRestnum());
		b.setPrice(books.getPrice());
		booksDao.addBook(b);
		this.setMessage("添加成功！");
		return SUCCESS;
	}
	
	public String deleteBook() throws Exception{
		if(books.getBookId()==null||books.getBookId().equals("")){
			this.setMessage("请输入Id号");
			return INPUT;
		}else if(booksDao.selectBook(books.getBookId())==null){
			this.setMessage("您输入的Id号不存在");
			return INPUT;
		}else if (new LendDaoImp1().selcetByBookId(books.getBookId())!=null) {
			this.setMessage("该图书已经被借出，故不能删除！");
			return INPUT;
		}
		booksDao.deleteBook(books.getBookId());
		this.setMessage("删除成功！");
		return SUCCESS;
	}
	
	public String selectBook() throws Exception{
		Books b = (Books) booksDao.selectBook(books.getBookId());
		if(b==null){
			this.setMessage("不存在的Id！");
			return INPUT;
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("onebook",b);
		return SUCCESS;
	}
	
	public String updateBook() throws Exception{
		Books b = (Books) booksDao.selectBook(books.getBookId());
		if(b==null){
			this.setMessage("不存在此Id号");
			return INPUT;
		}
		b.setBookname(books.getBookname());
		b.setAuthor(books.getAuthor());
		b.setRestnum(books.getRestnum());
		b.setPrice(books.getPrice());
		booksDao.updateBook(b);
		this.setMessage("修改成功！");
		return SUCCESS;
	}
	
	public String queryAllBooks() throws Exception{
		List list = booksDao.queryAllBooks();
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("list",list);
		return SUCCESS;
	}
	

}

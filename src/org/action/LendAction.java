package org.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dao.BooksDao;
import org.dao.LendDao;
import org.dao.StudentsDao;
import org.dao.imp1.BooksDaoImp1;
import org.dao.imp1.LendDaoImp1;
import org.dao.imp1.StudentsDaoImp1;
import org.hibernate.validator.constraints.Length;
import org.vo.Books;
import org.vo.Lend;
import org.vo.Students;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;

public class LendAction extends ActionSupport{
	private Lend lend;
	private String message;
	private LendDao lendDao;
	private StudentsDao studentDao;
	private BooksDao booksDao;
	
	public BooksDao getBooksDao() {
		return booksDao;
	}
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	public StudentsDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentsDao studentDao) {
		this.studentDao = studentDao;
	}
	public Lend getLend() {
		return lend;
	}
	public void setLend(Lend lend) {
		this.lend = lend;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public LendDao getLendDao() {
		return lendDao;
	}
	public void setLendDao(LendDao lendDao) {
		this.lendDao = lendDao;
	}



	
	public String selectAllLend() throws Exception{
		if(lend.getReaderId()==null||lend.getReaderId().equals("")){
			this.setMessage("借书证号为空！");
			return INPUT;
		}else if(studentDao.selectStudent(lend.getReaderId())==null) {
			this.setMessage("借书证号为空");
			return INPUT;
		}
		//调用方法，查询出结果
		List list=lendDao.selectBook(lend.getReaderId());
		Map request=(Map) ActionContext.getContext().get("request");
		//保存
		request.put("list",list);
		request.put("reader",lend.getReaderId());
		return SUCCESS;
	}		
	
	public String lendBook() throws Exception{
		if(lend.getBookId()==null||lend.getBookId().equals("")||
			booksDao.selectBook(lend.getBookId())==null	){
					this.setMessage("您没有输入正确的bookId");
					//若失败，也要查询出以前的借书信息，让页面一直出现该读者的借书信息，下同
					List list=lendDao.selectBook(lend.getReaderId()); 
					Map request=(Map) ActionContext.getContext().get("request");
					request.put("readerId", lend.getReaderId());
					request.put("list", list);
					return INPUT;
				}else if(lend.getBookId()==null||lend.getBookId().equals("")){
					this.setMessage("您未输入图书号!");
					List list=lendDao.selectBook(lend.getReaderId());
					Map request=(Map) ActionContext.getContext().get("request");
					request.put("readerId", lend.getReaderId());
					request.put("list", list);
					return INPUT;
				}
				//创建Lend对象
				Lend l=new Lend();
				l.setId(lend.getId());
				l.setBookId(lend.getBookId());
				l.setReaderId(lend.getReaderId());
				l.setLendtime(new Date());
				Books b = (Books) booksDao.selectBook(lend.getBookId());
				b.setRestnum(b.getRestnum()-1);				 
				Students stu=studentDao.selectStudent(lend.getReaderId());				 
				stu.setNum(stu.getNum()+1);				 
				lendDao.addLend(l, b,stu);
				this.setMessage("借书成功！");
				//完成借书后，还要查询出借书信息，这里将把刚刚借得的图书信息也查询出来
				List list=lendDao.selectBook(lend.getReaderId()); 
				Map request=(Map) ActionContext.getContext().get("request");
				request.put("readerId", lend.getReaderId());
				request.put("list", list);				
				return SUCCESS;				
	}
	
}

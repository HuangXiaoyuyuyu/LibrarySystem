package org.dao;

import java.util.List;

import org.vo.Books;
import org.vo.Lend;
import org.vo.Students;

public interface LendDao {
	public List selectBook(String readerId);
	public int selectBookSize(String readerId);
	public void addLend(Lend lend,Books books,Students students);
	public Lend selcetByBookId(String id);
}

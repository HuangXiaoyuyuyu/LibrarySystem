package org.dao;

import java.util.List;

import org.vo.Books;

public interface BooksDao {
	public void addBook(Books books);
	public void deleteBook(String bookId);
	public void updateBook(Books books);
	public Books selectBook(String bookId);
	public List queryAllBooks();	
}

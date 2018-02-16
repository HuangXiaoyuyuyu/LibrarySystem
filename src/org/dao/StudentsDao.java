package org.dao;

import org.vo.Students;

public interface StudentsDao {
	public Students selectStudent(String readerId);
}

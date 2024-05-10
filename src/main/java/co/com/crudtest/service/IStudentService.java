package co.com.crudtest.service;

import java.util.List;

import co.com.crudtest.entity.Student;

public interface IStudentService {

	public List<Student> findAll();
	
	public Student findById(long id);
	
	public void save(Student student);
	
	public void delete(long id);
		
}

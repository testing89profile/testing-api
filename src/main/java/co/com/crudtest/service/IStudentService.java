package co.com.crudtest.service;

import java.util.List;

import co.com.crudtest.entity.Student;

public interface IStudentService {

	public List<Student> findAll();
	
	public Student save(Student student);
}
package co.com.crudtest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.crudtest.entity.Student;
import co.com.crudtest.repository.IStudentRepository;

@Service
public class ImplStudentService implements IStudentService {
	
	private IStudentRepository studentRepository;
	
	public ImplStudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Student findById(long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Student student) {	
		studentRepository.save(student);
	}

	@Override
	public void delete(long id) {
		studentRepository.deleteById(id);
	}
}

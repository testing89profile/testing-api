package co.com.crudtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import co.com.crudtest.entity.Student;
import co.com.crudtest.repository.IStudentRepository;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Test
	public void getAllStudentsTest() {
		List<Student> students =  (List<Student>) studentRepository.findAll();
		assertEquals(4, students.size());
		
	}
	
	@Test
	public void findByIdTest() {
		Optional<Student> student = studentRepository.findById(2L);
		assertTrue(student.isPresent());
		assertEquals("test_name_02", student.orElseThrow().getName());
		
	}
	
	@Test
	public void saveStudentTest() {
		Student newStudent = new Student("testSave", "testSave","testsave@emial.com", 4567896l);
		studentRepository.save(newStudent);
		List<Student> students =  (List<Student>) studentRepository.findAll();
		assertEquals(5, students.size());
		
	}
	
	@Test
	public void deleteStudentTest() {
		studentRepository.deleteById(2l);
		List<Student> students =  (List<Student>) studentRepository.findAll();
		assertEquals(3, students.size());
		
	}
}

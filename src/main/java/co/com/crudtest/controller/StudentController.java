package co.com.crudtest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.crudtest.entity.Student;
import co.com.crudtest.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private IStudentService studentService;
	
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/all")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Student findById(@PathVariable long id){
		return studentService.findById(id);
	}

}

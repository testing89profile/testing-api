package co.com.crudtest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/save")
	public String save(@RequestBody Student student) {
		studentService.save(student);
		return "Estudiante: " + student.getLastName() + " " + student.getName() + ", guardado con exito";
	}
	
	@PutMapping("/update/{id}")
	public Student update(@PathVariable long id, @RequestBody Student student) {
		Student findStudent = studentService.findById(id);
		findStudent.setName(student.getName());
		findStudent.setLastName(student.getLastName());
		findStudent.setEmail(student.getEmail());
		
		studentService.save(findStudent);
		return findStudent;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		studentService.delete(id);
		return "Estudante eliminado.";
	}

}

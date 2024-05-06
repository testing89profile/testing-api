package co.com.crudtest.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.crudtest.entity.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {

}

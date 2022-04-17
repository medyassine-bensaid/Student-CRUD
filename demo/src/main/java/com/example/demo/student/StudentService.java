package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class StudentService  {
	@Autowired
private final StudentRepository studentRepo;


    public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	// show students
	public List<Student> getStudent(){
		return studentRepo.findAll(); 
		
	}	

	// add new Student

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());


		if(studentOptional.isPresent()){
			throw new IllegalStateException("email is already Taken !");
		}
		
		studentRepo.save(student);

}

    public void deleteStudent(Long studentId) {
		boolean exist = studentRepo.existsById(studentId);
		if(!exist){

		throw new IllegalStateException("student with id : "+ studentId +" doesn't exist");

		}
		studentRepo.deleteById(studentId);
    }
	

	@Transactional
    public void updateStudent(long studentId,String name,String email) {

		Student student = studentRepo.findById(studentId).orElseThrow(
			()->new IllegalStateException("Student with "+studentId+" doesn't exist"));

		if (email != null && email.length()>0 && !Objects.equals(student.getEmail(), email) ){
			student.setEmail(email); 
			Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());


		if(studentOptional.isPresent()){
			throw new IllegalStateException("email is already Taken !");
		}
		}
		if (name != null && name.length()>0 && !Objects.equals(student.getName(), name) ){
			student.setName(name); 
		}
    }
}
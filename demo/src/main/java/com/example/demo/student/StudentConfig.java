package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StudentConfig implements CommandLineRunner {

    @Autowired
    private  StudentRepository studentRepo;
    @Override
    public void run(String... args) throws Exception {
       
     Student  student =new Student();
        student.setId(246);
        student.setName("yassine");
        student.setEmail("yassine@gmail.com");
        student.setDateofbirth(LocalDate.of(2002, 2, 20));
        
        studentRepo.save(student);

        Student  student1 =new Student();
        student1.setId(365);
        student1.setName("yahya");
        student1.setEmail("yahya@yahoo.tn");
        student1.setDateofbirth(LocalDate.of(2003, Month.SEPTEMBER, 2));
        
        studentRepo.save(student1);
        

}


}
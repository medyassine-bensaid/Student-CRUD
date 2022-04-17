package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;


@Entity
@Table
public class Student  {
@Id
@SequenceGenerator(
    name ="student_sequence",
    sequenceName="student_sequence",
    allocationSize=1
)
private long id ;
@GeneratedValue(

    strategy=GenerationType.SEQUENCE,
    generator="student_sequence"
)
   
    private String name ;
    private String email ;
    private LocalDate dateofbirth  ;

    @Transient
    private int age ;
    
    
    public Student() {
    }


    public Student(long id, String name, String email, LocalDate dateofbirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateofbirth = dateofbirth;
      
    }


    public Student(String name, String email, LocalDate dateofbirth) {
        this.name = name;
        this.email = email;
        this.dateofbirth = dateofbirth;
        
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getDateofbirth() {
        return dateofbirth;
    }


    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }


    public int getAge() {
        return Period.between(this.dateofbirth, LocalDate.now()).getYears();
    }


    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student [age=" + age + ", dateofbirth=" + dateofbirth + ", email=" + email + ", id=" + id + ", name="
                + name + "]";
    }
  
}

package com.example.demo.student;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Student")
public class StudentController {
    
    private final StudentService studentservice ;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    // select
 @GetMapping
   public List<Student> getStudent(){
    return studentservice.getStudent();
}
//add new 
    @PostMapping
   public void registerNewStudent(@RequestBody Student student){
       studentservice.addNewStudent(student);
}
//delete
   @DeleteMapping(path = "{studentId}")
   public void deleteStudent(@PathVariable("studentId")Long studentId){
       studentservice.deleteStudent(studentId);
  }
// update
  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable("studentId")long studentId,
                            @RequestParam(required = false)String name,
                            @RequestParam(required = false)String email)
                            {
                                studentservice.updateStudent(studentId,name,email); }
} 
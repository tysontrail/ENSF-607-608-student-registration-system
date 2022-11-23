package course.ensf607.assignment6.student;

import course.ensf607.assignment6.course.Course;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping("/register")
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @PostMapping("/login")
  public Student loginStudent(@RequestBody Student student) {
    return studentService.loginStudent(student);
  }

  @GetMapping("/myCourses")
  public Set<Course> getStudentCourses(@RequestBody Student student) {
    return studentService.getStudentCourses(student);
  }
}

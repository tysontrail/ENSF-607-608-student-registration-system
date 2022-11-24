package course.ensf607.assignment6.course;

import course.ensf607.assignment6.student.Student;
import course.ensf607.assignment6.student.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

  private final CourseService courseService;

  private final StudentService studentService;

  @Autowired
  public CourseController(CourseService courseService, StudentService studentService) {
    this.courseService = courseService;
    this.studentService = studentService;
  }

  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }

  @PostMapping
  public void registerNewCourse(@RequestBody Course course) {
    courseService.addNewCourse(course);
  }

  // @PutMapping("{courseId}/students/{studentId}")
  // public Course enrollStudentToCourse(@PathVariable Long courseId,
  //                                      @PathVariable Long studentId) {
  //     Course course = courseService.getCourseById(courseId);
  //     Student student = studentService.getStudentById(studentId);
  //     course.enrolledStudents(student);
  //     courseService.updateCourse(course);
  //     return course;
  // }

  @PutMapping("enrol/{courseName}/students/{studentId}")
  public Course enrollStudentToCourse(
      @PathVariable String courseName, @PathVariable Long studentId) {
    Course course = courseService.getCourseByName(courseName);
    Student student = studentService.getStudentById(studentId);
    course.enrolledStudents(student);
    courseService.updateCourse(course);
    return course;
  }

  @PutMapping("unenroll/{courseName}/students/{studentId}")
  public Course unenrollStudentToCourse(
      @PathVariable String courseName, @PathVariable Long studentId) {
    Course course = courseService.getCourseByName(courseName);
    Student student = studentService.getStudentById(studentId);
    course.enrolledStudents(student);
    courseService.updateCourse(course);
    return course;
  }
}

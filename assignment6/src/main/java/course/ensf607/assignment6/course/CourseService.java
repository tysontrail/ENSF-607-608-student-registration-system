package course.ensf607.assignment6.course;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  private final CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> getAllCourses() {
    return courseRepository.findAll();
  }

  public List<Course> getAllCoursesSorted() {
    return courseRepository.findAllByOrderByNameAsc();
  }

  public void addNewCourse(Course course) {
    Optional<Course> courseByName = courseRepository.findByName(course.getName());
    if (courseByName.isPresent()) {
      System.out.println(courseByName);
      throw new IllegalStateException("Course already exists!");
    }
    courseRepository.save(course);
  }

  public void updateCourse(Course course) {
    courseRepository.save(course);
  }

  public Course getCourseById(Long courseId) {
    Optional<Course> courseById = courseRepository.findById(courseId);
    if (!courseById.isPresent()) {
      throw new IllegalStateException("Course doesn't exist!");
    }
    return courseById.get();
  }

  public Course getCourseByName(String courseName) {
    Optional<Course> courseByName = courseRepository.findByName(courseName);
    if (!courseByName.isPresent()) {
      throw new IllegalStateException("Course doesn't exist!");
    }
    return courseByName.get();
  }

  public void deleteCourseByName(String courseName) {
    Optional<Course> courseByName = courseRepository.findByName(courseName);
    if (!courseByName.isPresent()) {
      throw new IllegalStateException("Course doesn't exist!");
    }
    courseRepository.delete(courseByName.get());
  }

  public void updateCourseName(String oldCourseName, String newCourseName) {
    Optional<Course> oldCourseByName = courseRepository.findByName(oldCourseName);
    if (!oldCourseByName.isPresent()) {
      throw new IllegalStateException("Course doesn't exist!");
    }
    oldCourseByName.get().setName(newCourseName);
    courseRepository.save(oldCourseByName.get());
  }
}

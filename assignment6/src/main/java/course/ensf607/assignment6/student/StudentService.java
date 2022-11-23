package course.ensf607.assignment6.student;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentByUcid = studentRepository.findStudentByUcid(student.getUcid());
    if (studentByUcid.isPresent()) {
      throw new IllegalStateException("Student already exist!");
    }
    studentRepository.save(student);
  }

  public Student getStudentById(Long studentId) {
    Optional<Student> studentById = studentRepository.findById(studentId);
    if (!studentById.isPresent()) {
      throw new IllegalStateException("student doesn't exist!");
    }
    return studentById.get();
  }

  public Student loginStudent(Student student) {
    Optional<Student> studentByUcid = studentRepository.findStudentByUcid(student.getUcid());
    if (!studentByUcid.isPresent()) {
      throw new IllegalStateException("Student doesn't exist!");
    }
    Student studentQueryResult = studentByUcid.get();
    String password = studentQueryResult.getPassword();
    String username = studentQueryResult.getUsername();
    if (!password.equals(student.getPassword()) || !username.equals(student.getUsername())) {
      throw new IllegalStateException("Student username or password is incorrect!");
    }
    return studentQueryResult;
  }
}

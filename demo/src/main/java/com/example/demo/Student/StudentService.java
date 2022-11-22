package com.example.demo.Student;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  public List<Student> getStudents() {
    return List.of(new Student("Tyson", "Trail", 6969));
  }
}

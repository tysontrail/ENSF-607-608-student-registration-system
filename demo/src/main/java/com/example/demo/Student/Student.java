package com.example.demo.Student;

import com.example.demo.Course.Course;
import com.example.demo.CourseCat.CourseCat;
import com.example.demo.Offering.Offering;
import com.example.demo.Registration.Registration;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student {
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      allocationSize = 1)
  private String fname;

  private String lname;
  private int id;

  private ArrayList<Registration> courseList;

  public Student() {
    this.courseList = new ArrayList<>();
  }

  public Student(String fname, String lname, int id) {
    this.fname = fname;
    this.lname = lname;
    this.id = id;
    this.courseList = new ArrayList<>();
  }

  public void addCourse(Registration r) {
    courseList.add(r);
  }

  public void removeCourse(Registration r) {
    courseList.remove(r);
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String registerForCourse(CourseCat cat, String courseName, int courseId, int secNumber) {

    Course myCourse = cat.searchCat(courseName, courseId);

    if (myCourse == null) {
      System.out.println("Course does not exist in catalog.");
      return "Course does not exist in catalog.";
    }

    // Students can register for a maximum of 6 courses
    if (courseList.size() >= 6) {
      return fname
          + lname
          + " is registered for the maximum number of courses (6). Please remove "
          + "course(s) before attemping to register new course(s).";
    }

    // if the course exists, then we can look at the section
    Offering theOffering = myCourse.getOffering(secNumber);
    if (theOffering == null) {
      return "Course section does not exist in catalog.";
    }

    Registration reg = new Registration();
    reg.register(this, theOffering);
    System.out.println("Successfully registered for course.");
    return "Successfully registered for course.";
  }

  public String removeCourseRegistration(
      CourseCat cat, String courseName, int courseId, int secNumber) {

    if (courseList == null) {
      return "No courses to remove from registrations";
    }
    Course myCourse = cat.searchCat(courseName, courseId);

    if (myCourse == null) {
      return "Course does not exist.";
    }
    // if the course exists, then we can look at the section
    Offering theOffering = myCourse.getOffering(secNumber);
    if (theOffering == null) {
      return "Course section does not exist.";
    }

    for (int i = 0; i < courseList.size(); i++) {
      Registration reg = courseList.get(i);
      if (reg.getTheOffering().equals(theOffering) && reg.getTheStudent().equals(this)) {
        reg.deregister();
        return "Successfully removed course from registrations.";
      }
    }
    return "Course does not exist in registrations.";
  }

  @Override
  public String toString() {
    return "Student{"
        + "name='"
        + fname
        + " "
        + lname
        + '\''
        + ", id="
        + id
        + ", courseList="
        + courseList
        + '}';
  }
}

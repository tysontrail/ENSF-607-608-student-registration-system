package com.example.demo.Registration;

import com.example.demo.Offering.Offering;
import com.example.demo.Student.Student;

public class Registration {

  private Offering theOffering;
  private Student theStudent;

  private char theGrade;

  public void register(Student theStudent, Offering theOffering) {
    this.theStudent = theStudent;
    this.theOffering = theOffering;
    theOffering.addStudent(this);
    theStudent.addCourse(this);
  }

  public Offering getTheOffering() {
    return theOffering;
  }

  public Student getTheStudent() {
    return theStudent;
  }

  public void deregister() {
    theOffering.removeStudent(this);
    theStudent.removeCourse(this);
  }

  public void setTheGrade(char theGrade) {
    this.theGrade = theGrade;
  }

  public char getTheGrade() {
    return theGrade;
  }

  @Override
  public String toString() {
    return "" + theOffering;
  }
}

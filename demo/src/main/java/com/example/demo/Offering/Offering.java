package com.example.demo.Offering;

import com.example.demo.Course.*;
import com.example.demo.Registration.Registration;
import java.util.ArrayList;

public class Offering {

  private int section;
  private Course theCourse;
  private ArrayList<Registration> studentList;

  public void addStudent(Registration r) {
    studentList.add(r);
  }

  public void removeStudent(Registration r) {
    studentList.remove(r);
  }

  public Offering(int section) {

    this.section = section;
    studentList = new ArrayList<>();
  }

  public int getSection() {
    return section;
  }

  public void setSection(int section) {
    this.section = section;
  }

  public void setTheCourse(Course theCourse) {
    this.theCourse = theCourse;
  }

  public boolean isRunning() {
    // Each offering must have a minimum of 8 students to run
    if (studentList.size() < 8) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public String toString() {
    return "\n\t\tOffering{"
        + theCourse.getCourseName()
        + " "
        + theCourse.getCourseId()
        + ": section="
        + section
        + ", isRunning="
        + isRunning()
        + '}';
  }
}

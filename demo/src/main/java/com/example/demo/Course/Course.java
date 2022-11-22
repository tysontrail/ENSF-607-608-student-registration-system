package com.example.demo.Course;

import com.example.demo.Offering.*;
import java.util.ArrayList;

public class Course {

  private String courseName;
  private int courseId;
  private ArrayList<Course> preReqs;
  private ArrayList<Offering> offeringList;

  public Course(String courseName, int courseId) {
    this.courseName = courseName;
    this.courseId = courseId;
    this.offeringList = new ArrayList<Offering>();
    this.preReqs = new ArrayList<Course>();
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public void setPreReqs(ArrayList<Course> preReqs) {
    // this.preReqs = preReqs;
    for (Course c : preReqs) this.preReqs.add(c);
  }

  public Offering getOffering(int i) {
    if (offeringList.get(i - 1) != null) {
      return offeringList.get(i - 1);
    } else {
      return null;
    }
  }

  public void setOfferingList(ArrayList<Offering> offeringList) {
    for (Offering offering : offeringList) {
      offering.setTheCourse(this);
      this.offeringList.add(offering);
    }
  }

  @Override
  public String toString() {
    return "\n\tCourse{"
        + "courseName='"
        + courseName
        + '\''
        + ", courseId="
        + courseId
        + ", preReqs="
        + preReqs
        + ", offerings="
        + offeringList
        + '}';
  }
}

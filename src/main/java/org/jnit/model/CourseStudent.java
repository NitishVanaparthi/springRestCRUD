package org.jnit.model;

public class CourseStudent {

	private int scid;
	private int studentID;
	private String courseId;

	public CourseStudent() {

	}

	public CourseStudent(int scid, int studentID, String courseId) {
		this.scid = scid;
		this.studentID = studentID;
		this.courseId = courseId;
	}

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "CourseStudent [scid=" + scid + ", studentID=" + studentID + ", courseId=" + courseId + "]";
	}

}

package model;

import java.io.*;

public class StudentGrade implements Serializable {
	//private instance variables
	private Student student;
	private Statistics statistics;

	//default constructor
	public StudentGrade() {

	}

	//getter and setters
	public Student getStudent() {
		return student;
	}
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	//print method
	public void print() {
		student.print();
		statistics.print(4);
	}
}

package model;

import java.io.Serializable;

public class Student implements Serializable{
	// variable declaration
	private int SID;
	private int scores[] = new int[5];

	// getters and setter methods
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}

	// overloaded constructor
	public Student(int sID, int[] scores) {
		this.SID = sID;
		this.scores = scores;
	}

	// default constructor
	public Student() {

	}

	// print method
	public void print() {
		// Print the student ID
		System.out.printf("Student ID: %d\n\n", SID);

		// Print the table headers
		System.out.printf("%-12s %-12s\n", "Quiz Number", "Score");
		System.out.println("----------------------------");

		// Iterate through the scores and print them in a table format
		int quizNum = 1;
		for (int score : scores) {
			System.out.printf("%-12d %-12d\n", quizNum, score);
			quizNum++;
		}
		System.out.println();
	}
}
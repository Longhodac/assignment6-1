package adapter;

import java.io.*;
import exception.StudentGradingException;
import model.*;
import util.*;
import drivers.*;

public abstract class StudentAPIlmpl implements StudentAPI {

	public StudentAPIlmpl() {
		try {
			Student[] students = new Student[40];

			for (int i = 0; i < 40; i++) {
				students[i] = new Student();
			}

			Util u1 = new Util("input5.txt");
			students = u1.readFile("input5.txt", students);

			Statistics studentStats = new Statistics();

			studentStats.findlow(students);
			studentStats.findhigh(students);
			studentStats.findavg(students);

			Driver2 d1 = new Driver2();
			StudentGrade[] gradeArray1 = d1.buildStudGradeArray(students, studentStats);
			u1.serializeGrades(gradeArray1);
		} catch (StudentGradingException e) {

		}
	}

	public void printStudentScore(int sid) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(String.valueOf(sid)));
			StudentGrade studentGrade = (StudentGrade) in.readObject();
			int[] studentScores = studentGrade.getStudent().getScores();

			System.out.printf("\nQ1   Q2   Q3   Q4   Q5\n");
			for (int score : studentScores) {
				System.out.printf("%-5d", score);
			}
		} catch (Exception e) {
			System.out.printf("Error: %s\n", e);
			System.exit(1);
		}
	}

	public void printStatistics() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("1234"));
			StudentGrade studentGrade = (StudentGrade) in.readObject();
			Statistics statistics = studentGrade.getStatistics();

			statistics.print(4);
		} catch (Exception e) {
			System.out.printf("Error: %s\n", e);
			System.exit(1);
		}
	}
}

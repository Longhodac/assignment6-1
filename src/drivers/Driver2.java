package drivers;

import model.*;
import util.Util;
import exception.StudentGradingException;

public class Driver2 {

	public static void main(String[] args) {
		try {
			boolean debug = true;

			Student run1[] = new Student[40];
			for (int i = 0; i < 40; i++) {
				run1[i] = new Student();
			}

			Student run2[] = new Student[40];
			for (int i = 0; i < 40; i++) {
				run2[i] = new Student();
			}

			Util u1 = new Util("input.txt");
			run1 = u1.readFile("input.txt", run1);

			Statistics statrun1 = new Statistics();
			statrun1.findlow(run1);
			statrun1.findhigh(run1);
			statrun1.findavg(run1);

			Driver2 d1 = new Driver2();
			StudentGrade[] gradeArray = d1.buildStudGradeArray(run1, statrun1);

			if (debug) {
				for (int i = 0; i < gradeArray.length; i++) {
					if (gradeArray[i].getStudent().getSID() > 0) {
						gradeArray[i].print();
					} else {
						break;
					}
				}
			}

			u1.serializeGrades(gradeArray);
			u1.deserializeGrades(1234);

			Util u2 = new Util("input2.txt");
			run2 = u2.readFile("input2.txt", run2);

			Statistics statrun2 = new Statistics();
			statrun2.findlow(run2);
			statrun2.findhigh(run2);
			statrun2.findavg(run2);

			Driver2 d2 = new Driver2();
			StudentGrade[] gradeArray2 = d2.buildStudGradeArray(run2, statrun2);

			if (debug) {
				for (int i = 0; i < gradeArray2.length; i++) {
					gradeArray2[i].print();
				}
			}

			u2.serializeGrades(gradeArray2);
			u2.deserializeGrades(1234);

			Student run3[] = new Student[40];
			for (int i = 0; i < 40; i++) {
				run3[i] = new Student();
			}
			Util u3 = new Util("input3.txt");
			run3 = u3.readFile("input3.txt", run3);

			Statistics statrun3 = new Statistics();
			statrun3.findlow(run3);
			statrun3.findhigh(run3);
			statrun3.findavg(run3);

			Driver2 d3 = new Driver2();
			StudentGrade[] gradeArray3 = d3.buildStudGradeArray(run3, statrun3);

			if (debug) {
				for (int i = 0; i < gradeArray3.length; i++) {
					gradeArray3[i].print();
				}
			}

			u3.serializeGrades(gradeArray3);
			u3.deserializeGrades(1947);

			Student run4[] = new Student[40];
			for (int i = 0; i < 40; i++) {
				run4[i] = new Student();
			}
			Util u4 = new Util("input4.txt");
			run4 = u4.readFile("input4.txt", run4);

			Statistics statrun4 = new Statistics();
			statrun4.findlow(run4);
			statrun4.findhigh(run4);
			statrun4.findavg(run4);

			Driver2 d4 = new Driver2();
			StudentGrade[] gradeArray4 = d4.buildStudGradeArray(run4, statrun4);

			if (debug) {
				for (int i = 0; i < gradeArray4.length; i++) {
					gradeArray4[i].print();
				}
			}

			u4.serializeGrades(gradeArray4);
			u4.deserializeGrades(2134);

			Student run5[] = new Student[40];
			for (int i = 0; i < 40; i++) {
				run5[i] = new Student();
			}
			Util u5 = new Util("input5.txt");
			run5 = u5.readFile("input5.txt", run5);

			Statistics statrun5 = new Statistics();
			statrun5.findlow(run5);
			statrun5.findhigh(run5);
			statrun5.findavg(run5);

			Driver2 d5 = new Driver2();
			StudentGrade[] gradeArray5 = d5.buildStudGradeArray(run5, statrun5);

			if (debug) {
				for (int i = 0; i < gradeArray3.length; i++) {
					gradeArray5[i].print();
				}
			}

			u5.serializeGrades(gradeArray5);
			u5.deserializeGrades(9893);
		} catch (StudentGradingException e) {
			e.printStackTrace();
		}
	}

	public StudentGrade[] buildStudGradeArray(Student[] students, Statistics statistics) {
		StudentGrade[] studentGrades = new StudentGrade[students.length];
		for (int i = 0; i < students.length; i++) {
			studentGrades[i] = new StudentGrade();
			studentGrades[i].setStudent(students[i]);
			studentGrades[i].setStatistics(statistics);
		}
		return studentGrades;
	}
}

/* output:
tudent ID: 1234

Quiz Number  Score
----------------------------
1            52
2            7
3            100
4            78
5            34

Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73
Student ID: 2134

Quiz Number  Score
----------------------------
1            90
2            36
3            90
4            77
5            30

Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73
Student ID: 3124

Quiz Number  Score
----------------------------
1            100
2            45
3            20
4            90
5            70

Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73
Student ID: 4532

Quiz Number  Score
----------------------------
1            11
2            17
3            81
4            32
5            77

Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73
Student ID: 5678
.....
 */
package model;

import java.io.Serializable;

public class Statistics implements Serializable {
	private int[] lowscores = new int[5];
	private int[] highscores = new int[5];
	private float[] avgscores = new float[5];

	public void findlow(Student[] students) {
		int length = lowscores.length;
		for (int i = 0; i < length; i++) {
			lowscores[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < length; i++) {
			for (Student student : students) {
				if (student.getSID() > 0 && student.getScores()[i] < lowscores[i]) {
					lowscores[i] = student.getScores()[i];
				}
			}
		}
	}

	public void findhigh(Student[] students) {
		int length = highscores.length;
		for (int i = 0; i < length; i++) {
			highscores[i] = 0;
		}

		for (int i = 0; i < length; i++) {
			for (Student student : students) {
				if (student.getSID() > 0 && student.getScores()[i] > highscores[i]) {
					highscores[i] = student.getScores()[i];
				}
			}
		}
	}

	public void findavg(Student[] students) {
		int length = avgscores.length;
		int count = 0;
		for (Student student : students) {
			if (student.getSID() > 0) {
				count++;
			}
		}

		for (int i = 0; i < length; i++) {
			avgscores[i] = 0;
		}

		for (int i = 0; i < length; i++) {
			for (Student student : students) {
				avgscores[i] += student.getScores()[i];
			}
			avgscores[i] /= count;
		}
	}

	public void calc(Student[] students) {
		findavg(students);
		findhigh(students);
		findlow(students);
	}

	public void print(int option) {
		switch (option) {
			case 1:
				System.out.printf("Low scores: ");
				for (int low : lowscores) {
					System.out.printf("%d ", low);
				}
				System.out.println();
				break;
			case 2:
				System.out.printf("High scores: ");
				for (int high : highscores) {
					System.out.printf("%d ", high);
				}
				System.out.println();
				break;
			case 3:
				System.out.printf("Average scores: ");
				for (float avg : avgscores) {
					System.out.printf("%.2f ", avg);
				}
				System.out.println();
				break;
			case 4:
				if (lowscores[0] != Integer.MAX_VALUE) {
					print(1);
					print(2);
					print(3);
				} else {
					System.out.println("No student data available.");
				}
				break;
			default:
				System.out.println("Invalid option. Please input an integer between 1 and 4.");
		}
	}

	public void printData(Student[] students) {
		System.out.println("\nID  Q1   Q2   Q3   Q4   Q5");
		for (Student student : students) {
			if (student.getSID() != 0) {
				System.out.printf("%4d ", student.getSID());
				for (int score : student.getScores()) {
					System.out.printf("%5d", score);
				}
				System.out.println();
			}
		}
	}
}

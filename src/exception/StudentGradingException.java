package exception;

import java.io.*;
import java.time.Instant;
import java.util.*;
import util.*;
import model.*;

public class StudentGradingException extends Exception {
	private int errorno;
	private String errormsg;

	public StudentGradingException() {
		super();
	}

	public StudentGradingException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	public StudentGradingException(int errorno) {
		super();
		this.errorno = errorno;
	}

	public StudentGradingException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
	}

	public int getErrorno() {
		return errorno;
	}

	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public void log(){
		try {
			FileWriter a1 = new FileWriter("log.txt", true);
			Instant now = Instant.now();
			a1.write(String.valueOf(now));
			a1.write(this.errormsg);
			a1.close();
		}
		catch(IOException e) {
			this.fileNotFound();
		}
	}

	public void printmyproblem() {
		System.out.printf("Error: %s\n", this.errormsg);
	}

	public void fileNotFound() {
		this.setErrorno(1);
		this.setErrormsg("Error: File not found.");
		this.log();
		this.printmyproblem();
	}

	public void scoreNotFound() {
		this.setErrorno(2);
		this.setErrormsg("Error: Score not found.");
		this.log();
		this.printmyproblem();
	}

	public void improperFormat() {
		this.setErrorno(3);
		this.setErrormsg("Error: Improper file format.");
		this.log();
		this.printmyproblem();
	}

	public Student[] fix1(Student[] stu) {
		System.out.printf("Please enter a new file path:\n");
		Scanner in = new Scanner(System.in);
		String newFilePath = in.nextLine();
		Util u1 = new Util();
		try {
			u1.readFile(newFilePath, stu);
		} catch (Exception e) {
			System.out.printf("Error: File still not found.\n");
		}
		return stu;
	}

	public Student[] fix2(Student[] stu) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Successfully read the following data:\n");
		Statistics labtest = new Statistics();
		labtest.printData(stu);

		System.out.printf("The first zero in the data might indicate missing information.\n");
		System.out.printf("Please enter the missing data manually.\n");

		System.out.printf("Enter the line number of the data:\n");
		int missingLine = in.nextInt();

		System.out.printf("Enter the quiz number:\n");
		int missingQuizNumber = in.nextInt();

		while(missingQuizNumber < 1 || missingQuizNumber > 5) {
			System.out.printf("Invalid Quiz Number. Please re-enter:\n");
			missingQuizNumber = in.nextInt();
		}

		System.out.printf("Enter the missing score:\n");
		int newQuizScore = in.nextInt();

		int[] missingStudentScores = stu[missingLine - 2].getScores();
		missingStudentScores[missingQuizNumber - 1] = newQuizScore;
		stu[missingLine - 2].setScores(missingStudentScores);

		labtest.findlow(stu);
		labtest.findhigh(stu);
		labtest.findavg(stu);
		labtest.printData(stu);
		labtest.print(4);
		return stu;
	}

	public Student[] fix(int errorno, Student[] stu) {
		Student[] stu1 = new Student[stu.length];
		switch (errorno) {
			case 1:
				stu1 = fix1(stu);
				break;
			case 2:
				stu1 = fix2(stu);
				break;
		}
		return stu1;
	}
}

// Long HoDac
// 12/3/2023
// Assignment 6

/*Design:
Package: drivers

Purpose: Contains classes for testing various components of the application.
Classes:
Driver1, Driver2, Driver3: Each corresponds to a specific requirement of the assignment, executing test cases and demonstrating functionality.
Package: exception

Purpose: Manages custom exceptions related to student grading.
Classes:
StudentGradingException: Handles exceptions specific to student grading processes, logging errors to log.txt.
Package: model

Purpose: Defines core data models for the application.
Classes:
Student: Manages student ID and grade data.
Statistics: Calculates and stores statistics such as lowest, highest, and average scores.
StudentGrade: Aggregates a Student object and a Statistics object, supporting serialization.
Package: util

Purpose: Provides utility functions, primarily for file input/output.
Classes:
Util: Handles reading from and writing to text files, parsing input to initialize Student objects.
Package: adapter

Purpose: Contains API classes for interacting with student data.
Classes:
SAPI, StudentAPI: Interfaces defining methods for student score and statistics printing.
StudentAPIlmpl: An abstract class implementing StudentAPI, managing student data reading and processing.
Key Classes and Their Design:

Driver Class (resides in drivers package)

Functionality: Initializes Student, Util, and Statistics objects to demonstrate file I/O and data processing. It doesn't include direct print statements but calls print methods from Student and Statistics.
Util Class (in util package)

Functionality: Manages file I/O, parsing text files to initialize Student array objects. It uses FileReader and BufferedReader for file reading.
Statistics Class (in model package)

Functionality: Computes statistical data like low, high, and average scores from Student objects. Includes a method print to display this data.
Student Class (in model package)

Functionality: Stores student ID and scores, providing getters and setters. Includes a print method to display student data.
StudentGrade Class (in model package)

Functionality: Combines Student and Statistics objects. Supports data serialization.
StudentGradingException Class (in exception package)

Functionality: Custom exception handling, including logging and displaying error messages. It includes methods for different types of grading-related exceptions.
StudentAPI Interface and StudentAPIImpl Abstract Class (in adapter package)

Functionality: Defines and implements methods for printing student scores and class statistics. The StudentAPIImpl class constructor also handles data initialization and serialization.
 */

package drivers;

import model.Statistics;
import model.Student;
import util.Util;
import exception.StudentGradingException;

public class Driver1 {

	public static void main(String[] args){
		try {

		Student run1[] = new Student[40];


		for (int i = 0; i < 40; i++) {
			run1[i] = new Student();
		}


		Util u1 = new Util("input.txt");

		run1 = u1.readFile("input.txt", run1);

		Statistics statrun1 = new Statistics();

		statrun1.calc(run1);
		

		statrun1.printData(run1);
		statrun1.print(4);
		

		Student run2[] = new Student[40];


		for (int i = 0; i < 40; i++) {
			run2[i] = new Student();
		}
		

		Util u2 = new Util("input2.txt");

		run2 = u2.readFile("input2.txt",run2);

		Statistics statrun2 = new Statistics();
		
		statrun2.calc(run2);
		statrun2.printData(run2);
		statrun2.print(4);
		

		Student run3[] = new Student[40];


		for (int i = 0; i < 40; i++) {
			run3[i] = new Student();
		}	

		Util u3 = new Util("input2.txt");

		run3 = u3.readFile("input2.txt",run3);

		Statistics statrun3 = new Statistics();

		statrun3.calc(run3);
		statrun3.printData(run3);
		statrun3.print(4);
				

		Student run4[] = new Student[40];


		for (int i = 0; i < 40; i++) {
			run4[i] = new Student();
		}	

		Util u4 = new Util("input5.txt");

		run4 = u4.readFile("input5.txt",run4);

		Statistics statrun4 = new Statistics();

		statrun4.calc(run4);
		statrun4.printData(run4);
		statrun4.print(4);
				
		}catch(StudentGradingException e) {
			
		}
	}
}

/* output:
ID  Q1   Q2   Q3   Q4   Q5
1234    52    7  100   78   34
2134    90   36   90   77   30
3124   100   45   20   90   70
4532    11   17   81   32   77
5678    20   12   45   78   34
6134    34   80   55   78   45
7874    60  100   56   78   78
8026    70   10   66   78   56
9893    34    9   77   78   20
1947    45   40   88   78   55
2877    55   50   99   78   80
3189    22   70  100   78   77
4602    89   50   91   78   60
5405    11   11    0   78   10
6999     0   98   89   78   20
Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73

ID  Q1   Q2   Q3   Q4   Q5
1243    50   70  100   78   34
Low scores: 50 70 100 78 34
High scores: 50 70 100 78 34
Average scores: 50.00 70.00 100.00 78.00 34.00

ID  Q1   Q2   Q3   Q4   Q5
1243    50   70  100   78   34
Low scores: 50 70 100 78 34
High scores: 50 70 100 78 34
Average scores: 50.00 70.00 100.00 78.00 34.00

ID  Q1   Q2   Q3   Q4   Q5
No student data available.

 */
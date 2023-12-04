package drivers;

import adapter.*;


public class Driver3 {
	public static void main(String[]args) {
			StudentAPI a1;
			a1 = new SAPI();
			//could be changed
			a1.printStudentScore(1234);
			a1.printStatistics();
	}		
}

/*output:
Q1   Q2   Q3   Q4   Q5
52   7    100  78   34   Low scores: 0 7 0 32 10
High scores: 100 100 100 90 80
Average scores: 46.20 42.33 70.47 75.67 49.73
 */
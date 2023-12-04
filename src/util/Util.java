package util;

import java.io.*;
import exception.StudentGradingException;
import model.*;
import java.util.*;

import model.Student;

public class Util {
    private String fname;

    // default constructor
    public Util() {
    }
    
    // overloaded constructor
    public Util(String fname) {
    	this.fname = fname;
    }
    
	//getter and setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Student[] readFile(String fname, Student [] s) throws StudentGradingException{
		int count = 0;
		
		//Reads the file and builds student array.
		try {
			//Open the file using FileReader Object.
			FileReader file = new FileReader(fname);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				count++;
				// count > 41 includes header check
				if (line == null || count > 41)
					eof = true;
				else {
					if(count > 1) {
						s[count - 2] = new Student();
						String temp;
						int [] scores = new int[5];
						
						// Tokenizes each line using StringTokenizer Object
						StringTokenizer st = new StringTokenizer(line);
						
						//Each token is converted from String to Integer using parseInt method
						s[count - 2].setSID(Integer.parseInt(st.nextToken()));
											
						for(int i = 0; i < 5 && st.hasMoreTokens(); i++) {
							temp = st.nextToken();
							scores[i] = Integer.parseInt(temp);
						}
						//Value is then saved in the right property of Student Object.	
						s[count - 2].setScores(scores);
					}
				}
			}
			buff.close(); 
		} catch (IOException e) {
			StudentGradingException f = new StudentGradingException();
			f.fileNotFound();
			f.fix(1, s);
		}
		
		catch(NoSuchElementException e) {
			StudentGradingException f = new StudentGradingException();
			f.scoreNotFound();
			Student [] s1 = f.fix(2, s);
			this.readFile(fname, s1);
		}
		return s;								
	}
	
	//method to serialize all objects 
		public void serializeGrades(StudentGrade [] grades)
		{	try {
			for(int i = 0; i < grades.length; i++) {
				int currID = grades[i].getStudent().getSID();
				String filename = String.valueOf(currID);
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
				out.writeObject(grades[i]);
				out.close();
				}
			}catch(IOException e) {	
				System.out.printf("Error: " + e);
		        System.exit(1);
			}
		}
		
	//method to deserialize objects
		public void deserializeGrades(int id)
		{
				try {
					ObjectInputStream in =  new ObjectInputStream(new FileInputStream(String.valueOf(id)));
					StudentGrade newStudent = (StudentGrade)in.readObject();
					newStudent.print();
				} catch (Exception e) {
					System.out.printf("Error: " + e);
			        System.exit(1);
				}
				
		}
}
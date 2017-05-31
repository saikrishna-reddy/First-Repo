package com.coviam.studentdata.write;

import java.lang.reflect.Field;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass {

	public static void main(String []arg) throws ClassNotFoundException{
		String firstname;
		String middlename;
		String lastname;
		String college;
		String course;
		int studentid;

		//XMLWriter x = new XMLWriter();
		
		firstname = "Sai";
		middlename = "Krishna";
		lastname = "Reddy";
		college = "IIITDMJ";
		course = "Java";
		studentid = 67;
		StudentDetails s = new StudentDetails(firstname, lastname, middlename, college, course, studentid);
		
		//x.write(s);
		
		firstname = "Nihal";
		middlename = "Gurjar";
		lastname = "Gurjar";
		college = "IIITDMJ";
		course = "Java";
		studentid = 113;
		StudentDetails s1 = new StudentDetails(firstname, lastname, middlename, college, course, studentid);
		
		//x.write(s1);
		
		firstname = "M";
		middlename = "N";
		lastname = "Kaushik";
		college = "IIITDMJ";
		course = "Java";
		studentid = 107;
		StudentDetails s2 = new StudentDetails(firstname, lastname, middlename, college, course, studentid);
		
		//x.write(s2);
		
		try {
			Class<StudentDetails> sd = (Class<StudentDetails>) Class.forName("com.coviam.studentdata.write.StudentDetails");
			System.out.println("Fields : "+Arrays.toString(sd.getDeclaredFields()));
			System.out.println("Methods : "+Arrays.toString(sd.getDeclaredMethods()));
			System.out.println("Constructors : "+Arrays.toString(sd.getConstructors()));
			try {
				Field f = sd.getDeclaredField("firstName");
				f.setAccessible(true);
				firstname = (String) f.get(s);
				System.out.println("FirstName : "+firstname);
				f = sd.getDeclaredField("lastName");
				f.setAccessible(true);
				lastname = (String) f.get(s);
				System.out.println("LastName : "+lastname);	
				f = sd.getDeclaredField("middleName");
				f.setAccessible(true);
				middlename = (String)f.get(s);
				System.out.println("MiddleName : "+middlename);
				f = sd.getDeclaredField("college");
				f.setAccessible(true);
				college = (String) f.get(s);
				System.out.println("College Name : "+college);
				f = sd.getDeclaredField("course");
				f.setAccessible(true);
				course = (String) f.get(s);
				System.out.println("Course : "+course);
				f = sd.getDeclaredField("studentID");
				f.setAccessible(true);
				studentid = (int) (f.get(s));
				System.out.println("StudentID : "+studentid);
			} 
			catch (IllegalAccessException ex) {
	            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
	        } 
			catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	
	
	
}

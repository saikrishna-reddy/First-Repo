package com.coviam.studentdata.write;

/*
 * Created by Sai Krishna on 26/05/17
 * College: IIITDMJ
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter implements Writer {
	String filepath;
	File file;
	FileWriter writer;
	Element rootElement;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;

	@Override
	public boolean write(StudentDetails s) {

		// TODO Auto-generated method stub
		filepath = "/Users/coviam/Desktop/StudentDetails.xml";
		file = new File(filepath);
		file.getParentFile().mkdirs();
		try {
			writer = new FileWriter(file, true);
		} catch (IOException e) {
			System.out.println("The specified path doesnot exist and cannot be created.");
			e.printStackTrace();
		}
		try {

			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();

			// create rootelement
			rootElement = doc.createElement("StudentDetails");
			doc.appendChild(rootElement);

			// create child element for student
			Element student = doc.createElement("Student");
			createAttr(student, s, "StudentID", "" + s.getStudentID(), doc);
			createAttr(student, s, "FirstName", s.getFirstName(), doc);
			createAttr(student, s, "LastName", s.getLastName(), doc);
			createAttr(student, s, "MiddleName", s.getMiddleName(), doc);
			createAttr(student, s, "College", s.getCollege(), doc);
			createAttr(student, s, "Course", s.getCourse(), doc);

			student.appendChild(doc
					.createTextNode("\n" + s.getFirstName() + " " + s.getMiddleName() + " " + s.getLastName() + "\n"));
			rootElement.appendChild(student);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] ar) {
		String firstname;
		String middlename;
		String lastname;
		String college;
		String course;
		int studentid;

		XMLWriter x = new XMLWriter();

		firstname = "Sai";
		middlename = "Krishna";
		lastname = "Reddy";
		college = "IIITDMJ";
		course = "Java";
		studentid = 67;
		StudentDetails s = new StudentDetails(firstname, lastname, middlename, college, course, studentid);

		x.write(s);

		firstname = "Nihal";
		middlename = "Gurjar";
		lastname = "Gurjar";
		college = "IIITDMJ";
		course = "Java";
		studentid = 113;
		StudentDetails s1 = new StudentDetails(firstname, lastname, middlename, college, course, studentid);

		x.write(s1);

		firstname = "M";
		middlename = "N";
		lastname = "Kaushik";
		college = "IIITDMJ";
		course = "Java";
		studentid = 107;
		StudentDetails s2 = new StudentDetails(firstname, lastname, middlename, college, course, studentid);

		x.write(s2);

	}

	private void createAttr(Element rootElement, StudentDetails s, String tagName, String tagText, Document doc) {

		Attr attrType1 = doc.createAttribute(tagName);
		attrType1.setValue(tagText);
		rootElement.setAttributeNode(attrType1);

	}

}
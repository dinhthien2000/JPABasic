package stu.nvt.java;


import java.util.List;

import stu.nvt.java.dao.StudentDao;
import stu.nvt.java.entities.Student;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world");


		Student student = new Student("DinhThien","TH2");
		StudentDao  dao = new StudentDao();
		Student viewStudent =  dao.createStudent(student);
		
		System.out.println(viewStudent.toString());
		List<Student> list = dao.findAllStudent();
		
		for (Student student2 : list) {
			System.out.println(student2.toString());
		}
	}

}

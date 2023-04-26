package stu.nvt.java.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@NamedQueries({
@NamedQuery(name = "Student.findAll", query = "select s from Student s"),
@NamedQuery(name = "Student.findById",query = "select s from Student s where s.id = :id")
})
@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String classroom;
	
	@Override
	public String toString() {

		return "ID: " + getId() + " - Name: " + getName() + " - Classroom: " + getClassroom();
	}

	public Student(String name, String classroom) {
		super();
		this.name = name;
		this.classroom = classroom;
	}
}

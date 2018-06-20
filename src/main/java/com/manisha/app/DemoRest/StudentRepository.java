package com.manisha.app.DemoRest;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

	List<Student> studs;

	public StudentRepository() {
		studs = new ArrayList<>();

		Student s1 = new Student();
		s1.setName("Laharee");
		s1.setPoints(80);
		s1.setId(2);

		Student s2 = new Student();
		s2.setName("Harsh");
		s2.setPoints(60);
		s2.setId(3);

		studs.add(s1);
		studs.add(s2);
	}

	public List<Student> getListofStudents(){
		return studs;
	}


	public Student getParticularStudent(int id ) {
		for(Student s : studs) {
			if(s.getId()==id)
				return s;
		}
		return new Student();
	}

	public void createNewStudent(Student s) {
		studs.add(s);
	}

}

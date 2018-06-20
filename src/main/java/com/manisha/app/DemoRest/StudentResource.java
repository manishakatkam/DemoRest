package com.manisha.app.DemoRest;


import java.util.List;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	StudentRepository sr = new StudentRepository(); 

	//returns a single object
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent() {
		//System.out.println("get students method called");
		Student s1 = new Student();
		s1.setName("Manisha");
		s1.setPoints(60);
		s1.setId(1);

		return s1;  
	}  


	//returns the  list of objects
	@Path("listofstudents")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudents(){
		Student s1 = new Student();
		s1.setName("Laharee");
		s1.setPoints(80);
		s1.setId(2);

		Student s2 = new Student();
		s2.setName("Harsh");
		s2.setPoints(60);
		s2.setId(3);

		List<Student> list = Arrays.asList(s1,s2);

		return list;
	}

	// returns the data in both XML and JSON
	@Path("listofstudentsbothjsonandxml")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // produces means server sends and client accepts
	public List<Student> getStudents1(){
		Student s1 = new Student();
		s1.setName("Laharee");
		s1.setPoints(80);
		s1.setId(2);

		Student s2 = new Student();
		s2.setName("Harsh");
		s2.setPoints(60);
		s2.setId(3);

		List<Student> list = Arrays.asList(s1,s2);

		return list;
	}

	// returns the list of objects through a repository ( a mock database)
	@Path("listthroughrepository")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getListThroughtRepository(){

		return sr.getListofStudents();
	}

	// returns any particular object from repository
	@Path("particularobjectthroughrepository/{i}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getStudentThroughtRepository(@PathParam("i") int i){

		return sr.getParticularStudent(i);
	}


	// adds a new object to the list
	@POST
	@Path("createstudent")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // consumes means client sends and server accepts
	public Student createStudent(Student s) {

		System.out.println(s);
		sr.createNewStudent(s);
		return s; 
	}




}

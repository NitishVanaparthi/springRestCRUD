package org.jnit.restControllersPractice;

import java.util.ArrayList;
import java.util.List;

import org.jnit.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StudentControllerImpl {

	@RequestMapping(value = "/allStudents", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> studentList = createStudents();
		if (studentList.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}

	@RequestMapping(value = "/oneStudent/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> findStudentById(String name) {
		Student student = new Student();
		student.setStudentId(258);
		student.setStudentName("Nitish Vanaparthi");
		student.setStudentAddress("Lewisville Tx");
		if (student.equals(null)) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);// You
																		// many
																		// decide
																		// to
																		// return
																		// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@RequestMapping(value = "/createStudent/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Student student, UriComponentsBuilder ucBuilder) {

		System.out.println("Creating User " + student.getStudentName());

		if (student.getStudentName().equals("nitish")) {
			System.out.println("A User with name " + student.getStudentName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(student.getStudentName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	public List<Student> createStudents() {

		List<Student> studentList = new ArrayList<Student>();

		Student st1 = new Student();
		st1.setStudentId(258);
		st1.setStudentName("Nitish Vanaparthi");
		st1.setStudentAddress("Lewisville Tx");

		Student st2 = new Student();
		st2.setStudentId(259);
		st2.setStudentName("slow");
		st2.setStudentAddress("fremont ca");

		studentList.add(st1);
		studentList.add(st2);
		System.out.println(studentList);

		return studentList;
	}

}
